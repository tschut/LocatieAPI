package nl.loxia.locatieapi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.googlecode.htmleasy.HtmleasyProviders;

public class LocatieAPIApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> result = new HashSet<Class<?>>();
        result.add(nl.loxia.locatieapi.LocatieService.class);

        result.addAll(HtmleasyProviders.getClasses());

        return result;
    }
}
