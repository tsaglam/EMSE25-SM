library(ggplot2)
library(extrafont)
library(cowplot)
library(magrittr)
library(dplyr)
source("data_processing.R")
source("table_gen.R")
source("significance.R")

font_import()
loadfonts(quiet = TRUE)
# theme_set(theme_cowplot(font_size=12, font_family="Linux Libertine"))

# functions defined in data_processing.R
data <- read_from_csv()
data <- add_approach_label(data)
relevantTupleTypes <-
  c("Original-Original", "Plag-Original", "Plag-Plag")
data <- subset(data, tupleType %in% relevantTupleTypes)
data <- add_tuple_type_label(data)

blue <- "#005AA0"
blue50 <- "#7FACCF"
green <- "#8CB423"
green50 <- "#C5D990"
orange <- "#F0781E"
orange50 <- "#F7BB8E"

fill_colors <- c(green, blue, orange)

# Create summary stats
baseline <- "Original Pairs"

filtered_date <- subset(data, variable != "avg.similarity")

summary_data <- filtered_date %>%
  group_by(approach, plagTypeGroup, tupleTypeLabel) %>%
  summarize(
    median_val = median(value),
    avg_val = mean(value),
    lower_q = quantile(value, 0.25),
    upper_q = quantile(value, 0.75),
    min_val = min(value),
    max_val = max(value)
  ) %>%
  group_by(approach, plagTypeGroup) %>%
  mutate(
    avg_diff = avg_val - avg_val[tupleTypeLabel == baseline],
    median_diff = median_val - median_val[tupleTypeLabel == baseline],
    q_diff = lower_q - upper_q[tupleTypeLabel == baseline],
    minmax_diff = min_val - max_val[tupleTypeLabel == baseline],
  ) %>%
  ungroup()
summary_data$approach <- as.factor(summary_data$approach)
summary_data <- summary_data %>%
  filter(tupleTypeLabel != baseline)

generate_diff_table(summary_data, "gpt-gen")

# Create the summary plot
summary_data_plot <-
  ggplot(summary_data, aes(x = approach, group = tupleTypeLabel)) +
  geom_line(aes(y = avg_diff, color = tupleTypeLabel, linetype = "Average"),
            size = 1) +
  geom_line(aes(y = median_diff, color = tupleTypeLabel, linetype = "Median"),
            size = 1) +
  geom_line(aes(y = q_diff, color = tupleTypeLabel, linetype = "Quantile"),
            size = 1) +
  geom_line(aes(y = minmax_diff, color = tupleTypeLabel, linetype = "MinMax"),
            size = 1) +
  labs(x = "Approach", y = "Difference") +
  scale_x_discrete(breaks = unique(summary_data$approach)) +
  scale_y_continuous(expand = expansion(mult = c(0.05, 0.1))) +
  scale_color_manual(values = c(blue)) +
  scale_linetype_manual(values = c("dashed", "solid", "dotted", "dotdash"),
                        name = "Diff Metric") +
  theme_minimal() +
  theme(axis.text.x = element_text(angle = 30, hjust = 1))

summary_data_plot


# function defining the plot
do_the_plot <- function(data, metric, legend_position = "none") {
  
  data$dataset <- "TicTacToe"
  
  data <-
    subset(data,
           plagTypeGroup != '' & variable %in% c("similarity", metric))
  
  plot <-
    ggplot(data, aes(x = approach, y = value, fill = tupleTypeLabel)) +
    geom_boxplot(width = 0.2, outlier.size = 0.5, outlier.alpha=0.75) +
    #geom_violin(color = "grey", alpha = 0.3, width = 1) +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "%"),
      name = "Similarity"
    ) +
    expand_limits(y = c(0, 85)) +
    facet_wrap( ~ plagTypeGroup, nrow = 1, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = legend_position,
      text = element_text(size = 12, family = "Times"),
      legend.margin = margin(0, 0, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}


# create and save the plots for all plagiarism tools
groups <- unique(data$plagTypeGroup)

do_the_plot(data, "avg.similarity", "bottom")

width100 <- 15.24 # 14 / 2
height = 21 / 3 + 2 # width100/ 1.7 #1.34 #/ 1.7

print(height)

plot_and_save <- function(width, metric) {
  do_the_plot(data, metric, "bottom")
  file_name <-
    paste('./output/eval-chatgpt-full_', metric, '.pdf', sep = "")
  ggsave(file_name,
         device = cairo_pdf,
         width = width,
         height = height, units = "cm")
}

plot_and_save(width100, "max.similarity")
plot_and_save(width100, "avg.similarity")

test_results2 <- stat_test_table2(data)
generate_table(test_results2, "to-base-aigen", 2, c("ds", "Variant", "Pairs", "$p$", "$W$", "$\\delta$", "$\\delta\\,Int.$", "$\\delta$ 95\\% CI", "n"))
