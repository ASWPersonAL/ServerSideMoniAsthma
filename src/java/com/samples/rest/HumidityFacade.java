/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Humidity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASW
 */
@Stateless
public class HumidityFacade {

   @PersistenceContext(unitName="ServerSideMoniAsthmaPU")
   
   private EntityManager em;
   
   public List<Humidity> findAll(){
       return em.createQuery("SELECT h FROM Humidity h ORDER BY h.hDate").getResultList();
   }
}
