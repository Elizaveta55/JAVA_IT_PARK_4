import java.util.List;

public class HumanService {
    private HumansDao humansDao;

    public HumanService(HumansDao humansDao){
        this.humansDao = humansDao;
    }

    public void registerUser(String name, int age){
        Human existingHuman = humansDao.findOneByName(name);
        if (existingHuman != null) {
            throw new IllegalArgumentException("Already exist");
        }
        Human user = Human.builder()
                .name(name)
                .age(age)
                .build();
        humansDao.save(user);
    }

    public void deleteUser(Long id){
            humansDao.delete(id);
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
