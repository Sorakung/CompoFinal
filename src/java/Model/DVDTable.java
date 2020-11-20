/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author black
 */
public class DVDTable {
    public static Vector<Dvdcatalog> findAllDvdcatalog(EntityManager em) {
        Vector<Dvdcatalog> empList = null;
        try {
            empList = (Vector<Dvdcatalog>) em.createNamedQuery("Dvdcatalog.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    public static Dvdcatalog findDvdcatalogById(EntityManager em, int id) {
        Dvdcatalog emp = null;
        try {
            emp = em.find(Dvdcatalog.class, id);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateDvdcatalog(EntityManager em, Dvdcatalog emp) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setDvdname(emp.getDvdname());
            target.setRate(emp.getRate());
            target.setYyear(emp.getYyear());
            target.setPrice(emp.getPrice());
            target.setQuantity(emp.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    public static int removeDvdcatalog(EntityManager em, int id) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    }
    
    public static int insertDvdcatalog(EntityManager em, Dvdcatalog emp) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, emp.getId());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    }
}

