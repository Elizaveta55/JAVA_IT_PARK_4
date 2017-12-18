import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.Assert.*;

public class WalkingWayTest {
    private WalkingWay walkingWay;

    @Before
    public void setDB(){
//        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
//        .setType(EmbeddedDatabaseType.HSQL)
//        .addScript("schema.sql")
//        .addScript("data.sql")
//        .build();
//        walkingWay = new WalkingWay(database);
        ApplicationContext context = new ClassPathXmlApplicationContext("test_context.xml");
        walkingWay = context.getBean(WalkingWay.class);
    }

    @Test
    public void walkingWayTest() {
        Point begin = (Point) walkingWay.find(1l);
        Point end = (Point) walkingWay.find(2l);
        double expect = 10354.245257689065;
        double actual = walkingWay.findDistance(begin,end);
        Assert.assertEquals(actual,expect,0);
    }
}