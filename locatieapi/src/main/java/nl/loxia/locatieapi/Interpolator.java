package nl.loxia.locatieapi;

import nl.loxia.locatieapi.mapservice.data.RDCoordinaten;

public class Interpolator {
    public static RDCoordinaten interpolate(Integer x, Double kmvan, RDCoordinaten[] path) {
        RDCoordinaten result = new RDCoordinaten();

        double gelopen = kmvan;
        for (int i = 0; i < path.length - 1; i++) {
            gelopen += path[i].distanceTo(path[i + 1]);

            if (gelopen > x) {
                result = path[i];
                break;
            }
        }
        return result;
    }
}
