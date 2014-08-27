package nl.loxia.lokatieapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/lokatieapi")
public class LokatieService {
    @GET
    @Path("/helloworld/{test}")
    public Response helloWorld(@PathParam("test") String test) {
        String hello = "Hello world! " + test;
        return Response.ok(hello).build();
    }
}
