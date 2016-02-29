package com.doj.spittr.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.doj.spittr.persistence.config.SpittrPersistenceConfig;
import com.doj.spittr.web.config.SpittrMvcConfiguration;
import com.doj.spittr.web.controller.ImageServlet;

public class SpittrWebApplicationIntializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
	}
	
	private void registerListener(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext;
        rootContext = createContext(SpittrPersistenceConfig.class,ImageServlet.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
    }
	
	private void registerDispatcherServlet(ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(SpittrMvcConfiguration.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}
	
	 /**
     * Factory method to create {@link AnnotationConfigWebApplicationContext} instances. 
     * @param annotatedClasses
     * @return
     */
    private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
}
