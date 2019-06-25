package io.shalastra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InspectionRepository {

  public List<String> fetchData() throws SQLException {
    List<String> rows = new ArrayList<>();

    try (Connection connection = HikariCPDataSource.getConnection()) {
      log.info("Java JDBC PostgreSQL Example");

      log.info("Connected to PostgreSQL database.");
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.inspections LIMIT ?");

      log.info("Reading inspections records...");
      preparedStatement.setInt(1, 4);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Inspection inspection = new Inspection();

        inspection.setInspectionID(resultSet.getInt("inspection_id"));
        inspection.setRestaurantName(resultSet.getString("dba_name"));
        inspection.setOtherName(resultSet.getString("aka_name"));
        inspection.setLicenseNumber(resultSet.getInt("license_no"));
        inspection.setFacilityType(resultSet.getString("facility_type"));
        inspection.setRisk(resultSet.getString("risk"));
        inspection.setAddress(resultSet.getString("address"));
        inspection.setCity(resultSet.getString("city"));
        inspection.setState(resultSet.getString("state"));
        inspection.setZip(resultSet.getString("zip"));
        inspection.setInspectionDate(resultSet.getString("inspection_date"));
        inspection.setInspectionType(resultSet.getString("inspection_type"));
        inspection.setResults(resultSet.getString("results"));
        inspection.setViolations(resultSet.getString("violations"));
        inspection.setLatitude(resultSet.getDouble("latitude"));
        inspection.setLongitude(resultSet.getDouble("longitude"));
        inspection.setLocation(resultSet.getString("location"));

        rows.add(inspection.toString());
        log.info(inspection.toString());
      }
    }

    return rows;
  }
}
