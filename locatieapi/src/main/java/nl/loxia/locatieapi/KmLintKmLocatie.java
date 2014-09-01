package nl.loxia.locatieapi;

import nl.loxia.locatieapi.mapservice.data.RDCoordinaten;

public class KmLintKmLocatie {
    public String kmlint;
    public int km;

    public String omschrijving;
    public RDCoordinaten rdCoordinaten;
    public Integer kmvan;
    public Integer kmtot;

    public KmLintKmLocatie(String kmlint, int km) {
        this.kmlint = kmlint;
        this.km = km;
    }

    public KmLintKmLocatie(KmLintKmLocatie other) {
        this.kmlint = other.kmlint;
        this.km = other.km;
    }

}
