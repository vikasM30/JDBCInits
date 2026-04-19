import java.sql.*;

public class JDBC_Connect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TestJDBC";
        String user = "postgres";
        String password = "postgress";
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), email VARCHAR(100) UNIQUE)".formatted();
        String insertQuery = "INSERT INTO users (name, email) VALUES ('vikas', 'vikas@gmail.com')";
        String updateQuery = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        String getQuery = "SELECT * FROM users WHERE id = 1";
        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(getQuery)
        ) {
            ResultSet rs = ps.executeQuery();
            System.out.println("Table created successfully: " + rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connected to database successfully");

    }
}