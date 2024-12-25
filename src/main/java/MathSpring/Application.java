package MathSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        // получение бина mathService
        MathService service = context.getBean(MathService.class);

        // Вызываем методы
        System.out.println("Addition: " + service.add(10, 5));
        System.out.println("Subtraction: " + service.subtract(10, 5));
        System.out.println("Multiplication: " + service.multiply(10, 5));

        try {
            System.out.println("Division: " + service.divide(10, 0));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
