/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Peakflow;
import com.samples.rest.PeakflowFacade;
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
//import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("/peakflow")
@RequestScoped
public class PeakflowsResources {
    
    //// Inject the Facade class that has the defined methods for the GET/POST methods.    

    @Inject
    private PeakflowFacade peakflowFacade;
    
    /**
     * Creates a new instance of PeakflowsResources
     */
    public PeakflowsResources() {
    }

    /**
     * Retrieves representation of an instance of com.samples.entity.PeakflowsResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Peakflow> findAllPeakflow(){
        return peakflowFacade.findAllPeakflow();
    } 
    
    
    @GET
    @Path("/searchByDate/{fromDate}/{toDate}")
    @Produces("application/json")
    public List<Peakflow> findByDatePeakflow(@PathParam("fromDate") String from, @PathParam("toDate") String to) {
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
        return peakflowFacade.findByDatePeakflow(fromDate, toDate);
    }
    
     /**
     * POST method for creating an instance of PeakflowResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void addPeakflow(Peakflow peakflow){
        peakflowFacade.addPeakflow(peakflow);
    }
 
}
