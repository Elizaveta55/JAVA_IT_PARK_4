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
}
