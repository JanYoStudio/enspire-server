package pw.janyo.enspire.data;


import pw.janyo.enspire.exception.EnspireDataException;
import pw.janyo.enspire.utils.GsonHelper;

/**
 * @author kiva
 * @date 2017/12/30
 */
public class EnspireData {
    public String toJson() {
        return GsonHelper.newGson().toJson(this);
    }

    public static <T extends EnspireData> T create(Class<T> clazz) throws EnspireDataException {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new EnspireDataException(e);
        }
    }
}
