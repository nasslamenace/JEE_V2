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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sasha
 */
@Stateless
public class Tab_EvaluationSb {

     @PersistenceContext 
    private EntityManager em;
     
     

         
        public TabEvaluation getTab(int id){
  


        
        TabEvaluation tab = em.createQuery("SELECT t FROM TabEvaluation t WHERE t.id = :id", TabEvaluation.class).setParameter("id", id).getSingleResult();

        return tab;
    }
     
}
