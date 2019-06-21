package io.shalastra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  public static void main(String[] args) {

  }

  public static List<String> fetchData() throws SQLException {
    List<String> rows = new ArrayList<>();

    try (Connection connection = HikariCPDataSource.getConnection()) {
      log.info("Java JDBC PostgreSQL Example");

      log.info("Connected to PostgreSQL database!");
      Statement statement = connection.createStatement();
      log.info("Reading inspections records...");
      ResultSet resultSet = statement.executeQuery("SELECT * FROM public.inspections LIMIT 4");

      while (resultSet.next()) {
        String row = resultSet.getString("inspection_id") + " " + resultSet.getString("dba_name");

        rows.add(row);
        log.info(row);
      }
    }

    return rows;
  }
}