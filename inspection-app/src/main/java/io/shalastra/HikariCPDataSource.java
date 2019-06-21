package io.shalastra;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDataSource {

  private static HikariDataSource hikariDataSource;

  private HikariCPDataSource() {}

  static {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:postgresql://localhost:5431/inspections_db");
    config.setUsername("postgres");
    config.setPassword("postgres");
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    hikariDataSource = new HikariDataSource(config);
  }

  static Connection getConnection() throws SQLException {
    return hikariDataSource.getConnection();
  }
}
