package administrator;
import User.Passenger;

import java.io.Serializable;

public class Administrator extends Passenger implements Serializable {
    private String Username;
    private String Password;

    public Administrator() {
    }

    public Administrator(String fname, String lname, String u, String p) {
        super(fname, lname);
        this.Username=u;
        this.Password=p;
    }

    public Administrator(Administrator a) {
        super();
        this.Username=a.Username;
        this.Password=a.Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

