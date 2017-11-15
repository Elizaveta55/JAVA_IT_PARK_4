import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/humanAndAuto";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        HumansDao humansDao = new HumanDaoJdbcTemplate(dataSource);
        AutosDao autosDao = new AutoDao(dataSource);

        HumanService humanService = new HumanService(humansDao);
        AutoService autoService = new AutoService(autosDao);

        Scanner scanner = new Scanner(System.in);

        int age;
        Long id;
        String name, model, color;
        Human human;
        Auto auto;

        while (true) {
            System.out.println("Чего желаешь сотворить?");
            System.out.println("1. Добавить человека");
            System.out.println("2. Удалить человека");
            System.out.println("3. Найди по ID человека");
            System.out.println("4. Изменить поля у человека");
            System.out.println("5. Посмотреть всех");
            System.out.println("6. Добавить машину");
            System.out.println("7. Удалить машину");
            System.out.println("8. Найди по ID машину");
            System.out.println("9. Изменить поля у машины");
            System.out.println("10. Посмотреть всех");
            System.out.println("11. Достаточно");
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
                    humanService.deleteUser(humanService.findByID(id));
                    System.out.println("done");
                    break;
                case 3:
                    System.out.println("Введи id человека");
                    id = scanner.nextLong();
                    human = humanService.findByID(id);
                    System.out.println(human.getAge() + ' ' + human.getName());
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
                            .age(age)
                            .name(name)
                            .build();
                    humanService.changeFields(human);
                    System.out.println("done");
                    break;
                case 5:
                    List<Human> humans= humansDao.findAll();
                    Iterator<Human> iterator;
                    System.out.println(humans);
                    System.out.println("done");
                    break;
                case 6:
                    System.out.println("Введи имя");
                    name = scanner.next();
                    System.out.println("Введи модель");
                    model = scanner.next();
                    System.out.println("Введи цвет");
                    color = scanner.next();
                    auto = Auto.builder()
                            .name(name)
                            .model(model)
                            .color(color)
                            .build();
                    autoService.registerUser(auto);
                    System.out.println("done");
                    break;
                case 7:
                    System.out.println("Введи id машины");
                    id = scanner.nextLong();
                    autoService.deleteUser(autoService.findByID(id));
                    System.out.println("done");
                    break;
                case 8:
                    System.out.println("Введи id машины");
                    id = scanner.nextLong();
                    auto = autoService.findByID(id);
                    System.out.println(auto.getName() + ' ' + auto.getModel() + ' ' + auto.getColor());
                    System.out.println("done");
                    break;
                case 9:
                    System.out.println("Введи id машины");
                    id = scanner.nextLong();
                    System.out.println("Введи новое имя");
                    name = scanner.next();
                    System.out.println("Введи новую модель");
                    model = scanner.next();
                    System.out.println("Введи новый цвет");
                    color = scanner.next();
                    auto = Auto.builder()
                            .name(name)
                            .model(model)
                            .color(color)
                            .build();
                    autoService.changeFields(auto);
                    System.out.println("done");
                    break;
                case 10:
                    List<Auto> autos= autosDao.findAll();
                    System.out.println(autos);
                    System.out.println("done");
                    break;
                case 11:
                    return;
            }
        }
    }
}
