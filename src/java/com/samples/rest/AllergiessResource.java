/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Allergies;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
@Path("/allergies")
@RequestScoped
public class AllergiessResource {
    
 //// Inject the Facade class that has the defined methods for the GET/POST methods.     
    
    @Inject
    private AllergiesFacade allergiesFacade;

    /**
     * Creates a new instance of AllergiessResource
     */
    public AllergiessResource() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.AllergiessResource
     * @return an instance of java.lang.String
     */
   @GET
    @Produces("application/json")
    public List<Allergies> getJson(){
        return allergiesFacade.findAll();
    }
    
    @GET
    @Path("/searchByDate/{fromDate}/{toDate}")
    @Produces("application/json")
    public List<Allergies> findByDate(@PathParam("fromDate") String from, @PathParam("toDate") String to) {
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
        return allergiesFacade.findByDate(fromDate, toDate);
    }
    

    /**
     * POST method for creating an instance of AllergiesResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void createAllergiesPoint(Allergies allergy){
        allergiesFacade.addAllergies(allergy);
    }

}
