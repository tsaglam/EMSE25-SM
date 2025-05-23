library(reshape2)

# https://stackoverflow.com/questions/9564489/read-all-files-in-a-folder-and-apply-a-function-to-each-data-frame
read_from_csv <- function() {
  filenames <-
    list.files("./input/", pattern = "*.csv", full.names = TRUE)
  dataframes <- lapply(filenames, read.csv, sep = ";")

  
  data_all <- do.call("rbind", dataframes)
  return(data_all)
}

# Add approach column from tool
add_levels <- function(data) {
  levels <- c("Base", "TSN", "SMM", "Both" )
  data$tool <- factor(data$tool, levels = levels)
  return(data)
}

# Ensures proper naming and order of datasets
add_dataset_label <- function(data) {
  dataset_mapping <- c("Progpedia19" = "PROGpedia-19",
                "Progpedia56" = "PROGpedia-56",
                "TicTacToe" = "TicTacToe",
                "z5z1" = "Homework-1",
                "z5z5" = "Homework-5",
               "BoardGame" = "BoardGame")
  
  levels <- c("PROGpedia-19", "PROGpedia-56","TicTacToe", "BoardGame", "Homework-1", "Homework-5")
  
  data$runtime_min <- data$runtime / 60000
  data$runtime_h <- data$runtime_min / 60

  data$dataset <- factor(dataset_mapping[data$dataset], levels = levels)
  return(data)
}


calculate_metrics <- function(data) {
  # relative insertions:
  if(!all(c("lines_before", "lines_after") %in% colnames(data))) {
    stop("Data must contain 'lines_before' and 'lines_after' columns")
  }
  data$insertions <- (data$lines_after - data$lines_before) / data$lines_before * 100
  
  #relative runtime:
  data <- data %>%
    group_by(id) %>%
    mutate(runtime_diff = ifelse(tool == "Base", 100,((runtime - runtime[tool == "Base"]) / runtime[tool == "Base"]) * 100)) %>%
    ungroup()
  
  return(data)
}

save_plot <- function(label, width, height) {
  file_name <- paste0( './output/eval-MOSSad-', label, '.pdf')
  ggsave(file_name,
         device = cairo_pdf,
         width = width,
         height = height, units = "cm")
}
