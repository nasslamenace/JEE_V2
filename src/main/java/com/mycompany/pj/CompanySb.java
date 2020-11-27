/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pj;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sasha
 */
@Stateless
public class CompanySb {
     @PersistenceContext 
    private EntityManager em;
     
     
        public Company getCompany(int id){
            
        Company c = em.createQuery("SELECT c FROM Company c WHERE c.id = :id", Company.class).setParameter("id", id).getSingleResult();

        return c;
    }
}
