package nl.loxia.locatieapi;

public class KmLintKmLocatie {
    public String kmlint;
    public String km;

    public KmLintKmLocatie(String kmlint, String km) {
        this.kmlint = kmlint;
        this.km = km;
    }

    public KmLintKmLocatie(KmLintKmLocatie other) {
        this.kmlint = other.kmlint;
        this.km = other.km;
    }

}
