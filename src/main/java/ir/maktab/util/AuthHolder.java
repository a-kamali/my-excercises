package ir.maktab.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthHolder {

    private static AuthHolder instance;
    private Integer tokenId;
    private String tokenName;

    private AuthHolder() {
    }

    public static synchronized AuthHolder getInstance() {
        if (instance == null) {
            instance = new AuthHolder();
        }
        return instance;
    }



    public void reset() {
        tokenId = null;
        tokenName = null;
    }
}


