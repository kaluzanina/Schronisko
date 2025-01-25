package bada_bdbt_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;

//@SpringBootApplication(scanBasePackages = "bada_bdbt_proj")
@SpringBootApplication
//@ComponentScan("bada_bdbt_proj") // Adjust if your classes are in other packages
@EnableJpaRepositories("bada_bdbt_proj")
@EntityScan("bada_bdbt_proj")

public class KlienciApplication {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Oracle Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load Oracle Driver");

        }
        String url = "jdbc:oracle:thin:@//192.168.0.73:1521/xe"; // Update with your DB URL
        String username = "system"; // Replace with your DB username
        String password = "dentystka"; // Replace with your DB password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(KlienciApplication.class, args);
    }
}
