package pw.janyo.enspire.data;

import org.hibernate.validator.constraints.Length;
import pw.janyo.enspire.EnspireGlobals;

import javax.validation.constraints.NotNull;

/**
 * @author kiva
 * @date 2018/1/20
 */
public class Greeting extends EnspireData {
    @NotNull
    @Length(min = 1, max = EnspireGlobals.SIZE_GREETING_MESSAGE)
    public String message;
}
