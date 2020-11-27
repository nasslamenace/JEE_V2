/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pj;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sasha
 */
@Stateless
public class StudentSb {
     @PersistenceContext 
    private EntityManager em;
     
     
         public List getUsers(){
  


        Query q = em.createQuery("SELECT s FROM Student s");
        
        
        return (List) q.getResultList();
    }
    public Student getStudent(int id){
  


        
        Student s = em.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class).setParameter("id", id).getSingleResult();

        return s;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
