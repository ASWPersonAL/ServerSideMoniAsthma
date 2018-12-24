/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Peakflow;
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
public class PeakflowFacade {

    @PersistenceContext(unitName = "ServerSideMoniAsthmaPU")
    
    private EntityManager em;
    
////Class methods.
    
    //// Method to get all elements in Pekaflow table in DB.     
    
    public List<Peakflow> findAll(){
        return em.createQuery("SELECT p FROM Peakflow p ORDER BY p.pfDate").getResultList();
    }
    
    //// Method to select elements from peakflow table within a selected Date range.
    
  public List<Peakflow> findByDate(Date fromDate, Date toDate) {
      StringBuilder query = new StringBuilder("select p from Peakflow p");
      
      if (fromDate != null || toDate != null) {
          query.append(" WHERE 1=1");
      }
      
      if (fromDate != null) {
          query.append( " AND p.pfDate >= :fromdate");
      }
      if (toDate != null) {
          query.append( " AND p.pfDate <= :todate");
      }
      
      query.append(" ORDER BY p.pfDate");
      
      Query entityQuery = em.createQuery(query.toString());
      
      if (fromDate != null) {
          entityQuery.setParameter("fromdate", fromDate);
      }
      if (toDate != null) {
          entityQuery.setParameter("todate", toDate);
      }
      
      return entityQuery.getResultList();
    }
  
    //// Method to add a peakflow element to table. 
  
    public void addPeakflow(Peakflow peakflow){
      em.persist(peakflow);
    }
    
}

