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
public class InternshipSb {
     @PersistenceContext 
    private EntityManager em;
     
     
         public ArrayList<Integer> getIds(int userId){
  


        Query q = em.createQuery("SELECT i FROM Internship i WHERE i.iDSupervisor = :iDSupervisor").setParameter("iDSupervisor", userId);
        ArrayList<Internship> myList = new ArrayList<Internship>();
        myList.addAll((List) q.getResultList());
        ArrayList<Integer> idList = new ArrayList<Integer>();
        return idList;
    }
        public Internship getInternshipByStudentId(int id){
  


        
        Internship internship = em.createQuery("SELECT i FROM Internship i WHERE i.iDStudent = :iDStudent", Internship.class).setParameter("iDStudent", id).getSingleResult();

        return internship;
    }
         
        public Internship getInternship(int id){
  


        
        Internship internship = em.createQuery("SELECT i FROM Internship i WHERE i.iDSupervisor = :iDSupervisor", Internship.class).setParameter("iDSupervisor", id).getSingleResult();

        return internship;
    }
     
}
