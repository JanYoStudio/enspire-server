package pw.janyo.enspire.resource;

import pw.janyo.enspire.constraint.Username;
import pw.janyo.enspire.data.User;
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
@Path("users/{username}")
public class UserResource {
    @Username
    @PathParam("username") String username;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        Log.d("User profile requested");

        User user = new User();
        user.name = username;
        user.username = username;
        user.description = "An Android Developer!";
        user.email = "libkernelpanic@gmail.com";
        user.password = "123456";
        return Response.ok(user.toJson())
                .build();
    }
}
