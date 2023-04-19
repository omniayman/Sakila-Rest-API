package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.presistance.EntityManagerFactoryProvider;
import org.example.presistance.exceptionHandler.InvalidDataException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class Crud<T, ID> {
    EntityManager entityManager = EntityManagerFactoryProvider.getInstance().createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<T> findAll() {


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> root = query.from(getEntityClass());
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public T findById(ID id, Class<T> entityClass) {

        T entity = entityManager.find(entityClass, id);
        return entity;
    }

    public void add(T entity) throws InvalidDataException {


        entityManager.getTransaction().begin();
        System.out.println("******");

        System.out.println("-----");
        entityManager.persist(entity);
        entityManager.getTransaction().commit();


    }

    public void update(T entity) {

        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

    }


    private Class<T> getEntityClass() {
        // Use reflection to get the entity class for the generic type parameter T
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }
}
