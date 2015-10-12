package net.lafortu.tellit.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

@ApplicationPath("/")
public class ApplicationClass extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(TellItService.class);
        return classes;
    }
    
    @Override
    public Set<Object> getSingletons() {
      Set<Object> s = new HashSet<Object>();
      
      // Register Jackson as JAXB to JSON provider
      ObjectMapper mapper = new ObjectMapper();
      AnnotationIntrospector introspector =
          new JaxbAnnotationIntrospector(mapper.getTypeFactory());   
      mapper.setAnnotationIntrospector(introspector);
      
      JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
      jaxbProvider.setMapper(mapper);
      s.add(jaxbProvider);
      
      return s;
    }
}