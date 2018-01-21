package com.estagiario.mrcheese.rest;

import com.estagiario.mrcheese.service.HomeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/home")
@RequestScoped
@Produces(APPLICATION_JSON)
public class HomeResource {

    @Inject
    private HomeService homeService;

    @GET
    @Path("/dash")
    public Response dash(){

        return Response.ok(homeService.dash()).build();

    }

    @GET
    @Path("/date")
    public Response date(@QueryParam("inicio") String dateIni, @QueryParam("fim") String dateFim){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {

            Date inicio = df.parse(dateIni);
            Date fim = df.parse(dateFim);

            return Response.ok(homeService.date(inicio, fim)).build();

        } catch (ParseException e) {

            e.printStackTrace();

            return Response.serverError().build();

        }


    }

}
