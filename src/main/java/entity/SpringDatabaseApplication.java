package entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Класс является точкой входа в приложение Spring Boot, 
 * которое демонстрирует работу с базой данных с использованием Spring Data JPA.
 */
@SpringBootApplication
public class SpringDatabaseApplication {
    /**
     * Главный метод, который запускает приложение Spring Boot.
     * 
     * @param args - массив строковых аргументов командной строки.
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDatabaseApplication.class, args);
        ClothingConsoleApp app = context.getBean(ClothingConsoleApp.class);
        app.start();
    }
}

