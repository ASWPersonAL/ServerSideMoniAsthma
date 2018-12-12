/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Allergies;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("allergies")
@RequestScoped
public class AllergiesREST {

    @Context
    private UriInfo context;
    
    @Inject
    private AllergiesFacade allergiesFacade;

    /**
     * Creates a new instance of AllergiesREST
     */
    public AllergiesREST() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.AllergiesREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Allergies> getJson(){
        return allergiesFacade.findAll();
    }

    /**
     * PUT method for updating or creating an instance of AllergiesREST
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
