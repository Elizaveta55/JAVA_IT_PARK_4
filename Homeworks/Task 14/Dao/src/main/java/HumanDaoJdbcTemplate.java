import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class HumanDaoJdbcTemplate implements HumansDao {

    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM humans WHERE name = ?";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM humans WHERE id = ?";

    private static final String SQL_FIND_ALL =
            "SELECT * FROM humans";

    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM humans WHERE id = ?";

    private static final String SQL_UPDATE_NAME =
            "UPDATE humans SET name = ? WHERE id = ?";

    private static final String SQL_UPDATE_AGE =
            "UPDATE humans SET age = ? WHERE id = ?";

    private static final String SQL_INSERT_USER =
            "INSERT INTO humans(age, name) VALUES (?, ?)";

    private JdbcTemplate template;

    private org.springframework.jdbc.core.RowMapper<Human> rowMapper = (resultSet, rowNum) -> {
        Human result = Human.builder()
                .id(resultSet.getLong("id"))
                .age(resultSet.getInt("age"))
                .name(resultSet.getString("name"))
                .build();

        return result;
    };

    public HumanDaoJdbcTemplate(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Human findOneByName(String name) {
        List<Human> result = template.query(SQL_FIND_BY_NAME, rowMapper, name);
        if (result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public void save(Human model) {
        template.update(SQL_INSERT_USER, model.getAge(), model.getName());
//        List<Human> result = template.query(SQL_INSERT_USER, rowMapper, model);
    }

    @Override
    public Human find(Long id) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public void update(Human model) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, model.getId());
        if (result.size() > 0){
            template.update(SQL_UPDATE_AGE, model.getAge(), model.getId());
            template.update(SQL_UPDATE_NAME, model.getName(), model.getId());
//            List<Human> result2 = template.query(SQL_INSERT_USER, rowMapper, model);
        }
        else {
            System.err.println("No");
        }
    }

    @Override
    public void delete(Long id) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0){
            template.query(SQL_DELETE_BY_ID, rowMapper, id);
        }
        else {
            throw new IllegalArgumentException("There is no such human");
        }
    }

    @Override
    public List<Human> findAll() {
        List<Human> result = template.query(SQL_FIND_ALL, rowMapper);
        return result;
    }
}