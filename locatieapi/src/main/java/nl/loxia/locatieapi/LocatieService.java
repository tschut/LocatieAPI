package nl.loxia.locatieapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/locatieapi")
public class LocatieService {
    @GET
    @Path("/geocode-en-km/{geocode}/{km}")
    @Produces({ "application/json" })
    public Response helloWorld(@PathParam("geocode") String geocode, @PathParam("km") String km) {
        String hello = "Hello world! " + geocode + ":" + km;

        GeocodeKmLocatie input = new GeocodeKmLocatie(geocode, km);

        return Response.ok(hello).build();
    }
}
