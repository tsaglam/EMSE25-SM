library(ggplot2)
library(extrafont)
library(cowplot)
library(magrittr)
library(dplyr)
source("data_processing.R")

font_import()
loadfonts(quiet = TRUE)
#theme_set(theme_cowplot(font_size=12, font_family="Linux Libertine"))


# functions defined in data_processing.R
data <- read_from_csv()
data <- add_levels(data)
data <- add_dataset_label(data)
data <- calculate_metrics(data)

blue <- "#005AA0"
blue50 <- "#7FACCF"
green <- "#8CB423"
green50 <- "#C5D990"
orange <- "#F0781E"
orange50 <- "#F7BB8E"

fill_colors <- c(blue50, blue50, blue50, blue50)

### THESE ARE DIFFSTATS FOR APPROACH <--> BASE FOR EACH TUPLE TYPE

baseline <- "Base"

insertion_stats <- data %>%
  group_by(tool, dataset) %>%
  summarize(
    median_val = median(insertions, na.rm = TRUE),
    avg_val = mean(insertions, na.rm = TRUE),
    max_val = max(insertions, na.rm = TRUE),
    min_val = min(insertions, na.rm = TRUE),
    lower_q = quantile(insertions, 0.25, na.rm = TRUE),
    upper_q = quantile(insertions, 0.75, na.rm = TRUE),
    .groups = 'drop'
  )

runtime_stats <- data %>%
  group_by(tool, dataset) %>%
  summarize(
    median_val = median(runtime_h, na.rm = TRUE),
    avg_val = mean(runtime_h, na.rm = TRUE),
    max_val = max(runtime_h, na.rm = TRUE),
    lower_q = quantile(runtime_h, 0.25, na.rm = TRUE),
    upper_q = quantile(runtime_h, 0.75, na.rm = TRUE),
    .groups = 'drop'
  )

runtime_stats_min <- data %>%
  group_by(tool, dataset) %>%
  summarize(
    median_val = median(runtime_min, na.rm = TRUE),
    avg_val = mean(runtime_min, na.rm = TRUE),
    max_val = max(runtime_min, na.rm = TRUE),
    lower_q = quantile(runtime_min, 0.25, na.rm = TRUE),
    upper_q = quantile(runtime_min, 0.75, na.rm = TRUE),
    .groups = 'drop'
  )


width <- 15.24 # 14 / 2
height = 21 / 3 + 2 #16 # / 1.6 #/ 1.34

# insertions relativ to original program size
do_insertion_plot <- function(data) {
  
  plot <-
    ggplot(data, aes(x = tool, y = insertions)) +
    geom_boxplot(width = 0.4, outlier.size = 1.0, fill=blue50) +
   # geom_violin(alpha=0.5, width=0.4, fill=blue50) +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "%"),
      name = "Relative Insertions",
      breaks = seq(0, 1200, by = 100)  # Set breaks every 50
    ) +
    #expand_limits(y = c(0, 900)) +
    facet_wrap( ~ dataset, nrow = 1, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = "bottom",
      text = element_text(size = 12, family = "Linux Libertine O"),
      # family=libertine
      legend.margin = margin(0, 50, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    #scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}

do_insertion_plot(data)
save_plot("insert", width, height)

# runtime in minutes
do_runtime_plot <- function(data) {
  
  plot <-
    ggplot(data, aes(x = tool, y = runtime_min)) +
    geom_boxplot(width = 0.4, outlier.size = 1.0, fill=blue50) +
    # geom_violin(alpha=0.5, width=0.4, fill=blue50) +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "min"),
      name = "Obfuscation Runtime",
      breaks = seq(0, 420, by = 60)  # Set breaks every 50
    ) +
    expand_limits(y = c(0, 420)) +
    facet_wrap( ~ dataset, nrow = 1, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = "bottom",
      text = element_text(size = 12, family = "Linux Libertine O"),
      # family=libertine
      legend.margin = margin(0, 50, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    #scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}

do_runtime_plot(data)
save_plot("runtime_min", width, height)

do_runtime_hours_plot <- function(data) {
  
  plot <-
    ggplot(data, aes(x = tool, y = runtime_h)) +
    geom_boxplot(width = 0.4, outlier.size = 1.0, fill=blue50) +
    # geom_violin(alpha=0.5, width=0.4, fill=blue50) +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "h"),
      name = "Obfuscation Runtime",
      breaks = seq(0, 7, by = 1)  # Set breaks every 50
    ) +
    expand_limits(y = c(0, 6.5)) +
    facet_wrap( ~ dataset, nrow = 1, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = "bottom",
      text = element_text(size = 12, family = "Linux Libertine O"),
      # family=libertine
      legend.margin = margin(0, 50, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    #scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}

do_runtime_hours_plot(data)
save_plot("runtime_h", width, height)

do_rel_runtime_plot <- function(data) {
  
  plot <-
    ggplot(data, aes(x = tool, y = runtime_diff)) +
    geom_boxplot(width = 0.4, outlier.size = 1.0, fill=blue50) +
    # geom_violin(alpha=0.5, width=0.4, fill=blue50) +
    scale_y_continuous(
      labels = function(x)
        paste0(x, "%"),
      name = "Obfuscation Runtime (relative)",
      breaks = seq(0, 3000, by = 200)  # Set breaks every 50
    ) +
    #expand_limits(y = c(0, 900)) +
    facet_wrap( ~ dataset, nrow = 1, scales="free_x") + # Group by data set
    guides(fill = guide_legend(nrow = 1), x = guide_axis(angle = 0)) +
    theme(
      legend.position = "bottom",
      text = element_text(size = 12, family = "Linux Libertine O"),
      # family=libertine
      legend.margin = margin(0, 50, 0, 0),
      legend.box.margin = margin(-10, 0, 0, 0),
      legend.key = element_rect(fill = "white")
    ) +
    #scale_fill_manual(values = fill_colors, name = "") +
    xlab(element_blank()) # prev "Approach"
  return(plot)
}

do_rel_runtime_plot(data)
save_plot("runetime-rel", width, height)

cat("Total obfuscation time: ", sum(data$runtime_h), "hours")


