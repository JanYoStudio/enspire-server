package pw.janyo.enspire.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author kiva
 * @date 2017/12/30
 */
@Path("greetings")
public class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.ok("Hello World. This is Enspire Server.").build();
    }
}
