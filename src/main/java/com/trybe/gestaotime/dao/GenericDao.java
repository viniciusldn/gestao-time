package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");

  private Class<T> persistedClass;

  protected GenericDao() {
  }

  protected GenericDao(Class<T> persistedClass) {
    this();
    this.persistedClass = persistedClass;
  }

  /**
   * Salva.
   */
  public void salvar(T entity) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Atualiza.
   */
  public void editar(T entity) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Remove.
   */
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();

    T toBeDeleted = em.find(persistedClass, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Retorna todos.
   */
  public List<T> listar() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(persistedClass);
    Root<T> root = cq.from(persistedClass);
    CriteriaQuery<T> data = cq.select(root);

    TypedQuery<T> allData = em.createQuery(data);
    return allData.getResultList();
  }

  /**
   * Retorna por id.
   */
  public T encontrar(Long id) {
    EntityManager em = emf.createEntityManager();

    return em.find(persistedClass, id);
  }
}
