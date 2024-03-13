package co.com.hyunseda.market.service;

import co.com.hyunseda.market.dataAccess.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getCategoryId() {
        Product newProduct = new Product();
        newProduct.setCategoryId((long)1);
        assertEquals(newProduct.getCategoryId(),(long)1);
    }

    @Test
    void setCategoryId() {
        Product newProduct = new Product();
        newProduct.setCategoryId((long)1);
        assertEquals((long)1,newProduct.getCategoryId());
    }

    @Test
    void getProductId() {
        Product newProduct = new Product();
        newProduct.setName("Pera");
        newProduct.setCategoryId((long)1);
        newProduct.setProductId((long)1);
        assertEquals(newProduct.getProductId(),(long)1);
    }

    @Test
    void setProductId() {
        Product newProduct = new Product();
        newProduct.setCategoryId((long)1);
        assertEquals((long)1,newProduct.getCategoryId());
    }

    @Test
    void getName() {
        Product newProduct = new Product();
        newProduct.setName("Fruta");
        assertEquals("Fruta",newProduct.getName());
    }

    @Test
    void setName() {
        Product newProduct = new Product();
        newProduct.setName("Fruta");
        assertEquals("Fruta",newProduct.getName());
    }

    @Test
    void getDescription() {
        Product newProduct = new Product();
        newProduct.setDescription("Sabrosa");
        assertEquals("Sabrosa",newProduct.getDescription());
    }

    @Test
    void setDescription() {
        Product newProduct = new Product();
        newProduct.setDescription("Sabrosa");
        assertEquals("Sabrosa",newProduct.getDescription());
    }

    @Test
    void getCategory() {

    }

    @Test
    void setCategory() {
    }
}