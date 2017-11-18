package com.estagiario.mrcheese.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public abstract class BasicRepository<T, I extends Serializable> {

    @Inject
    private EntityManager entityManager;

    private Class<T> tClass;

    BasicRepository(Class<T> tClass) {
        this.tClass = tClass;
    }

    protected BasicRepository() {
    }

    public <T> T persist(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public <T> T merge(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    public void remove(Long id) {
        T reference = entityManager.getReference(tClass, id);
        entityManager.remove(reference);
    }

    public T find(Long id) {
        return entityManager.find(tClass, id);
    }

    public List<T> findAll(String query){
        TypedQuery<T> typedQuery = entityManager.createQuery(query, tClass);
        return typedQuery.getResultList();
    }

    public T findOne(String query){
        TypedQuery<T> typedQuery = entityManager.createQuery(query, tClass);
        return typedQuery.getSingleResult();
    }


}
