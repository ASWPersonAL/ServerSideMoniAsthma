/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Messagetest;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASW
 */
@Stateless
public class MessagetestFacade {
   @PersistenceContext(unitName = "ServerSideMoniAsthmaPU")
    
    private EntityManager em;
    
    public List<Messagetest> findAll(){
        return em.createQuery("SELECT m FROM Messagetest m ORDER BY m.meId").getResultList();
    }
    
   
    
    public void createMe(Messagetest messagetest){
        em.persist(messagetest);
    }
    
    
	//private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    
  	//public Message addMessage(Message message) {
	//	message.setId(messages.size() + 1);
	//	messages.put(message.getId(), message);
	//	return message;
	//}
   
}
