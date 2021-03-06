import org.springframework.jdbc.core.JdbcTemplate;

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

    private static final String SQL_UPDATE_BY_ID =
            "UPDATE humans" + " SET name = ?, age = ? WHERE id = ?";


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
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void save(Human model) {
        template.update(SQL_INSERT_USER, model.getAge(), model.getName());
    }

    @Override
    public Human find(Long id) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void update(Human model) {
        template.update(SQL_UPDATE_BY_ID, model.getName(), model.getAge(), model.getId());
    }

    @Override
    public void delete(Long id) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0) {
            template.query(SQL_DELETE_BY_ID, rowMapper, id);
        } else {
            throw new IllegalArgumentException("There is no such human");
        }
    }

    @Override
    public List<Human> findAll() {
        List<Human> result = template.query(SQL_FIND_ALL, rowMapper);
        return result;
    }
}
