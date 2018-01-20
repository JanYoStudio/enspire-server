package pw.janyo.enspire.resource;

import pw.janyo.enspire.constraint.Username;
import pw.janyo.enspire.data.EnspireData;
import pw.janyo.enspire.data.Greeting;
import pw.janyo.enspire.tools.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author kiva
 * @date 2017/12/30
 */
@Path("greetings/{username}")
public class GreetingResource {
    @Username
    @PathParam("username")
    String username;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGreetingForUser() {
        Log.d("Greeting requested");

        Greeting greeting = EnspireData.create(Greeting.class);
        if (username != null) {
            greeting.message = "Hello " + username + ". ";
        }
        greeting.message += "This is Enspire Server.";
        return Response.ok(greeting.toJson()).build();
    }
}
