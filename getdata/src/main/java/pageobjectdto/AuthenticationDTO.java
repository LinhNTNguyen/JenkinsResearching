package pageobjectdto;

/**
 * Created by USER on 10/4/2017.
 */
public class AuthenticationDTO {
    private String emailAddress;
    private String email;
    private String password;
    private String lblAuthentication;

    public String getLblAuthentication() {
        return lblAuthentication;
    }

    public void setLblAuthentication(String lblAuthentication) {
        this.lblAuthentication = lblAuthentication;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
