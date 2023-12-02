package id.zar.spring01.HttpResponseModel;

import id.zar.spring01.DbModel.AuthModel;
import lombok.Data;

@Data
public class LoginResponseModel {
    private String jwtToken;
    private String info;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
