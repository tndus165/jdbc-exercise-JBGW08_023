package com.nhnacademy.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

public class DbUtils {
    public DbUtils(){
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //todo connection.
            // {ip},{database},{username},{password} 설정합니다.
            //String ip = "133.186.241.167:18080";
            //String database = "nhn_academy_23";
            //String username = "nhn_academy_23";
            //String password = "o5.WNs/X5Fb*NQ5K";
            connection = DriverManager.getConnection("jdbc:mysql://133.186.241.167:18080/nhn_academy_23","nhn_academy_23","o5.WNs/X5Fb*NQ5K");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return connection;
    }

    private static final DataSource DATASOURCE;

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.241.167:18080/nhn_academy_23");
        basicDataSource.setUsername("nhn_academy_23");
        basicDataSource.setPassword("o5.WNs/X5Fb*NQ5K");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMinIdle(5);

        basicDataSource.setMaxWait(Duration.ofSeconds(2));
        basicDataSource.setValidationQuery("select 1");
        basicDataSource.setTestOnBorrow(true);
        DATASOURCE = basicDataSource;
    }

    public static DataSource getDataSource(){
        return DATASOURCE;
    }

}