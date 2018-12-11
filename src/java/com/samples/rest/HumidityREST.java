/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.rest.HumidityFacade;
import com.samples.entity.Humidity;
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
@Path("humidity")
@RequestScoped
public class HumidityREST {

    @Context
    private UriInfo context;
    
    @Inject
    private HumidityFacade humidityFacade;

    /**
     * Creates a new instance of HumidityREST
     */
    public HumidityREST() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.HumidityREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({"application/json"})
    public List<Humidity> getJson(){
        return humidityFacade.findAll();
    }
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    /**
     * PUT method for updating or creating an instance of HumidityREST
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
