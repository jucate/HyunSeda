package co.com.hyunseda.market.service;

import co.com.hyunseda.market.dataAccess.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getCategoryId() {
        Category newCategory = new Category();
        newCategory.setCategoryId((long)1);
        assertEquals((long)1,newCategory.getCategoryId());
    }

    @Test
    void setCategoryId() {
        Category newCategory = new Category();
        newCategory.setCategoryId((long)1);
        assertEquals((long)1,newCategory.getCategoryId());
    }

    @Test
    void getName() {
        Category newCategory = new Category();
        newCategory.setName("Fruta");
        assertEquals("Fruta",newCategory.getName());
    }

    @Test
    void setName() {
        Category newCategory = new Category();
        newCategory.setName("Fruta");
        assertEquals("Fruta",newCategory.getName());
    }
}