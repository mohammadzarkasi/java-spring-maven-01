package id.zar.spring01.HttpModel.Responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LoginResponseModel  {
    private String jwtToken;
    private String info;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private HttpStatus status = HttpStatus.OK;

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
