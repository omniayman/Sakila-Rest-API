package org.example.presistance;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactory instance;

    private EntityManagerFactoryProvider() {
    }

    synchronized public static EntityManagerFactory getInstance() {

        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("sakila");
        }

        return instance;
    }

}
