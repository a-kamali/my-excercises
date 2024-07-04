package ir.maktab.config;

    import ir.maktab.util.ApplicationProperties;
    import java.sql.*;


    public class DataSource {
        private Connection connection;

        public DataSource() throws SQLException {
            connection = DriverManager.getConnection(
                    ApplicationProperties.DB_URL,
                    ApplicationProperties.DB_USERNAME,
                    ApplicationProperties.DB_PASSWORD);
        }

        public static Connection getConnection() throws SQLException {
                connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD);
            return connection;
        }

    }

