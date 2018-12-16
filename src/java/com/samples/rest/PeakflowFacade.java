/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Peakflow;
import java.text.SimpleDateFormat;
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
    
    public List<Peakflow> findAll(){
        return em.createQuery("SELECT p FROM Peakflow p ORDER BY p.pfDate").getResultList();
    }
    
    
    
  public List<Peakflow> findByDate(Date fromDate, Date toDate) {
      //SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   
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
  
    public void addPeakflow(Peakflow peakflow){
      em.persist(peakflow);
    }
    
}


//  public List<Peakflow> findByComment(String pfcomment){
//        return em.createQuery("select p from Peakflow p where "+
//                "UPPER(p.pfComment) LIKE :pfcomment").
//                setParameter("pfcomment", "%" + pfcomment.toUpperCase() + "%").
//                        getResultList();
//    }
//  
//  public List<Peakflow> findById(String pfmeasureId){
//      return em.createQuery("select p from Peakflow p where " + 
//              "p.pfMeasureid LIKE :pfmeasureId").
//              setParameter("pfmeasureId", "%" ).
//              getResultList();
//  }