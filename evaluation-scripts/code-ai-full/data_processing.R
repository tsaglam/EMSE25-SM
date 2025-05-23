library(reshape2)

# https://stackoverflow.com/questions/9564489/read-all-files-in-a-folder-and-apply-a-function-to-each-data-frame
read_from_csv <- function() {
  filenames <-
    list.files("./input/", pattern = "*.csv", full.names = TRUE)
  dataframes <- lapply(filenames, read.csv, sep = ";")
  id_vars <-
    c("first",
      "second",
      "tupleType",
      "plagType",
      "plagTypeGroup",
      "tool")
  melted_dataframes <- lapply(dataframes, melt, id.vars = id_vars)
  
  data_all <- do.call("rbind", melted_dataframes)
  return(data_all)
}

add_approach_label <- function(data) {
  # Add approach column from tool
  approach <- c(
    "merging" = "SMM",
    "without" = "Base"
  )
  
  levels <- c("Base", "Base-new", "TSN", "TSN-new", "SMM", "SMM-new", "Both", "Both-new" )
  
  data$approach <- ifelse(is.na(approach[data$tool]), data$tool, approach[data$tool])
  all_levels <- unique(c(levels, unique(data$approach)))
  data$approach <- factor(data$approach, levels = all_levels)
  
  return(data)
}

add_tuple_type_label <- function(data) {
  tuple_type <- c(
    "Original-Original" = "Original Pairs",
    "Plag-Original" = "Plagiarism-to-Source Pairs",
    "Plag-Plag" = "GPT-4 Pairs"
  )
  levels <-
    c("Original Pairs",
      "Plagiarism-to-Source Pairs",
      "GPT-4 Pairs")
  
  data$tupleTypeLabel <-
    factor(tuple_type[data$tupleType], levels = levels)
  return(data)
}
