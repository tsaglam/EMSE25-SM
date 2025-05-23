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

# Add approach column from tool
add_approach_label <- function(data) {
  approach <- c("without" = "Base",
                "merging" = "SMM")
  
  levels <- c("Base", "TSN", "SMM", "Both" )
  
  data$approach <- ifelse(is.na(approach[data$tool]), data$tool, approach[data$tool])
  all_levels <- unique(c(levels, unique(data$approach)))
  data$approach <- factor(data$approach, levels = all_levels)

  return(data)
}

# Ensures proper naming and order of datasets
add_dataset_label <- function(data) {
  dataset <- c("Progpedia19" = "PROGpedia-19",
                "Progpedia56" = "PROGpedia-56",
                "TicTacToe" = "TicTacToe",
                "z5z1" = "Homework-1",
                "z5z5" = "Homework-5",
               "BoardGame" = "BoardGame")
  
  levels <- c("PROGpedia-19", "PROGpedia-56","TicTacToe", "BoardGame", "Homework-1", "Homework-5")

  data$dataset <- factor(dataset[data$plagTypeGroup], levels = levels)
  return(data)
}


add_tuple_type_label <- function(data) {
  tuple_type <- c(
    "Original-Original" = "Original Pairs",
    "Plag-Original" = "Plagiarism-to-Source Pairs",
    "Plag-Plag" = "Plagiarism-to-Plagiarism Pairs"
  )
  
  levels <-
    c("Original Pairs",
      "Plagiarism-to-Source Pairs",
      "Plagiarism-to-Plagiarism Pairs")
  
  data$tupleTypeLabel <-
    factor(tuple_type[data$tupleType], levels = levels)
  
  return(data)
}
