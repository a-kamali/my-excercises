package ir.maktab.util;

public class AuthHolder {
    public  Integer tokenId;
    public  String tokenName;

    public Integer getTokenId() {
        return tokenId;
    }

    public String getTokenName() {
        return tokenName;
    }


    public void reset() {
        tokenId = null;
        tokenName = null;
    }


}
