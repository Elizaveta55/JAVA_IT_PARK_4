import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static Properties properties;

    public static void main(String[] args) throws ClassNotFoundException {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e){
            throw new IllegalArgumentException();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getProperty("database.driver"));
        dataSource.setUrl(properties.getProperty("database.url"));
        dataSource.setUsername(properties.getProperty("database.username"));
        dataSource.setPassword(properties.getProperty("database.password"));

        ComponentsFactory componentsFactory = ComponentsFactory.getComponentsFactory();

        HumansDao humansDao = componentsFactory.getHumanDao(dataSource);

        HumanService humanService = new HumanService(humansDao);

        Scanner scanner = new Scanner(System.in);

        int age;
        Long id;
        String name;
        Human human;

        while (true) {
            System.out.println("Чего желаешь сотворить?");
            System.out.println("1. Добавить человека");
            System.out.println("2. Удалить человека");
            System.out.println("3. Найди по ID человека");
            System.out.println("4. Изменить поля у человека");
            System.out.println("5. Посмотреть всех");
            System.out.println("6. Достаточно");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.println("Введи возраст");
                    age = scanner.nextInt();
                    System.out.println("Введи имя");
                    name = scanner.next();
                    human = Human.builder()
                            .age(age)
                            .name(name)
                            .build();
                    humanService.registerUser(human);
                    System.out.println("done");
                    break;
                case 2:
                    System.out.println("Введи id человека");
                    id = scanner.nextLong();
                    humanService.deleteUser(id);
                    System.out.println("done");
                    break;
                case 3:
                    System.out.println("Введи id человека");
                    id = scanner.nextLong();
                    human = humanService.findByID(id);
                    System.out.println(human.getAge() + " " + human.getName());
                    System.out.println("done");
                    break;
                case 4:
                    System.out.println("Введи id человека");
                    id = scanner.nextLong();
                    System.out.println("Введи новый возраст");
                    age = scanner.nextInt();
                    System.out.println("Введи новое имя");
                    name = scanner.next();
                    human = Human.builder()
                            .id(id)
                            .age(age)
                            .name(name)
                            .build();
                    humanService.changeFields(human);
                    System.out.println("done");
                    break;
                case 5:
                    List<Human> humans= humansDao.findAll();
                    System.out.println(humans);
                    System.out.println("done");
                    break;
                case 6:
                    return;
            }
        }
    }
}