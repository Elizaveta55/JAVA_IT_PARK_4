import java.util.List;

public class AutoService {
    private AutosDao autosDao;

    public AutoService (AutosDao autosDao){
        this.autosDao = autosDao;
    }

    public void registerUser(Auto user){
        String name = user.getName();

        Auto existingAuto = autosDao.findOneByName(name);

        if (existingAuto != null) {
            throw new IllegalArgumentException("Already exist");
        }

        autosDao.save(user);
    }

    public void deleteUser(Auto user){
        String name = user.getName();
        Auto existingAuto = autosDao.findOneByName(name);
        if (existingAuto != null){
            autosDao.delete(existingAuto.getID());
        }
    }

    public Auto findByID(Long id){
        Auto existingAuto = autosDao.find(id);
        if (existingAuto != null){
            return existingAuto;
        }
        return null;
    }

    public void changeFields(Auto user){
        autosDao.update(user);
    }

    public List<Auto> showAll(){
        List<Auto> existingHumans = autosDao.findAll();
        if (existingHumans.size() > 0 ) {
            return existingHumans;
        }
        return null;
    };
}