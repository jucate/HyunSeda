package co.com.hyunseda.market.dataAccess;

import co.com.hyunseda.market.service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class CategoryRepository implements ICategoryRepository {
    
    private Connection conn;
    
    public CategoryRepository() { initDatabase();}

    @Override
    public boolean save(Category newCategory) {
        try {
            //Validate product
            if (newCategory == null || newCategory.getName().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO categorys ( nameCat ) "
                    + "VALUES ( ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newCategory.getName());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Category findByCategoryId(Long id) {
        Category newCategory = new Category();
        try {

            String sql = "SELECT * FROM categorys  "
                    + "WHERE categoryId = ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("nameCat"));

            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newCategory;
    }
    
    @Override
    public Category findByName(String name) {
        Category newCategory = new Category();
        try {

            String sql = "SELECT * FROM categorys  "
                    + "WHERE nameCat = ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("nameCat"));

            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newCategory;
    }

    @Override
    public boolean edit(Long categoryId, Category category) {
        try {
            //Validate product
            if (categoryId <= 0 || category == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  categorys "
                    + "SET nameCat=? "
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, categoryId);
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

            String sql = "DELETE FROM categorys "
                    + "WHERE categoryId = ?";

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



    
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS categorys (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	nameCat text NOT NULL\n"
                + ");";
        //String createCategory = "INSERT INTO categorys (nameCat) VALUES (Fruta);";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //stmt.execute(createCategory);
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
    public List<Category> findAll() {
    List<Category> category = new ArrayList<>();
        try {

            String sql = "SELECT * FROM categorys";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category newCategory = new Category();
                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("nameCat"));

                category.add(newCategory);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public List<Category> list() {
    List<Category> category = new ArrayList<>();
        try {
            String sql = "SELECT categoryId, nameCat FROM categorys";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            while (rs.next()){
                Category newCategory =new Category();
                newCategory.setCategoryId(rs.getLong("ProductID"));
                newCategory.setName(rs.getString("Name"));

                category.add(newCategory);
            }
            //this.disconnect();;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }
}
