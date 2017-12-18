import java.util.List;

public interface MapDao<T> {
    T find(Long id);
    List<T> findAll();
}
