import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.List;

public class AutoDao implements AutosDao {
    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM autos WHERE name = ?";

    private static final String SQL_INSERT_USER =
            "INSERT INTO autos(name, model, color) VALUES (?, ?, ?)";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM autos WHERE id = ?";

    private static final String SQL_FIND_BY_MODEL =
            "SELECT * FROM autos WHERE model = ?";

    private static final String SQL_FIND_ALL =
            "SELECT * FROM autos";

    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM autos WHERE id = ?";

    private static final String SQL_UPDATE_NAME =
            "UPDATE autos SET name = ? WHERE id = ?";

    private static final String SQL_UPDATE_MODEL =
            "UPDATE autos SET model = ? WHERE id = ?";

    private static final String SQL_UPDATE_COLOR =
            "UPDATE autos SET color = ? WHERE id = ?";


    private JdbcTemplate template;

    private org.springframework.jdbc.core.RowMapper<Auto> rowMapper = (resultSet, rowNum) -> {
        Auto result = Auto.builder()
                .ID(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .model(resultSet.getString("model"))
                .model(resultSet.getString("color"))
                .build();
        return result;
    };

    public AutoDao (DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public Auto findOneByName(String name) {
        List<Auto> result = template.query(SQL_FIND_BY_NAME, rowMapper, name);
        if (result.size() > 0){
            return result.get(0);
        }
        return null;
    }

//    @Override
//    public Human findOwnerByModel(String model) {
//        List<Auto> result = template.query(SQL_FIND_BY_MODEL, rowMapper, model);
//        if (result.size() > 0){
//            return result.get(0);
//        }
//        return null;
//    }

    @Override
    public void save(Auto model) {
        template.update(SQL_INSERT_USER, model.getName(), model.getModel(), model.getColor());
//        List<Auto> result = template.query(SQL_INSERT_USER, rowMapper, model);
    }

    @Override
    public Auto find(Long id) {
        List<Auto> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public void update(Auto model) {
        List<Auto> result = template.query(SQL_FIND_BY_ID, rowMapper, model.getID());
        if (result.size() > 0){
            template.update(SQL_UPDATE_NAME, model.getName(), model.getID());
            template.update(SQL_UPDATE_MODEL, model.getModel(), model.getID());
            template.update(SQL_UPDATE_COLOR, model.getColor(), model.getID());
            List<Auto> result2 = template.query(SQL_INSERT_USER, rowMapper, model);
        }
    }

    @Override
    public void delete(Long id) {
        List<Auto> result = template.query(SQL_FIND_BY_ID, rowMapper, id);
        if (result.size() > 0){
            template.update(SQL_DELETE_BY_ID, rowMapper, id);
        }
        else {
            throw new IllegalArgumentException("There is no such coche");
        }
    }

    @Override
    public List<Auto> findAll() {
        List<Auto> result = template.query(SQL_FIND_ALL, rowMapper);
        return result;
    }
}
