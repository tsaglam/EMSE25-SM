library(ggplot2)
library(extrafont)
library(cowplot)
library(magrittr)
library(dplyr)
source("data_processing.R")
source("significance.R")
source("table_gen.R")


font_import()
loadfonts(quiet = TRUE)
#theme_set(theme_cowplot(font_size=12, font_family="Linux Libertine"))


# functions defined in data_processing.R
data <- read_from_csv()
data <- add_approach_label(data) # sunday
relevantTupleTypes <-
  c("Original-Original", "Plag-Original", "Plag-Plag")
data <- subset(data, tupleType %in% relevantTupleTypes)
data <- add_tuple_type_label(data)
data <- add_dataset_label(data)

blue <- "#005AA0"
blue50 <- "#7FACCF"
green <- "#8CB423"
green50 <- "#C5D990"
orange <- "#F0781E"
orange50 <- "#F7BB8E"

fill_colors <- c(green, orange, blue)

### THESE ARE DIFFSTATS FOR APPROACH <--> BASE FOR EACH TUPLE TYPE

bl <- "Base"
dsdiffstats <- data %>%
  group_by(tool, tupleTypeLabel, dataset) %>%
  summarize(
    median_val = median(value, na.rm = TRUE),
    avg_val = mean(value, na.rm = TRUE),
    lower_q = quantile(value, 0.25, na.rm = TRUE),
    upper_q = quantile(value, 0.75, na.rm = TRUE),
    .groups = 'drop'
  )

# Extract baseline statistics for each tupleTypeLabel and dataset
baseline_stats <- dsdiffstats %>%
  filter(tool == bl) %>%
  select(dataset, tupleTypeLabel, baseline_median = median_val, baseline_avg = avg_val,
         baseline_lower_q = lower_q, baseline_upper_q = upper_q)

# Join baseline statistics with the main summary data and calculate differences between tool and Base
dsdiffstats_with_diff <- dsdiffstats %>%
  filter(tool != bl) %>%
  left_join(baseline_stats, by = c("dataset", "tupleTypeLabel")) %>%
  mutate(
    avg_diff = avg_val - baseline_avg,
    median_diff = median_val - baseline_median,
    q_diff = lower_q - baseline_upper_q,
  ) %>%
  select(dataset, tool, tupleTypeLabel, avg_diff, median_diff, q_diff) %>%
  arrange(dataset, tool)

### THESE ARE DIFFSTATS FOR PLAG <--> ORIG FOR EACH APPROACH

baseline <- "Original Pairs"

# Group by tool, tupleTypeLabel, and dataset to calculate statistics separately for each dataset
summary_data <- data %>%
  group_by(tool, tupleTypeLabel, dataset) %>%
  summarize(
    median_val = median(value),
    avg_val = mean(value),
    min_val = min(value),
    max_val = max(value),
    lower_q = quantile(value, 0.25),
    upper_q = quantile(value, 0.75)
  ) %>%
  # Mutate within each group of dataset to calculate the differences from the baseline
  group_by(tool, dataset) %>%
  mutate(
    avg_diff = avg_val - avg_val[tupleTypeLabel == baseline],
    median_diff = median_val - median_val[tupleTypeLabel == baseline],
    q_diff = lower_q - upper_q[tupleTypeLabel == baseline],
    minmax_diff = min_val - max_val[tupleTypeLabel == baseline],
  ) %>%
  ungroup()

summary_data$tool <- as.factor(summary_data$tool)

# Filter out the baseline for final output
summary_data_filtered <- summary_data %>%
  filter(tupleTypeLabel != baseline)

generate_diff_table(summary_data_filtered, "refactor")


# function defining the plot
do_the_plot <- function(data, metric, legend_position = "none") {
  data <-
    subset(data,
           plagTypeGroup != '' &
             variable %in% c("similarity", metric))
  
  plot <-
    ggplot(data, aes(x = approach, y = value, fill = tupleTypeLabel)) +
    geom_boxplot(width = 0.6, outlier.size = 0.5, outlier.alpha=0.75) +
    #geom_violin(alpha=0.5, width=1) +
    #stat_summary(fun.y=mean, geom="point", shape=1, size=2) +
    #stat_summary( fun.y=mean, colour="red", geom="line", size = 3) +
    #stat_summary(fun.y = mean, geom = "errorbar", aes(ymax = ..y.., ymin = ..y..),
    #             width = .325, linetype = "dashed") +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "%"),
      name = "Similarity"
    ) +
    expand_limits(y = c(0, 100)) +
    facet_wrap( ~ dataset, nrow = 3, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = legend_position,
      text = element_text(size = 12, family = "Linux Libertine O"),
      # family=libertine
      legend.margin = margin(0, 50, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}

# create and save the plots for all plagiarism tools
groups <- unique(data$plagTypeGroup)
metric <- "avg.similarity"

do_the_plot(data, metric, "bottom")

width100 <- 15.24 # 14 / 2
height = 21 / 3 * 2 + 1 #16 # / 1.6 #/ 1.34

plot_and_save <- function(width, metric) {
  do_the_plot(data, metric, "bottom")
  file_name <-
    paste('./output/eval-refactor_', metric, '.pdf', sep = "")
  ggsave(file_name,
         device = cairo_pdf,
         width = width,
         height = height, units = "cm")
}

plot_and_save(width100, "max.similarity")
plot_and_save(width100, "avg.similarity")

test_results2 <- stat_test_table2(data)
generate_table(test_results2, "to-base-refactor", 6, c("ds", "Variant", "Pairs", "$p$", "$W$", "$\\delta$", "$\\delta\\,Int.$", "$\\delta$ 95\\% CI", "n"))
#test_results <- stat_test_table(data)
#generate_table(test_results, "sig-plag-orig-refactor", 4, c("Dataset", "Variant", "$p$", "$W$", "$\\delta$", "$\\delta\\,Int.$", "$\\delta$ 95\\% CI"))
