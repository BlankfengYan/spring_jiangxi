package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
    System.out.println("Init mysql database");
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.h2.Driver");
    ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
    ds.setUsername("root");
    ds.setPassword("abc123");
    return ds;
    /*
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();
    */
  }
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
     System.out.println("Init jdbcTemplate");
    return new JdbcTemplate(dataSource);
  }

}
