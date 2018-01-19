package pw.janyo.enspire.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author kiva
 * @date 2017/12/30
 */
public class GsonHelper {
    public static Gson newGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");     // ISO 8601
        return gsonBuilder.create();
    }
}
