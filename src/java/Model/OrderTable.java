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
public class OrderTable {
    public static Vector<Orders> findAllOrder(EntityManager em) {
        Vector<Orders> empList = null;
        try {
            empList = (Vector<Orders>) em.createNamedQuery("Orders.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    public static Orders findOrdersById(EntityManager em, int id) {
        Orders emp = null;
        try {
            emp = em.find(Orders.class, id);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateOrders(EntityManager em, Orders emp) {
        try {
            em.getTransaction().begin();
            Orders target = em.find(Orders.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setDvdName(emp.getDvdName());
            target.setRate(emp.getRate());
            target.setYears(emp.getYears());
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
    public static int removeOrders(EntityManager em, int id) {
        try {
            em.getTransaction().begin();
            Orders target = em.find(Orders.class, id);
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
    
    public static int insertOrders(EntityManager em, Dvdcatalog emp) {
        try {
            em.getTransaction().begin();
            Orders target = em.find(Orders.class, emp.getId());
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

    public static void insertOrders(EntityManager em, Orders order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
