package com.ufly;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyMain {

	public static void main(String[] args) throws Exception {
		// Initialize the server
		Server server = new Server();

		// Add a connector
		ServerConnector connector = new ServerConnector(server);
		connector.setHost("0.0.0.0");
		connector.setPort(8080);
		connector.setIdleTimeout(30000);
		server.addConnector(connector);

		// Configure Jersey
		ResourceConfig rc = new ResourceConfig();
		rc.packages(true, "com.ufly.ws");
		rc.register(JacksonFeature.class);
		rc.register(LoggingFilter.class);

		// Add a servlet handler for web services (/ws/*)
		ServletHolder servletHolder = new ServletHolder(new ServletContainer(rc));
		ServletContextHandler handlerWebServices = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handlerWebServices.setContextPath("/ws");
		handlerWebServices.addServlet(servletHolder, "/*");

		// Add a handler for resources (/*)
		ResourceHandler handlerPortal = new ResourceHandler();
		handlerPortal.setResourceBase("New_Front");
		handlerPortal.setDirectoriesListed(false);
		handlerPortal.setWelcomeFiles(new String[] { "home.html" });
		ContextHandler handlerPortalCtx = new ContextHandler();
		handlerPortalCtx.setContextPath("/");
		handlerPortalCtx.setHandler(handlerPortal);

		// Activate handlers
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { handlerWebServices, handlerPortalCtx });
		server.setHandler(contexts);
		
		// Start server
		server.start();
		
		
		System.out.println(handlerPortalCtx.getServletContext().getRealPath("/images"));

		// Generate data
		GenerateData gd = new GenerateData();
		// the function to manage the database (create data, delete old flights, send mails)
		gd.manageDatabase();
			
		

	}

}
