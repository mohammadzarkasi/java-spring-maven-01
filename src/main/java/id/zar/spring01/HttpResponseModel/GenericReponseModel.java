package id.zar.spring01.HttpResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericReponseModel {
    public ResponseEntity<GenericReponseModel> withStatusCode(HttpStatus status)
    {
        var result = new ResponseEntity<GenericReponseModel>(this, status);
        return result;
    }

    public ResponseEntity<GenericReponseModel> withStatusOk()
    {
        var result = new ResponseEntity<GenericReponseModel>(this, HttpStatus.OK);
        return result;
    }
}
