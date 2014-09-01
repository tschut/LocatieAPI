package nl.loxia.locatieapi.mapservice.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapServiceKmLintAttributes {
    @JsonProperty("OMSCHRIJVING")
    public String omschrijving;

    @JsonProperty("KMVAN")
    public Double kmvan;

    @JsonProperty("KMTOT")
    public Double kmtot;
}
