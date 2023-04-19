package MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zaxxer.hikari.HikariDataSource;

public class DataBase {

    public static void closeConnection(HikariDataSource dataSource, Connection connection) {

        try {

            if (dataSource != null) {
                dataSource.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {

            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
    
    public static void insertGame(Game game) {

        HikariDataSource dataSource = null;
        Connection connection = null;
        Statement statement = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost/Game");
            dataSource.setUsername("root");
            dataSource.setPassword("1234");
    
            connection = dataSource.getConnection();
            statement = connection.createStatement();
        
            String query = "INSERT INTO Game VALUES ('" + game.getname() + "'," + game.getyear() + ");";
            statement.executeUpdate(query);
            
        } catch (SQLException e) {

            System.out.println("ExecuteUpdate error: " + e.getMessage());
            
        } finally {

            closeConnection(dataSource, connection);
        }
    }

    public static void deleteGame(String gameName) {

        HikariDataSource dataSource = null;
        Connection connection = null;
        Statement statement = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost/Game");
            dataSource.setUsername("root");
            dataSource.setPassword("1234");
    
            connection = dataSource.getConnection();
            statement = connection.createStatement();
        
            String query = "DELETE FROM Game WHERE Name = " + "'" +  gameName + "'";
            statement.executeUpdate(query);
            
        } catch (SQLException e) {

            System.out.println("ExecuteUpdate error: " + e.getMessage());
            
        } finally {

            closeConnection(dataSource, connection);
        }
    }

    public static void showTable() {

        HikariDataSource dataSource = null;
        Connection connection = null;
        Statement statement = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost/Game");
            dataSource.setUsername("root");
            dataSource.setPassword("1234");
    
            connection = dataSource.getConnection();
            statement = connection.createStatement();
        
            String query = "SELECT * FROM Game;";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                System.out.println("Game name: " + rs.getString("Name"));
                System.out.println("Game year: " + rs.getInt("Year"));
                
            }
            
        } catch (SQLException e) {

            System.out.println("ExecuteUpdate error: " + e.getMessage());
            
        } finally {

            closeConnection(dataSource, connection);
        }
    }      
}
