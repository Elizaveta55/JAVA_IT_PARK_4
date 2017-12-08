import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class HumanDaoJdbc implements HumansDao {

    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM humans WHERE name = ?";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM humans WHERE id = ?";

    private static final String SQL_FIND_ALL =
            "SELECT * FROM humans";

    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM humans WHERE id = ?";

    private static final String SQL_UPDATE_BY_ID =
            "UPDATE humans" + " SET name = ?, age = ? WHERE id = ?";

    private static final String SQL_INSERT_USER =
            "INSERT INTO humans(age, name) VALUES (?, ?)";

    private Connection connection;


    public HumanDaoJdbc(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
            } catch (SQLException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Human findOneByName(String name){
        Human thatHuman;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                int age = resultSet.getInt("age");
                thatHuman = new Human(id, age, name);
                return thatHuman;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void save(Human model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setInt(1, model.getAge());
            preparedStatement.setString(2, model.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Human find(Long id) {
        Human thatHuman;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if (resultSet.next()) {
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                thatHuman = new Human(id, age, name);
                return thatHuman;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void update(Human model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getAge());
            preparedStatement.setLong(3, model.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
   }

    @Override
    public List<Human> findAll() {
        List<Human> humans = new LinkedList<Human>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                Human human = new Human(id, age, name);
                humans.add(human);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return humans;
    }

}
