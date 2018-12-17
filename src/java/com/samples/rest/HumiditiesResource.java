/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Humidity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("/hu")
@RequestScoped
public class HumiditiesResource {

    @Context
    private UriInfo context;
    
    @Inject
    private HumidityFacade humidityFacade;

    /**
     * Creates a new instance of HumiditiesResource
     */
    public HumiditiesResource() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.HumiditiesResource
     * @return an instance of java.lang.String
     */
   @GET
    @Produces("application/json")
    public List<Humidity> getJson(){
        return humidityFacade.findAll();
    }

    @GET
    @Path("/searchByDate/{fromDate}/{toDate}")
    @Produces("application/json")
    public List<Humidity> findByDate(@PathParam("fromDate") String from, @PathParam("toDate") String to) {
        Date fromDate;
        Date toDate;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); 
        try {
            fromDate = format.parse(from);
        } catch (ParseException ex) {
            fromDate = null;
        }
        try {
            toDate = format.parse(to);
        } catch (ParseException ex) {
            toDate = null;
        }
        return humidityFacade.findByDate(fromDate, toDate);
    }
    

    /**
     * POST method for creating an instance of HumidityResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void createHUmidityPoint(Humidity humidity){
        humidityFacade.addHumidity(humidity);
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public HumidityResource getHumidityResource(@PathParam("id") String id) {
        return HumidityResource.getInstance(id);
    }
}
