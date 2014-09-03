package nl.loxia.locatieapi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class LocatieAPILocalServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setWar("src/main/webapp");
        server.setHandler(context);
        server.start();
    }

}
