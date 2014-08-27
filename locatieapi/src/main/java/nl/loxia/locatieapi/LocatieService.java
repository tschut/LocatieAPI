package nl.loxia.locatieapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/locatieapi")
public class LocatieService {
    @GET
    @Path("/kmlint-en-km/{kmlint}/{km}")
    @Produces({ "application/json" })
    public Response helloWorld(@PathParam("kmlint") String kmlint, @PathParam("km") String km) {
        String hello = "Hello world! " + kmlint + ":" + km;

        KmLintKmLocatie input = new KmLintKmLocatie(kmlint, km);

        return Response.ok(hello).build();
    }
}
