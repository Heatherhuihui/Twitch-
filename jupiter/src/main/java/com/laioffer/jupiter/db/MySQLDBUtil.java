package com.laioffer.jupiter.db;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MySQLDBUtil {
    private static final String INSTANCE = "aaaaaaa"; //INSTANCE_ADDRESS
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "jupiter";
    public static String getMySQLAddress() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        // a class loader is an object that is responsible for loading classes.
        //a class loader should attempt to locate or generate data that constitutes a definition for the class
        InputStream inputStream = MySQLDBUtil.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);

        String username = prop.getProperty("user");
        String password = prop.getProperty("password");
        return
        String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&autoReconnect=true&serverTimezone=UTC&createDatabaseIfNotExist=true",
                INSTANCE, PORT_NUM, DB_NAME, username, password);

    }
}
