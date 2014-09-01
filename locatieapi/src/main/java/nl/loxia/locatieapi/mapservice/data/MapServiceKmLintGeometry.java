package nl.loxia.locatieapi.mapservice.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapServiceKmLintGeometry {
    public double[][][] paths;
}
