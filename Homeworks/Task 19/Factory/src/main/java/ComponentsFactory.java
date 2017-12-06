import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ComponentsFactory {
    private static ComponentsFactory componentsFactory;
    private Properties properties;

    private ComponentsFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    static {
        componentsFactory = new ComponentsFactory();
    }

    public static ComponentsFactory getComponentsFactory(){
        return componentsFactory;
    }

    public HumansDao getHumanDao(DataSource dataSource){
        String humanDaoClassName = properties.getProperty("humanDao.component.class");
        try{
            Class<HumansDao> humansDaoClass = (Class<HumansDao>)Class.forName(humanDaoClassName);
            Constructor<HumansDao> humansDaoConstructor = humansDaoClass.getConstructor(DataSource.class);
            HumansDao humansDaoInstance = humansDaoConstructor.newInstance(dataSource);
            return humansDaoInstance;
        } catch (ReflectiveOperationException e){
            throw new IllegalArgumentException(e);
        }
    }

}