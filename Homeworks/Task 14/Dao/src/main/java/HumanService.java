import java.util.List;

public class HumanService {
    private HumansDao humansDao;

    public HumanService(HumansDao humansDao){
        this.humansDao = humansDao;
    }

    public void registerUser(Human user){
        String name = user.getName();
        Human existingHuman = humansDao.findOneByName(name);
        if (existingHuman != null) {
            throw new IllegalArgumentException("Already exist");
        }

        humansDao.save(user);
    }

    public void deleteUser(Human user){
        String name = user.getName();
        Human existingHuman = humansDao.findOneByName(name);
        if (existingHuman != null){
            humansDao.delete(existingHuman.getId());
        }
    }

    public Human findByID(Long id){
        Human existingHuman = humansDao.find(id);
        if (existingHuman != null){
            return existingHuman;
        }
        return null;
    }

    public void changeFields(Human user){
        humansDao.update(user);
    }

    public List<Human> showAll(){
        List<Human> existingHumans = humansDao.findAll();
        if (existingHumans.size() > 0 ) {
            return existingHumans;
        }
        return null;
    };
}
