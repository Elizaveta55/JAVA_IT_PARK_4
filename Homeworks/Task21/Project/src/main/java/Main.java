import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/Points";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    public static void main(String[] args){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
//        Point begin = Point.builder()
//                .id(1L)
//                .width(55.8194)
//                .height(49.105015)
//                .build();
//        Point end = Point.builder()
//                .id(2L)
//                .width(55.819366)
//                .height(49.126095)
//                .build();
        WalkingWay walkingWay = new WalkingWay(dataSource);
        Point begin = (Point) walkingWay.find(1l);
        Point end = (Point) walkingWay.find(2l);
        walkingWay.findWay(begin,end);
    }
}