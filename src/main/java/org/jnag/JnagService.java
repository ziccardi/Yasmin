package org.jnag;

import org.jnag.health.TemplateHealthCheck;
import org.jnag.resources.CommandsResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class JnagService extends Service<JnagConfiguration> {
    
    @Override
    public void initialize(Bootstrap<JnagConfiguration> bootstrap) {
        bootstrap.setName("jnag");
        
        // add static resources
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));         
        bootstrap.addBundle(new AssetsBundle("/public", "/public/"));
        bootstrap.addBundle(new AssetsBundle("/META-INF/resources/webjars", "/webjars"));
    }

    @Override
    public void run(JnagConfiguration configuration,
                    Environment environment) {
        final String host = configuration.getHost();
        
        environment.addResource(new CommandsResource(host));
        
//        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

    public static void main(String[] args) throws Exception {
        new JnagService().run(args);
    }

}