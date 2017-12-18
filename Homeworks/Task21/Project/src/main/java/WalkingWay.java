import java.util.List;
import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class WalkingWay implements OptionalWay, MapDao {

    private static final String SQL_SELECT_ALL =
            "SELECT * FROM owner";
    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "SELECT * FROM pointsonmap WHERE id = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_WIDTH =
            "SELECT * FROM pointsonmap WHERE width = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_HEIGHT =
            "SELECT * FROM pointsonmap WHERE height = ?";

    private JdbcTemplate template;

    private RowMapper<Point> rowMapper = (resultSet, rowNum) -> {
        return Point.builder()
                .id(resultSet.getLong("id"))
                .width(resultSet.getDouble("width"))
                .height(resultSet.getDouble("height"))
                .build();
    };

    private Way current;
    private final int Radius = 6371;

    public WalkingWay(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Point[] findWay(Point begin, Point end) {
        this.current = new Way(begin, end);
        double forChecking = findDistance(current.getBegin(), current.getEnd());
        System.out.println(forChecking);
        return null;
    }

    public double findDistance(Point begin, Point end){
        double distance = (Radius*(Math.acos( Math.sin(begin.getWidth()*end.getWidth())+ Math.cos(begin.getWidth())* Math.cos(end.getWidth())*Math.cos(begin.getHeight() - end.getHeight()))));
        return distance;
    }

    @Override
    public Object find(Long id) {
        List<Point> result = template.query(SQL_SELECT_BY_ID, rowMapper, id);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<Point> findAll() {
        return template.query(SQL_SELECT_ALL, rowMapper);
    }
}
