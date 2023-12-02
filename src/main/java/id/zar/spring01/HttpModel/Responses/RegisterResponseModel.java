package id.zar.spring01.HttpModel.Responses;

import org.springframework.http.HttpStatus;

public class RegisterResponseModel {
    private HttpStatus status = HttpStatus.NOT_FOUND;
    private String msg;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
