/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ASW
 */
public class BaselineResource {

    private String id;

    /**
     * Creates a new instance of BaselineResource
     */
    private BaselineResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the BaselineResource
     */
    public static BaselineResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of BaselineResource class.
        return new BaselineResource(id);
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.BaselineResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BaselineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource BaselineResource
     */
    @DELETE
    public void delete() {
    }
}
