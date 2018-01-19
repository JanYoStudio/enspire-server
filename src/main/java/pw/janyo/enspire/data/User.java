package pw.janyo.enspire.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import pw.janyo.enspire.constraint.Username;

import javax.validation.constraints.NotNull;

/**
 * @author kiva
 * @date 2017/12/30
 */
public class User extends EnspireData {
    @NotNull @Username
    public String username;

    @NotNull
    @Length(min = 1, max = 128)
    public String password;

    @NotNull @Length(min = 1, max = 12)
    public String name;

    @NotNull @Length(min = 1, max = 64)
    @Email(regexp = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
    public String email;

    @NotNull @Length(min = 1, max = 512)
    public String description;
}
