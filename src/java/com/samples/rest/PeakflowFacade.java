/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Peakflow;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASW
 */
@Stateless
public class PeakflowFacade {

    @PersistenceContext(unitName = "ServerSideMoniAsthmaPU")
    
    private EntityManager em;
    
    public List<Peakflow> findAll(){
        return em.createQuery("select p from Peakflow p").getResultList();
    }
    
  public List<Peakflow> findByComment(String pfcomment){
        return em.createQuery("select p from Peakflow p where "+
                "UPPER(p.pfComment) LIKE :pfcomment").
                setParameter("pfcomment", "%" + pfcomment.toUpperCase() + "%").
                        getResultList();
    }
  
  public List<Peakflow> findById(String pfmeasureId){
      return em.createQuery("select p from Peakflow p where " + 
              "p.pfMeasureid LIKE :pfmeasureId").
              setParameter("pfmeasureId", "%" ).
              getResultList();
  }
    
}
