package co.com.hyunseda.market.dataAccess;

import java.util.List;

public interface IProductRepository {
    boolean save(Product newProduct);
    Product findById(Long id);
    Product findByName(String name);
    boolean edit(Long id, Product product);
    boolean delete(Long id);
    public List<Product> findAll();
    List<Product> list();
    List<Product> findProductsByCategoryId(Long id);
}
