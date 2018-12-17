/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;


import com.samples.entity.Humidity;
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
public class HumidityFacade {

    @PersistenceContext(unitName= "ServerSideMoniAsthmaPU")
    
    private EntityManager em;
    
    public List<Humidity> findAll(){
        return em.createQuery("SELECT h FROM Humidity h ORDER BY h.huDate").getResultList();
    }
    
    
      public List<Humidity> findByDate(Date fromDate, Date toDate) {
      //SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   
      StringBuilder query = new StringBuilder("select h from Humidity h");
      
      if (fromDate != null || toDate != null) {
          query.append(" WHERE 1=1");
      }
      
      //if (pfcomment != null && pfcomment != "") {
      //    query.append( " AND UPPER(p.pfComment) LIKE :pfcomment");
      //}
      if (fromDate != null) {
          query.append( " AND h.huDate >= :fromdate");
      }
      if (toDate != null) {
          query.append( " AND h.huDate <= :todate");
      }
      
      query.append(" ORDER BY h.huDate");
      
      Query entityQuery = em.createQuery(query.toString());
      
      if (fromDate != null) {
          entityQuery.setParameter("fromdate", fromDate);
      }
      if (toDate != null) {
          entityQuery.setParameter("todate", toDate);
      }
      
      return entityQuery.getResultList();
    }
      
      
      public void addHumidity(Humidity humidity){
      em.persist(humidity);
    }
}
