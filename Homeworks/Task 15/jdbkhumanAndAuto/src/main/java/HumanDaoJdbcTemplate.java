import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class HumanDaoJdbcTemplate implements HumansDao {

    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM humans WHERE name = ?";

    private static final String SQL_INSERT_USER =
            "INSERT INTO human(age, name) VALUES (?, ?)";

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
    }

    @Override
    public Human find(Long id) {
        return null;
    }

    @Override
    public void update(Human model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Human> findAll() {
        return null;
    }
}

