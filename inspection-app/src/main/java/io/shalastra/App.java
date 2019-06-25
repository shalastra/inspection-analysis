package io.shalastra;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {


  public static void main(String[] args) {
    InspectionRepository repository = new InspectionRepository();

    try {
      repository.fetchData();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}