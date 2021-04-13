/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m.JPA;

import com.project.travelstar.m.JPA.CountryCodes;
import com.project.travelstar.m.exceptions.NonexistentEntityException;
import com.project.travelstar.m.exceptions.PreexistingEntityException;
import com.project.travelstar.m.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Rex Worthington
 */
public class CountryCodesJpaController implements Serializable {

    public CountryCodesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CountryCodes countryCodes) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(countryCodes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCountryCodes(countryCodes.getCountriesCode()) != null) {
                throw new PreexistingEntityException("CountryCodes " + countryCodes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CountryCodes countryCodes) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            countryCodes = em.merge(countryCodes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = countryCodes.getCountriesCode();
                if (findCountryCodes(id) == null) {
                    throw new NonexistentEntityException("The countryCodes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            CountryCodes countryCodes;
            try {
                countryCodes = em.getReference(CountryCodes.class, id);
                countryCodes.getCountriesCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The countryCodes with id " + id + " no longer exists.", enfe);
            }
            em.remove(countryCodes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CountryCodes> findCountryCodesEntities() {
        return findCountryCodesEntities(true, -1, -1);
    }

    public List<CountryCodes> findCountryCodesEntities(int maxResults, int firstResult) {
        return findCountryCodesEntities(false, maxResults, firstResult);
    }

    private List<CountryCodes> findCountryCodesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CountryCodes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CountryCodes findCountryCodes(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CountryCodes.class, id);
        } finally {
            em.close();
        }
    }

    public int getCountryCodesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CountryCodes> rt = cq.from(CountryCodes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
