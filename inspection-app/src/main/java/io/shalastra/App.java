package io.shalastra;

import java.sql.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  public static void main(String[] args) {
    log.info("test");

    try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5431/inspections_db", "postgres", "postgres")) {
      log.info("Java JDBC PostgreSQL Example");

      log.info("Connected to PostgreSQL database!");
      Statement statement = connection.createStatement();
      log.info("Reading inspections records...");
      ResultSet resultSet = statement.executeQuery("SELECT * FROM public.inspections LIMIT 10");
      while (resultSet.next()) {
        log.info(resultSet.getString("inspection_id") + " " + resultSet.getString("dba_name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}