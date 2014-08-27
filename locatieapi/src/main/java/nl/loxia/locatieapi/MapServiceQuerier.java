package nl.loxia.locatieapi;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.WebResource;

public class MapServiceQuerier {
    String baseUrl;

    public MapServiceQuerier(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public KmLintKmLocatie query(KmLintKmLocatie kmLintKmLocatie) {
        KmLintKmLocatie result = new KmLintKmLocatie(kmLintKmLocatie);

        String query = baseUrl + "18/query?where=NAAM=%27" + kmLintKmLocatie.kmlint
                + "%27&outFields=*&returnGeometry=true&f=pjson";

        Client client = Client.create();
        WebResource webResource = client.resource(query);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatusInfo() != Status.OK) {
            // todo error handling
        }
        String responseString = response.getEntity(String.class);
        return result;
    }
}
