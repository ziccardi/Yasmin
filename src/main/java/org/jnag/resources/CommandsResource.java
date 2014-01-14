package org.jnag.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jnag.api.Command;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/commands")
@Produces(MediaType.APPLICATION_JSON)
public class CommandsResource {
    
    private final String host;
    
    private final AtomicLong counter;
    
    public CommandsResource(String host) {
        this.host = host;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Command sayHello(@QueryParam("name") Optional<String> name) {
        return new Command(counter.incrementAndGet(),
                          String.format(host));
    }
    

}
