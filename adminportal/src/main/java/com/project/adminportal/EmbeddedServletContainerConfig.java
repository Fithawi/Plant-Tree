package com.project.adminportal;

import java.io.File;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
@Component
public class EmbeddedServletContainerConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory>{
	@Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.setDocumentRoot(new File("src/main/resources/static/"));
    }
}
