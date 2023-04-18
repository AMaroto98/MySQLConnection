package MySQLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zaxxer.hikari.HikariDataSource;

public class DataBase {

    public static void insertGame(Game game) {

        String url = "jdbc:mysql://localhost/Game";
        String user = "root";
        String password = "1234";
    
        HikariDataSource dataSource = null;
        Connection connection = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
    
            connection = dataSource.getConnection();

        } catch (SQLException e) {

            System.err.println("Connection error: " + e.getMessage());
        }
    
        Statement st = null;

        try {

            st = connection.createStatement();

        } catch (SQLException e) {

            System.out.println("Statement error: " + e.getMessage());

        }
    
        String query = "INSERT INTO Game VALUES ('" + game.getname() + "'," + game.getyear() + ");";
    
        try {

            st.executeUpdate(query);

        } catch (SQLException e) {

            System.out.println("ExecuteUpdate error: " + e.getMessage());

        } 
    
        try {

            dataSource.close();
            connection.close(); // Cerrar conexión

        } catch (SQLException e) {

            System.err.println("Close error: " + e.getMessage());
        }
    }
    

    public static void deleteGame(String gameName) {

        String url = "jdbc:mysql://localhost/Game";
        String user = "root";
        String password = "1234";
    
        HikariDataSource dataSource = null;
        Connection connection = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
    
            connection = dataSource.getConnection();

        } catch (SQLException e) {

            System.err.println("Connection error: " + e.getMessage());
        }

        Statement st = null;

        try {

            st = connection.createStatement();

        } catch (SQLException e) {

            System.out.println("Statement error: " + e.getMessage());

        }


        String query = "DELETE FROM Game WHERE Name = " + "'" +  gameName + "'";

        try {
            
            st.executeUpdate(query);
            System.out.println(gameName + " successfully eliminated");

        } catch (SQLException e) {

            System.out.println("ExecuteQuery error: " + e.getMessage());
        }

        try {

            dataSource.close();
            connection.close(); // Cerrar conexión

        } catch (SQLException e) {

            System.err.println("Close error: " + e.getMessage());
        }

    }

    public static void showTable() {

        String url = "jdbc:mysql://localhost/Game";
        String user = "root";
        String password = "1234";
    
        HikariDataSource dataSource = null;
        Connection connection = null;
    
        try {

            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
    
            connection = dataSource.getConnection();

        } catch (SQLException e) {

            System.err.println("Connection error: " + e.getMessage());
        }

        // Creación del Statement
        Statement st = null;

        try {
            
            st = connection.createStatement();

        } catch (SQLException e) {

            System.err.println("Statement error: " + e.getMessage());
        }

        String query = "SELECT * FROM Game;";

        try {

            // ResultSet nos permite almacenar cualquier cosa que nos devuelve la BBDD.
            // ResultSet es un tipo de array pero no podemos acceder por el índice
            // Por ellos usamos next();
            ResultSet rs = st.executeQuery(query);

            // next() devuelve true si hay algun elemento en la posición que esta mirando
            // Con el next recorre la array entera
            while (rs.next()) {

                // Cuando entra de un campo de la array se "centra" en el y podemos acceder a cada campo del registro
                // Esto devuelve el nombre de la primera posición, se pone getString porque en la BBDD el campo nom es un String.
                System.out.println("Game name: " + rs.getString("Name"));

                // Los mismo con el getInt.
                System.out.println("Game year: " + rs.getInt("Year"));
                
            }


        } catch (SQLException e) {

            System.err.println("ExecuteQuery error: " + e.getMessage());
        }

        try {

            dataSource.close();
            connection.close(); // Cerrar conexión

        } catch (SQLException e) {

            System.err.println("Close error: " + e.getMessage());
        }
    } 
}
