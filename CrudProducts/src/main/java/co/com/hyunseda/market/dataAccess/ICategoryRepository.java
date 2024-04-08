package co.com.hyunseda.market.dataAccess;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ICategoryRepository {
    boolean save(Category newCategory);
    Category findByCategoryId(Long id);
    Category findByName(String name);
    boolean edit(Long id, Category category);
    boolean delete(Long id);
    public List<Category> findAll();
    List<Category> list();
}
