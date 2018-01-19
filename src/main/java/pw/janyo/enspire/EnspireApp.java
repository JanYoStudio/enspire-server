package pw.janyo.enspire;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

/**
 * @author kiva
 * @date 2017/12/30
 */
@ApplicationPath("/v1")
public class EnspireApp extends ResourceConfig {
    public EnspireApp() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);

        packages("pw.janyo.enspire.resource");
    }
}