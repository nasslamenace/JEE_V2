/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pj;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author sasha
 */
@Stateless
public class SupervisorSb {
     @PersistenceContext 
    private EntityManager em;
    
    public List getUsers(){
  

        System.out.println("nass");
        Query q = em.createQuery("SELECT s FROM Supervisor s");
        
        
        return (List) q.getResultList();
    }



}
