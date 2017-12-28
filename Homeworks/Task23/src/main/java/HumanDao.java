import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HumanDao implements CrudDao {
    private EntityManager manager;

    public HumanDao (SessionFactory factory){
        manager = factory.createEntityManager();
    }

    @Override
    public void save(Object model) {
        manager.getTransaction().begin();
        manager.persist(model);
        manager.getTransaction().commit();
    }

    @Override
    public Object find(Long id) {
        return manager.find(Human.class, id);
    }

    @Override
    public void update(Object model) {
        manager.getTransaction().begin();
        manager.refresh(model);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        manager.getTransaction().begin();
        manager.remove(find(id));
        manager.getTransaction().commit();
    }

    @Override
    public List findAll() {
        TypedQuery<Human> humanQuery = manager.createQuery("from Human", Human.class);
        List<Human> humanList = humanQuery.getResultList();
        return humanList;
    }
}
