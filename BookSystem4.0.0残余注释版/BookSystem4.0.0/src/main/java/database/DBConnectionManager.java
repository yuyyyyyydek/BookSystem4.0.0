package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 该类读取文件中的数据库连接信息
 */
    public class DBConnectionManager {

        private static Properties props = new Properties();

        static {
            try (FileInputStream in = new FileInputStream("src/main/resources/database.properties")) {
                props.load(in);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName(props.getProperty("driverClassName"));
            return DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("username"),
                    props.getProperty("password")
            );
        }
    }


