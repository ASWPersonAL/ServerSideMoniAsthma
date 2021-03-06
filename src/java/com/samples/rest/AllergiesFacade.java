/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Allergies;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ASW
 */
@Stateless
public class AllergiesFacade {

    @PersistenceContext(unitName= "ServerSideMoniAsthmaPU")

    private EntityManager em;
    
////Class methods.
    
    //// Method to get all elements in allergies table in DB. 
    
    public List<Allergies> findAllAllergies(){
        return em.createQuery("SELECT a FROM Allergies a ORDER BY a.alDate").getResultList();
    }
    
    //// Method to select elements from allergies table within a selected Date range.
    
    public List<Allergies> findByDateAllergies(Date fromDate, Date toDate) {
      StringBuilder query = new StringBuilder("select a from Allergies a");
      
      if (fromDate != null || toDate != null) {
          query.append(" WHERE 1=1");
      }
      
      if (fromDate != null) {
          query.append( " AND a.alDate >= :fromdate");
      }
      if (toDate != null) {
          query.append( " AND a.alDate <= :todate");
      }
      
      query.append(" ORDER BY a.alDate");
      
      Query entityQuery = em.createQuery(query.toString());
      
      if (fromDate != null) {
          entityQuery.setParameter("fromdate", fromDate);
      }
      if (toDate != null) {
          entityQuery.setParameter("todate", toDate);
      }
      
      return entityQuery.getResultList();
    }
    
    //// Method to add an allergy element to table. 
    
     public void addAllergies(Allergies allergy){
      em.persist(allergy);
    }
    
}
