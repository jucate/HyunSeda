package co.com.hyunseda.market.dataAccess;


import co.com.hyunseda.market.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductRepository implements IProductRepository {


    private Connection conn;
    /**
     * Constructor que inicia la base de datos
     * @author Libardo, Julio
     */

    public ProductRepository() { initDatabase();}


    public boolean save(Product newProduct) {

        try {
            //Validate product
            if (newProduct == null || newProduct.getName().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO products ( name, description, categoryId, price ) "
                    + "VALUES ( ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProduct.getName());
            pstmt.setString(2, newProduct.getDescription());
            pstmt.setLong(3, newProduct.getCategoryId());
            pstmt.setDouble(4, newProduct.getPrice());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT productId, name, description, price FROM Product";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            while (rs.next()){
                Product newProduct =new Product();
                newProduct.setProductId(rs.getLong("ProductID"));
                newProduct.setName(rs.getString("Name"));
                newProduct.setDescription(rs.getString("Description"));
                newProduct.setPrice(rs.getDouble("Price"));

                products.add(newProduct);
            }
            //this.disconnect();;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM products";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                newProduct.setPrice(rs.getDouble("price"));
                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        
        String sql = "CREATE TABLE IF NOT EXISTS products (\n"
                + "	productId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	description text NULL,\n"
                + "     categoryId integer NOT NULL,"
                + "     price number NULL,\n"
                + "     FOREIGN KEY(categoryId) references categorys(categoryId)\n"
                + ");";
        
        //String createProducts = "INSERT INTO products (name,description,categoryId,price) VALUES (Pera,a,1,1000);";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.execute(createProducts);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./myDatabase.db"; //Para Linux/Mac
        //String url = "jdbc:sqlite:C:/sqlite/db/myDatabase.db"; //Para Windows
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public boolean edit(Long id, Product product) {
        try {
            //Validate product
            if (id <= 0 || product == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  products "
                    + "SET name=?, description=? "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM products "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Product findById(Long id) {
        Product newProduct = new Product();
        try {

            String sql = "SELECT * FROM products  "
                    + "WHERE productId = ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                newProduct.setCategoryId(rs.getLong("categoryId"));
                newProduct.setPrice(rs.getDouble("price"));


            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newProduct;
    }
    @Override
    public Product findByName(String name) {
        Product newProduct = new Product();
        try {

            String sql = "SELECT * FROM products  "
                    + "WHERE name = ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                newProduct.setCategoryId(rs.getLong("categoryId"));
                newProduct.setPrice(rs.getDouble("price"));

            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newProduct;
    }
    @Override
    public List<Product> findProductsByCategoryId(Long id) {
        List<Product> newList = new ArrayList<>();  
        try {

            String sql = "SELECT * FROM products  "
                    + "WHERE categoryId = ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                newProduct.setCategoryId(rs.getLong("categoryId"));
                newProduct.setPrice(rs.getDouble("price"));
                newList.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newList;
    }
}
