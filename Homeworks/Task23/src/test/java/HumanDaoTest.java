import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class HumanDaoTest {
    HumanDao humanDao;
    JdbcTemplate template;

    RowMapper<Human> rowMapper = (resultSet, rowNum) ->
    {
        return Human.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .age(resultSet.getInt("age"))
                .build();
    };


    @Before
    public void setUp() throws Exception {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("create.sql")
                .addScript("data.sql")
                .build();
        template = new JdbcTemplate(database);
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb");
        configuration.addAnnotatedClass(Human.class);
        SessionFactory factory = configuration.buildSessionFactory();
        humanDao = new HumanDao(factory);
    }

    @Test
    public void save() throws Exception {
        Human expected = Human.builder()
                .id(5L)
                .name("Pochemy")
                .age(66)
                .build();
        humanDao.save(expected);
        Human actual = template.queryForObject("SELECT * FROM humans WHERE id = 5", rowMapper);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find() throws Exception {
        Human expected = Human.builder()
                .id(3L)
                .name("KakDela")
                .age(44)
                .build();
        Human actual = (Human) humanDao.find(3L);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        Human expected = Human.builder()
                .id(3L)
                .name("KakDela")
                .age(45)
                .build();
        humanDao.update(expected);
        Human actual = template.queryForObject("SELECT * FROM humans WHERE id = 3", rowMapper);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() throws Exception {
        humanDao.delete(1L);
        Human actual = template.queryForObject("SELECT * FROM humans WHERE id = 1", rowMapper);
        Human expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() throws Exception {
        Human expected1 = Human.builder()
                .id(1L)
                .name("Trololo")
                .age(22)
                .build();
        Human expected2 = Human.builder()
                .id(2L)
                .name("Privet")
                .age(33)
                .build();
        Human expected3 = Human.builder()
                .id(3L)
                .name("KakDela")
                .age(44)
                .build();
        Human expected4 = Human.builder()
                .id(4L)
                .name("YaSprashivau")
                .age(55)
                .build();
        List<Human> expectedHumans = new LinkedList<>();
        expectedHumans.add(expected1);
        expectedHumans.add(expected2);
        expectedHumans.add(expected3);
        expectedHumans.add(expected4);

        List<Human> actualHumans = template.query("SELECT * FROM humans", rowMapper);

        Assert.assertEquals(expectedHumans, actualHumans);
    }
}