import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WalkingWayTest {
    private WalkingWay walkingWay;

    @Before
    public void setDB(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test_context.xml");
        walkingWay = context.getBean(WalkingWay.class);
    }

    @Test
    public void walkingWayTest() {
        Point begin = (Point) walkingWay.find(1l);
        Point end = (Point) walkingWay.find(2l);
        double expect = 1318.0;
        double actual = walkingWay.findDistance(begin,end);
        Assert.assertEquals(actual,expect,0);
    }
}