package io.shalastra;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

  @Test
  public void givenConnection_thenFetchDbData() throws SQLException {
    List<String> rows = App.fetchData();

    assertEquals(4, rows.size());
  }
}
