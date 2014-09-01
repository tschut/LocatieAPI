package nl.loxia.locatieapi.mapservice.data;

public class RDCoordinaten {
    public double x;
    public double y;

    public RDCoordinaten() {
    }

    public RDCoordinaten(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(RDCoordinaten other) {
        return Math.hypot(x - other.x, y - other.y);
    }
}
