import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class humanDataStorage {
    private JdbcTemplate template;


    private static final String SQL_INSERT_USER =
            "INSERT INTO human(age, height, name) VALUES (?, ?, ?)";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM human WHERE id = ?";

    private static final String SQL_FILTER_BY_ID =
            "SELECT * FROM human ORDER BY id";

    private static final String SQL_FILTER_BY_AGE =
            "SELECT * FROM human ORDER BY age";

    private static final String SQL_FILTER_BY_HEIGHT =
            "SELECT * FROM human ORDER BY height";

    private static final String SQL_FILTER_BY_NAME =
            "SELECT * FROM human ORDER BY name";

    private org.springframework.jdbc.core.RowMapper<Human> rowMapper = (resultSet, rowNum) -> {
        Human result = Human.builder()
                .ID(resultSet.getLong("id"))
                .age(resultSet.getInt("age"))
                .height(resultSet.getInt("height"))
                .name(resultSet.getString("name"))
                .build();
        return result;
    };


    public humanDataStorage(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }


    public void save(Human model) {
        template.update(SQL_INSERT_USER, model.getAge(), model.getHeight(), model.getName());
    }


    public Human find(Long id) {
        List<Human> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    public List<Human> filter (int variant){
        List<Human> result = null;
        switch (variant){
            case 1:
                result = template.query(SQL_FILTER_BY_ID, rowMapper);
                break;
            case 2:
                result = template.query(SQL_FILTER_BY_AGE, rowMapper);
                break;
            case 3:
                result = template.query(SQL_FILTER_BY_HEIGHT, rowMapper);
                break;
            case 4:
                result = template.query(SQL_FILTER_BY_NAME, rowMapper);
                break;
        }
        return result;
    }

}
