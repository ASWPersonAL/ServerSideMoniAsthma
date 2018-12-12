/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Peakflow;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ASW
 */
@Path("peakflow")
@RequestScoped
public class PeakflowREST {

    @Context
    private UriInfo context;

    @Inject
    private PeakflowFacade peakflowFacade; 
    
    /**
     * Creates a new instance of PeakflowREST
     */
    public PeakflowREST() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.PeakflowREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Peakflow> getJson(){
        return peakflowFacade.findAll();
    } 
    
    
    
    @GET
    @Path("/searchByDate/{fromDate}/{toDate}")
    @Produces("application/json")
    public List<Peakflow> findByDate(@PathParam("fromDate") String from, @PathParam("toDate") String to) {
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
        return peakflowFacade.findByDate(fromDate, toDate);
    }
 
    @GET
    @Path("/search/{pfComment}")
    @Produces("application/json")
    public List<Peakflow> findByComment(@PathParam("pfComment") String pfcomment){
        return peakflowFacade.findByComment(pfcomment);
    }
    
    @GET
    @Path("{pfMeasureid}")
    @Produces("application/json")
    public List<Peakflow> findById(@PathParam("pfMeasureid") String pfmeasureId){
        return peakflowFacade.findById(pfmeasureId);
    }
 

    /**
     * PUT method for updating or creating an instance of PeakflowREST
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
