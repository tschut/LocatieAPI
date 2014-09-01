package nl.loxia.locatieapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/locatieapi")
public class LocatieService {
    private static final String MAPSERVICE_BASE_URL = "http://mapservices.prorail.nl/arcgis/rest/services/PGT_wfs/MapServer/";

    @GET
    @Path("/kmlint-en-km/{kmlint}/{km}")
    @Produces({ "application/json" })
    public Response helloWorld(@PathParam("kmlint") String kmlint, @PathParam("km") Integer km) {
        KmLintKmLocatie input = new KmLintKmLocatie(kmlint, km);
        MapServiceQuerier querier = new MapServiceQuerier(MAPSERVICE_BASE_URL);
        KmLintKmLocatie queryResult = querier.query(input);

        return Response.ok(queryResult).build();
    }
}
