package pw.janyo.enspire;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import pw.janyo.enspire.tools.CrashHelper;
import pw.janyo.enspire.tools.Log;

import javax.ws.rs.ApplicationPath;

/**
 * @author kiva
 * @date 2017/1/20
 */
@ApplicationPath("/v1")
public class EnspireApp extends ResourceConfig {
    public EnspireApp() {
        initApplication();
        initServer();
    }

    private void initServer() {
        Log.d("Initializing server parameters");

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);

        packages("pw.janyo.enspire.resource");
    }

    private void initApplication() {
        Log.d("Initializing application");
        CrashHelper.getInstance().initCurrentThread();
    }
}
