package pw.janyo.enspire.data;


import pw.janyo.enspire.utils.GsonHelper;

/**
 * @author kiva
 * @date 2017/12/30
 */
public class EnspireData {
    public String toJson() {
        return GsonHelper.newGson().toJson(this);
    }
}
