package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static Connection openConnection() {
        
        String url = "jdbc:mysql://localhost/Game";
        String user = "root";
        String password = "1234";
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

            System.err.println("Connection error: " + e.getMessage());
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {

        try {

            connection.close();

        } catch (SQLException e) {

            System.err.println("Close error: " + e.getMessage());
        }
    }

    public static Statement createStatement(Connection connection) {

        Statement st = null;

        try {
            
            st = connection.createStatement();

        } catch (SQLException e) {

            System.out.println("Statement error: " + e.getMessage());
        }

        return st;

    }

    public static void insertGame(Game game) {

        Connection connection = openConnection();

        Statement st = createStatement(connection);

        String query = "INSERT INTO Game VALUES ('" + game.getname() + "'," + game.getyear() + ");";

        try {
            
            st.executeUpdate(query);

        } catch (SQLException e) {

            System.out.println("ExecuteQuery error: " + e.getMessage());
        }

       closeConnection(connection);

    }

    public static void deleteGame(String gameName) {

        Connection connection = openConnection();

        Statement st = createStatement(connection);

        String query = "DELETE FROM Game WHERE Name = " + "'" +  gameName + "'";

        try {
            
            st.executeUpdate(query);
            System.out.println(gameName + " successfully eliminated");

        } catch (SQLException e) {

            System.out.println("ExecuteQuery error: " + e.getMessage());
        }

        closeConnection(connection);

    }

    public static void showTable() {

        Connection connection = openConnection();

        Statement st = createStatement(connection);

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

        closeConnection(connection);
    }
}
