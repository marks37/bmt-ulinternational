/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;

/**
 *
 * @author Mark
 */
public abstract class DBConnectionFactory {

    private final String url = "jdbc:mysql://localhost:3306/sfadb2";
    private final String username = "root";
    private final String password = "1424";
    private final String driver = "com.mysql.jdbc.Driver";

    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }

    public abstract Connection getConnection();

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

}
