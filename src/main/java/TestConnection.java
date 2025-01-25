import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//192.168.0.73:1521/xe";
        String username = "system";
        String password = "dentystka";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
