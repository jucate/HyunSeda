package co.com.hyunseda.market.service;
import co.com.hyunseda.market.dataAccess.*;
import co.com.hyunseda.market.infra.Publisher;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Service extends Observable {
    private IProductRepository repositoryProduct;
    private ICategoryRepository repositoryCategory;
    Publisher publisher = new Publisher();

    public Service(IProductRepository repository){
        this.repositoryProduct = repository;
    }
    public Service(ICategoryRepository repository){
        this.repositoryCategory = repository;
    }

    public boolean saveProduct(Product newProduct) {
        Gson gson = new Gson();
        String msgJson = gson.toJson(newProduct);
        //String aux = publisher.entra();
        
        publisher.publish(msgJson);
        return repositoryProduct.save(newProduct);

    }
    public boolean editProduct(Long productId, Product prod){
        return repositoryProduct.edit(productId, prod);
    }
    public Product findProductById(Long id){
        return repositoryProduct.findById(id);
    }
    public boolean deleteProduct(Long id){
        
        return repositoryProduct.delete(id);
    }
    public List<Product> listProducts(){
        List<Product> products = new ArrayList<>();
        products = repositoryProduct.list();
        return products;
    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repositoryProduct.findAll();
        return products;
    }
    public Product findProductByName(String name){
        return repositoryProduct.findByName(name);
    }
    //cruds category
    public boolean saveCategory(Category newCategory) {
        return repositoryCategory.save(newCategory);
    }
    public boolean editCategory(Long categoryId, Category cat){
        return repositoryCategory.edit(categoryId, cat);
    }
    public Category findCategoryById(Long id){
        return repositoryCategory.findByCategoryId(id);
    }
    public Category findCategoryByName(String name){
        return repositoryCategory.findByName(name);
    }
    public boolean deleteCategory(Long id){
        return repositoryCategory.delete(id);
    }
    public List<Category> listCategorys(){
        List<Category> categorys = new ArrayList<>();
        categorys = repositoryCategory.list();
        return categorys;
    }
    public List<Category> findAllCategorys() {
        List<Category> categorys = new ArrayList<>();
        categorys = repositoryCategory.findAll();
        return categorys;
    }
    public List<Product> findProductsByCategoryById(Long id){
        return repositoryProduct.findProductsByCategoryId(id);
    }
}
