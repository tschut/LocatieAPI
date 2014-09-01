package nl.loxia.locatieapi.mapservice.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapServiceKmLintFeatures {
    public MapServiceKmLintAttributes attributes;
    public MapServiceKmLintGeometry geometry;
}
