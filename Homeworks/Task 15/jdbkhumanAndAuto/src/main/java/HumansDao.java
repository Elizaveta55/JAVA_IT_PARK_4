 public interface HumansDao extends CrudDao<Human> {
        Human findOneByName(String name);
    }
