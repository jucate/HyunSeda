package co.com.hyunseda.market.service;

import co.com.hyunseda.market.dataAccess.Factory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void getInstance() {
        Factory instance1 = Factory.getInstance();
        Factory instance2 = Factory.getInstance();

        assertSame(instance1, instance2, "Las instancias deben ser la misma");
    }

    @Test
    void getRepository() {
    }

    @Test
    void getRepositoryCategory() {
    }
}