/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m.JPA;

import com.project.travelstar.m.JPA.AirportCodes;
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
public class AirportCodesJpaController implements Serializable {

    public AirportCodesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AirportCodes airportCodes) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(airportCodes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAirportCodes(airportCodes.getIataCode()) != null) {
                throw new PreexistingEntityException("AirportCodes " + airportCodes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AirportCodes airportCodes) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            airportCodes = em.merge(airportCodes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = airportCodes.getIataCode();
                if (findAirportCodes(id) == null) {
                    throw new NonexistentEntityException("The airportCodes with id " + id + " no longer exists.");
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
            AirportCodes airportCodes;
            try {
                airportCodes = em.getReference(AirportCodes.class, id);
                airportCodes.getIataCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The airportCodes with id " + id + " no longer exists.", enfe);
            }
            em.remove(airportCodes);
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

    public List<AirportCodes> findAirportCodesEntities() {
        return findAirportCodesEntities(true, -1, -1);
    }

    public List<AirportCodes> findAirportCodesEntities(int maxResults, int firstResult) {
        return findAirportCodesEntities(false, maxResults, firstResult);
    }

    private List<AirportCodes> findAirportCodesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AirportCodes.class));
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

    public AirportCodes findAirportCodes(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AirportCodes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAirportCodesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AirportCodes> rt = cq.from(AirportCodes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
