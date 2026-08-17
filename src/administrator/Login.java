package administrator;

import ars.Filing;

import java.io.Serializable;

public class Login implements Serializable {

    public Login() {
    }

    public boolean LoggingIn(Object t, String u, String p){
        if(Filing.readObjectFromFile(t, u, p)){
            return true;
        }
        return false;
    }
}

