import java.util.List;
import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class WalkingWay implements OptionalWay, MapDao {

    private static final String SQL_SELECT_ALL =
            "SELECT * FROM pointsonmap";
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
        List<Point> points = findAll();
        //double arrayOfPoints[][] = new double[100][2];
        Point arrayOfPoints[] = new Point[100];
        int i=0;
        while (points.iterator().hasNext() && i<points.size()) {
            if (points.get(i)!=null) {
                arrayOfPoints[i] = points.get(i);
            }
            i++;
        }
        double forChecking = findDistance(current.getBegin(), current.getEnd());
        System.out.println(forChecking);
        return null;
    }

    public double findDistance(Point begin, Point end){
        double firstWidth = Math.toRadians(begin.getWidth());
        double firstHeight = Math.toRadians(begin.getHeight());
        double secondWidth = Math.toRadians(end.getWidth());
        double secondHeight = Math.toRadians(end.getHeight());
        //double distance = (Radius*(Math.acos( Math.sin(firstWidth * secondWidth)+ Math.cos(firstWidth)* Math.cos(secondWidth)*Math.cos(firstHeight - secondHeight)))) * Math.PI/180;
        //double distance = ((Math.acos( Math.sin(firstWidth * secondWidth)+ Math.cos(firstWidth)* Math.cos(secondWidth)*Math.cos(firstHeight - secondHeight)))) * Math.PI/180;
        //double distance = Radius * 2 * Math.asin(Math.sqrt( Math.pow( Math.sin( (begin.getWidth() - Math.abs(end.getWidth())) * Math.PI/180/2),2) + Math.cos(begin.getWidth() * Math.PI/180)*Math.cos(Math.abs(end.getWidth()*Math.PI/180) * Math.pow(Math.sin((begin.getHeight()-end.getHeight()) * Math.PI/180/2),2))));
        double distance = Math.round( 6378137 * Math.acos( Math.cos( firstWidth ) * Math.cos( secondWidth ) * Math.cos(firstHeight-secondHeight) + Math.sin(firstWidth)*Math.sin(secondWidth)));
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
