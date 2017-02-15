package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kimjohnconcha
 */
public class ConnectToDB {
    private String driver;
    private String url;
    private String user;
    private String password;
    private String host;
    private String port;
    private String database;
    private Connection connection = null;
    
    public ConnectToDB() {
        this.driver = "com.mysql.jdbc.Driver";
        this.host = "127.0.0.1";
        this.user = "root";
        this.port = "3306";
        this.password = "";
        this.database = "expresswaydb";
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    }
    
    public Connection getConnection() {
        Connection con = null;
        if(connection == null) {
            try {
                //load driver
                Class.forName(driver).newInstance();
                // establish connection
                con = DriverManager.getConnection(url, user, password);
            }
            catch(ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ConnectToDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if(con == null) {
                    JOptionPane.showMessageDialog(null, "Failed to connect to the server.");
                    System.exit(1);
                } else {
                    this.connection = con;
                }
            }
        }
        return connection;
    }
}
