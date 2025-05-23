library(effsize)
library(effectsize)
library(lsr)
library(dplyr)
library(tidyr)
library(effectsize)

# Tests for each approach the significance between plagiarism and original
stat_test_table <- function(data) {
  # Extract the unique levels from the input data frame
  tuple_types <- unique(data$tupleType)
  approaches <- unique(data$approach)
  datasets <- unique(data$dataset)
  
  target <- "Plag-Plag"
  other <- "Original-Original"
  
  data$tupleType <- factor(data$tupleType, levels = c(target,other))
  new_data <- list() # empty list to store the rows of the new data frame
  for (current_dataset in datasets) {
    for (current_approach in approaches) {
      filtered_data <- data %>%
        filter(approach == current_approach & dataset == current_dataset)
      
      # Wilcox Test:
      test_result<- wilcox.test(value ~ tupleType, data = filtered_data,
                                exact = FALSE, alternative = "greater",conf.int = TRUE)
      
      # Calculate Cliff's delta
      group1 <- filtered_data$value[filtered_data$tupleType == target]
      group2 <- filtered_data$value[filtered_data$tupleType == other]
      current_cliffs_delta <- cliff.delta(group1, group2) 
      interval <- paste("[", sprintf("%.2f", as.numeric(current_cliffs_delta$conf.int["lower"])), ", ", 
                        sprintf("%.2f", as.numeric(current_cliffs_delta$conf.int["upper"])), "]", sep = "")
      
      new_data <- rbind(new_data, data.frame(
        dataset = current_dataset,
        approach = current_approach,
        #alternative = test_result$alternative,
        p_value = signif(test_result$p.value, 3),
        statistic = format(round(test_result$statistic, 0), big.mark = ",", scientific = FALSE),
        cliffs_delta = sprintf("%.3f", current_cliffs_delta$estimate),
        interpretation= classify_cliffs_delta(current_cliffs_delta$estimate),
        cliffs_interval = interval#,
        #n_plag = as.numeric(length(group1)),
        #n_orig = as.numeric(length(group2))
      ))
    }
  }
  
  return(new_data)
}

# Tests for each approach except base the significance between the approach and base
stat_test_table2 <- function(data) {
  # Extract the unique levels from the input data frame
  tuple_order <- c("Original-Original", "Plag-Plag")
  tuple_types <- unique(data$tupleType)
  tuple_types <- tuple_order[tuple_order %in% tuple_types]
  desired_order <- c("test", "TSN", "SMM", "Both")
  approaches <- unique(data$approach)
  approaches <- desired_order[desired_order %in% approaches]
  datasets <- unique(data$plagTypeGroup)
  
  other <- "Base" # INTER APPROACH TEST --> COMPARE TO BASE
  
  new_data <- list() # empty list to store the rows of the new data frame
  for (current_dataset in datasets) { #[datasets != "TicTacToe"]) {
    for (current_tupleType in tuple_types) {
      for (current_approach in approaches[approaches != other]) {
        
        # PREPARE DATA:
        filtered_data <- data %>%
          filter(tupleType == current_tupleType & plagTypeGroup == current_dataset & approach %in% c(current_approach, other))
        filtered_data$approach <- factor(filtered_data$approach, levels = c(current_approach, other))
        data_target <- filtered_data[filtered_data$approach == current_approach, ]
        data_base <- filtered_data[filtered_data$approach == other, ]
        alt <- ifelse(current_tupleType == "Plag-Plag", "greater", "greater")
        
        cat(current_dataset,current_approach, current_tupleType, nrow(filtered_data), "\n")
        
        # PAIRED WILCOX TEST:
        paired_data <- merge(data_target, data_base, by = c("first", "second"), suffixes = c("_target", "_base"))
        test_result <- wilcox.test(paired_data$value_target, paired_data$value_base, paired = TRUE,exact = FALSE, alternative = alt,conf.int = TRUE)
        
        # EFFECT SIZE: Cliff's delta
        group1 <- filtered_data$value[filtered_data$approach == current_approach]
        group2 <- filtered_data$value[filtered_data$approach == other]
        #effsize_mult <- ifelse(current_tupleType == "Plag-Plag", 1, -1)
        eff_size <- cliff.delta(group1, group2)
        interval <- paste("[", sprintf("%.2f", as.numeric(eff_size$conf.int["lower"])), ", ", 
                          sprintf("%.2f", as.numeric(eff_size$conf.int["upper"])), "]", sep = "")
        
        # WRITE DATA FRAME
        new_data <- rbind(new_data, data.frame(
          dataset = current_dataset,
          approach = current_approach,
          pair = ifelse(current_tupleType == "Plag-Plag", "FG", "OP"),
          #h1 = alt,
          p_value = signif(test_result$p.value, 2),
          statistic = format(round(test_result$statistic, 0), big.mark = ",", scientific = FALSE),
          effect_size = sprintf("%.3f", eff_size$estimate), # also cliffs delta
          interpretation= classify_cliffs_delta(eff_size$estimate),
          cliffs_interval = interval,
          sample = format(as.numeric(length(group1)), big.mark = ",", scientific = FALSE)
        ))
      }
    }
  }
  
  print("significance tests done")
  return(new_data)
}

classify_cliffs_delta <- function(delta) {
  delta <- abs(delta)
  interpretation <- if (delta < 0.147) { #0.15
    "Negligible"
  } else if (delta < 0.33) { #0.33
    "Small"
  } else if (delta < 0.474) { #0.50
    "Medium"
  } else if (delta < 0.7) { #0.75
    "Large"
  } else if (delta >= 0.7) {
    "Very Large"
  } else {
    "Undefined"
  }
  return(interpretation)
}
