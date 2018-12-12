/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Baseline;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("/bl")
@RequestScoped
public class BaselinesResource {

    @Context
    private UriInfo context;
    
    @Inject
    private BaselineFacade baselineFacade;

    /**
     * Creates a new instance of BaselinesResource
     */
    public BaselinesResource() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.BaselinesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Baseline> getJson(){
        return baselineFacade.findAll();
    }

    /**
     * POST method for creating an instance of BaselineResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
   
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void createbl(Baseline baseline){
        baselineFacade.createbl(baseline);
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public BaselineResource getBaselineResource(@PathParam("id") String id) {
        return BaselineResource.getInstance(id);
    }
}
