package entity;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс представляет консольное приложение для управления записями
 * об одежде в базе данных.
 */
@Component
public class ClothingConsoleApp {

    private final ClothingService clothingService;

    /**
     * Конструктор с внедрением зависимости ClothingService.
     * 
     * @param clothingService сервис для работы с записями одежды.
     */
    @Autowired
    public ClothingConsoleApp(ClothingService clothingService) {
        this.clothingService = clothingService;
    }
    
    /**
     * Основной метод для запуска консольного приложения.
     * Предоставляет пользователю меню с возможностью выбора операций.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить запись");
            System.out.println("2. Вывести все записи");
            System.out.println("3. Редактировать запись");
            System.out.println("4. Удалить запись");
            System.out.println("5. Найти по материалу");
            System.out.println("0. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addClothing(scanner);
                case 2 -> displayAll();
                case 3 -> editClothing(scanner);
                case 4 -> deleteClothing(scanner);
                case 5 -> findByMaterial(scanner);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    /**
     * Метод для добавления новой записи одежды.
     * 
     * @param scanner - экземпляр Scanner для получения ввода от пользователя.
     */
    private void addClothing(Scanner scanner) {
        System.out.println("Введите название одежды:");
        String name = scanner.nextLine();
        System.out.println("Введите размер:");
        String size = scanner.nextLine();
        System.out.println("Введите материал:");
        String material = scanner.nextLine();
        System.out.println("Введите количество:");
        int quantity = scanner.nextInt();
        System.out.println("Введите цену:");
        double price = scanner.nextDouble();

        Clothing clothing = new Clothing();
        clothing.setName(name);
        clothing.setSize(size);
        clothing.setMaterial(material);
        clothing.setQuantity(quantity);
        clothing.setPrice(price);

        clothingService.save(clothing);
        System.out.println("Добавлено успешно!");
    }

    /**
     * Метод для отображения всех записей одежды.
     */
    private void displayAll() {
        clothingService.findAll().forEach(System.out::println);
    }

    /**
     * Метод для редактирования существующей записи одежды.
     * 
     * @param scanner - экземпляр Scanner для получения ввода от пользователя.
     */
    private void editClothing(Scanner scanner) {
        System.out.println("Введите ID для редактирования:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Clothing> optionalClothing = clothingService.findById(id);
        if (optionalClothing.isPresent()) {
            Clothing clothing = optionalClothing.get();

            System.out.println("Введите новое название:");
            clothing.setName(scanner.nextLine());
            System.out.println("Введите новый размер:");
            clothing.setSize(scanner.nextLine());
            System.out.println("Введите новый материал:");
            clothing.setMaterial(scanner.nextLine());
            System.out.println("Введите новое количество:");
            clothing.setQuantity(scanner.nextInt());
            System.out.println("Введите новую цену:");
            clothing.setPrice(scanner.nextDouble());

            clothingService.save(clothing);
            System.out.println("Обновлено успешно!");
        } else {
            System.out.println("Запись не найдена.");
        }
    }

    /**
     * Метод для удаления записи одежды по ID.
     * 
     * @param scanner - экземпляр Scanner для получения ввода от пользователя.
     */
    private void deleteClothing(Scanner scanner) {
        System.out.println("Введите ID для удаления:");
        Long id = scanner.nextLong();
        clothingService.deleteById(id);
        System.out.println("Удалено успешно!");
    }
    
    /**
     * Метод для поиска записей одежды по материалу.
     * 
     * @param scanner - экземпляр Scanner для получения ввода от пользователя.
     */
    private void findByMaterial(Scanner scanner) {
        System.out.println("Введите материал:");
        String material = scanner.nextLine();
        clothingService.findByMaterial(material).forEach(System.out::println);
    }
}
