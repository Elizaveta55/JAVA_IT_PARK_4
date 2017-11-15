public interface AutosDao extends CrudDao<Auto> {
    Auto findOneByName(String name);
//    Human findOwnerByModel (String model);
}
