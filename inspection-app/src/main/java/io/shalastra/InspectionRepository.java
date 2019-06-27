package io.shalastra;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class InspectionRepository {

  public void fetchData() {
    SparkSession session = SparkSession.builder()
        .appName("inspections").getOrCreate();

    Dataset<Row> jdbcDF = session
        .read()
        .format("jdbc")
        .option("url", "jdbc:postgresql://localhost:5431/inspections_db")
        .option("dbtable", "public.inspections")
        .option("user", "postgres")
        .option("password", "postgres")
        .load();

    jdbcDF.select(col("inspection_id")).show();
  }
}
