package nl.loxia.locatieapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.loxia.locatieapi.mapservice.data.MapServiceKmLint;
import nl.loxia.locatieapi.mapservice.data.RDCoordinaten;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.WebResource;

public class MapServiceQuerier {
    private String baseUrl;

    public MapServiceQuerier(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public KmLintKmLocatie query(KmLintKmLocatie kmLintKmLocatie) {
        KmLintKmLocatie result = new KmLintKmLocatie(kmLintKmLocatie);

        String query = baseUrl + "18/query?where=NAAM=%27" + kmLintKmLocatie.kmlint
                + "%27&outFields=*&returnGeometry=true&f=pjson";

        Client client = Client.create();
        WebResource webResource = client.resource(query);
        ClientResponse response = webResource.get(ClientResponse.class);

        if (response.getStatusInfo() != Status.OK) {
            // todo error handling
        }
        MapServiceKmLint mapServiceKmLint = parseJson(response, MapServiceKmLint.class);

        result.omschrijving = mapServiceKmLint.features[0].attributes.omschrijving;
        result.kmvan = (int) (mapServiceKmLint.features[0].attributes.kmvan * 1000);
        result.kmtot = (int) (mapServiceKmLint.features[0].attributes.kmtot * 1000);
        result.rdCoordinaten = Interpolator.interpolate(kmLintKmLocatie.km,
                mapServiceKmLint.features[0].attributes.kmvan,
                convertToRdCoordinaten(mapServiceKmLint.features[0].geometry.paths[0]));

        return result;
    }

    public List<String> listKmLinten() {
        String query = baseUrl + "18/query?text=kilometerlint&outFields=*&returnGeometry=true&f=pjson";

        Client client = Client.create();
        WebResource webResource = client.resource(query);
        ClientResponse response = webResource.get(ClientResponse.class);

        if (response.getStatusInfo() != Status.OK) {
            // todo error handling
        }
        MapServiceKmLint kmLinten = parseJson(response, MapServiceKmLint.class);

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < kmLinten.features.length; ++i) {
            result.add(kmLinten.features[i].attributes.naam);
        }

        return result;
    }

    private RDCoordinaten[] convertToRdCoordinaten(double[][] ds) {
        RDCoordinaten[] result = new RDCoordinaten[ds.length];
        for (int i = 0; i < ds.length; ++i) {
            result[i] = new RDCoordinaten(ds[i][0], ds[i][1]);
        }
        return result;
    }

    private <T> T parseJson(ClientResponse response, Class<T> clazz) {
        String responseString = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(responseString, clazz);
        } catch (IOException e) {
            // todo error handling
            e.printStackTrace();
            return null;
        }
    }
}
