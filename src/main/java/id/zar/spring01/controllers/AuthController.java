package id.zar.spring01.controllers;

import id.zar.spring01.HttpResponseModel.LoginResponseModel;
import id.zar.spring01.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private AuthService authService;
    public AuthController(AuthService authService)
    {
        this.authService=authService;
    }

    @GetMapping
    public LoginResponseModel cobaLogin()
    {
        var result = authService.loginByUsername("admin");

        if(result == null)
        {
            return null;
        }

//        if(result == null)
//        {
//            return new ResponseEntity<>()
//        }

        var response = new LoginResponseModel();


//        if(result != null)
//        {
            response.setInfo(result.toString());
//            return "username->admin ditemukan::" + result;
//        }
//        return "username->admin tidak ditemukan";

        return response;
    }


}
