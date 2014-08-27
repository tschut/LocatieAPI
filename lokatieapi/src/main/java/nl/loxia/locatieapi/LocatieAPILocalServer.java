package nl.loxia.locatieapi;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class LocatieAPILocalServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setWar("src/main/webapp");
        server.addHandler(context);
        server.start();
    }

}
