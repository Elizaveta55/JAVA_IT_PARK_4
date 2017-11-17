import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/humans";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        humanDataStorage NewHumanDataStorage = new humanDataStorage(dataSource);
        Scanner scanner = new Scanner(System.in);

        int age, height;
        Long id;
        String name;
        Human human;
        int COUNT_OF_PEOPLE = 3;

        while (true) {
            System.out.println("Чего желаешь сотворить?");
            System.out.println("1. Добавить человека");
            System.out.println("2. Найди человека");
            System.out.println("3. Фильтровать по ID");
            System.out.println("4. Фильтровать по age");
            System.out.println("5. Фильтровать по height");
            System.out.println("6. Фильтровать по name");
            System.out.println("7. Stop it");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введи возраст");
                    age = scanner.nextInt();
                    System.out.println("Введи имя");
                    name = scanner.next();
                    System.out.println("Введи рост");
                    height = scanner.nextInt();
                    human = Human.builder()
                            .age(age)
                            .height(height)
                            .name(name)
                            .build();
                    NewHumanDataStorage.save(human);
                    System.out.println("done");
                    break;
                case 2:
                    System.out.println("Введи id человека");
                    id = scanner.nextLong();
                    Human human1 = NewHumanDataStorage.find(id);
                    System.out.println(human1);
                    System.out.println("done");
                    break;
                case 3:
                    List<Human> humanList = NewHumanDataStorage.filter(1);
                    //System.out.println(human.getAge() + ' ' + human.getName());
                    System.out.println(humanList);
                    System.out.println("done");
                    break;
                case 4:
                    List<Human> humanList2 = NewHumanDataStorage.filter(2);
                    System.out.println(humanList2);
                    System.out.println("done");
                    break;
                case 5:
                    List<Human> humanList3 = NewHumanDataStorage.filter(3);
                    System.out.println(humanList3);
                    System.out.println("done");
                    break;
                case 6:
                    List<Human> humanList4 = NewHumanDataStorage.filter(4);
                    System.out.println(humanList4);
                    System.out.println("done");
                    break;
                case 7:
                    return;
            }
        }
    }
}

