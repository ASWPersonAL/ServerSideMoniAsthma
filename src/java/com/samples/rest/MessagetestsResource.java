/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Messagetest;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("/ms")
@RequestScoped
public class MessagetestsResource {

    @Context
    private UriInfo context;
    
    @Inject
    private MessagetestFacade messagetestFacade;

    /**
     * Creates a new instance of MessagetestsResource
     */
    public MessagetestsResource() {
    }
   
    
    /**
     * Retrieves representation of an instance of com.samples.rest.MessagetestsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Messagetest> getJson(){
        return messagetestFacade.findAll();
    }
    
   // @POST
   // @Produces("application/json")
   // public String addMessage(){
    //    return "What"; 
   // }
    
   @POST
   @Produces("application/json")
   @Consumes("application/json")
  public void create(Messagetest messagetest){
      messagetestFacade.createMe(messagetest);
  }
     

    /**
     * POST method for creating an instance of MessagetestResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
 //   @POST
 //   @Consumes(MediaType.APPLICATION_JSON)
 //   @Produces(MediaType.APPLICATION_JSON)
 //   public Response postJson(String content) {
 //       //TODO
 //       return Response.created(context.getAbsolutePath()).build();
 //   }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public MessagetestResource getMessagetestResource(@PathParam("id") String id) {
        return MessagetestResource.getInstance(id);
    }
}
