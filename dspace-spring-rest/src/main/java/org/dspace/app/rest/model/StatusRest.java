/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model;

import net.minidev.json.annotate.JsonIgnore;
import org.dspace.app.util.Util;

/**
 * Determine status of REST API - is it running, accessible and without errors?.
 * Find out API version (DSpace major version) and DSpace source version.
 * Find out your authentication status.
 *
 */
public class StatusRest extends DSpaceObjectRest
{

    private String sourceVersion;
    private String apiVersion;

    public static final String NAME = "status";
    public static final String CATEGORY = RestModel.CORE;

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public String getType() {
        return NAME;
    }


    private EPersonRest ePersonRest;

//    public StatusRest() {
//        setSourceVersion(Util.getSourceVersion());
//        String[] version = Util.getSourceVersion().split("\\.");
//        setApiVersion(version[0]); // major version
//    }
//
//    public StatusRest(String email, String fullname) {
//
//        setSourceVersion(Util.getSourceVersion());
//        String[] version = Util.getSourceVersion().split("\\.");
//        setApiVersion(version[0]); // major version
//    }

    public StatusRest(EPersonRest eperson) {
        setSourceVersion(Util.getSourceVersion());
        String[] version = Util.getSourceVersion().split("\\.");
        setApiVersion(version[0]); // major version
        if(eperson != null) {
            this.ePersonRest = eperson;
        }
    }

    public String getSourceVersion() {
        return this.sourceVersion;
    }

    public void setSourceVersion(String sourceVersion) {
        this.sourceVersion = sourceVersion;
    }


    public String getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @LinkRest(linkClass = EPersonRest.class)
    @JsonIgnore
    public EPersonRest getePersonRest() {
        return ePersonRest;
    }

    public void setePersonRest(EPersonRest ePersonRest) {
        this.ePersonRest = ePersonRest;
    }
}