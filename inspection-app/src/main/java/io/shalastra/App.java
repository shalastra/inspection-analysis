package io.shalastra;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {


  public static void main(String[] args) {
    InspectionRepository repository = new InspectionRepository();

    repository.fetchData();
  }
}