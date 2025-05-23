library(dplyr)
library(xtable)
library(tidyr)

generate_diff_table <- function(df, label) {
  levels <- c("Base", "TSN", "SMM", "Both")
  
  df_filtered <- df %>%
    select(-c(tupleTypeLabel, min_val, max_val, minmax_diff)) %>% # Drop the specified columns
    mutate(tool = factor(tool, levels = levels)) %>%
    select(dataset, tool, everything()) %>%
    arrange(dataset, tool)
  
  custom_colnames <- c("Dataset", "Tool", "Median", "Mean", "$Q_1$", "$Q_3$", "$\\Delta$ Mean", "$\\Delta$ Median", "$\\Delta$ IQR")
  colnames(df_filtered) <- custom_colnames
  
  # Convert to LaTeX table using xtable
  latex_table <- xtable(
    df_filtered,
    caption = "TODO",
    label = paste0("tab:diff-", label),
    align = c("l", rep("r", ncol(df_filtered)))
  )
  
  # Print LaTeX table code
  print(
    latex_table,
    include.rownames = FALSE,
    sanitize.colnames.function = identity
  )
}

generate_table <- function(data, name, multirow, custom_colnames) {
  data <- insert_multirows(data, multirow)
  data <- as.data.frame(lapply(data, as.character), stringsAsFactors = FALSE) # freeze visuals
  colnames(data) <- custom_colnames
  
  latex_table <- xtable(
    data,
    caption = "TODO",
    label = paste0("tab:", name),
    align = c("l", rep("r", ncol(data)))
  )
  print(
    latex_table,
    file = paste0("./output/table-", name, ".tex"),
    include.rownames = FALSE,
    sanitize.colnames.function = identity,
    sanitize.text.function = identity 
  )
  
  print(
    latex_table,
    include.rownames = FALSE,
    sanitize.colnames.function = identity,
    sanitize.text.function = identity 
  )
}


insert_multirows <- function(data, variants_per_dataset) {
  variants_per_dataset <- as.numeric(variants_per_dataset)
  data <- data %>%
    group_by(dataset) %>%
    mutate(dataset = ifelse(
      row_number() %% variants_per_dataset == 1,
      paste0("\\multirow{", variants_per_dataset, "}{*}{\\rotatebox[origin=c]{90}{", dataset, "}}"),
      ""
    )) %>%
    ungroup()
  return(data)
}