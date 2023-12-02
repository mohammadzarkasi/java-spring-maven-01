package id.zar.spring01.controllers;

import id.zar.spring01.DbModel.AuthModel;
import id.zar.spring01.HttpModel.Request.LoginRequestModel;
import id.zar.spring01.HttpModel.Request.RegisterRequestModel;
import id.zar.spring01.HttpModel.Responses.LoginResponseModel;
import id.zar.spring01.HttpModel.Responses.RegisterResponseModel;
import id.zar.spring01.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private AuthService authService;
    public AuthController(AuthService authService)
    {
        this.authService=authService;
    }

    @PostMapping
    public LoginResponseModel cobaLogin(@RequestBody LoginRequestModel data)
    {
        var result = authService.findByUsername(data.getUsername());

        var response = new LoginResponseModel();

//        if(result == null)
//        {
//            response
//        }

//        if(result == null)
//        {
//            return new ResponseEntity<>()
//        }




        if(result != null)
        {

            if(result.getPassword().equals(data.getPassword()))
            {
                response.setInfo("data sesuai");
            }
            else
            {
                response.setInfo("password tidak cocok");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
//            response.setInfo(result.toString());
//            return "username->admin ditemukan::" + result;
        }
        else
        {
            response.setInfo("data tidak ditemukan");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
//        return "username->admin tidak ditemukan";

        return response;
    }

    @PostMapping(value = "register")
    public RegisterResponseModel register(@RequestBody RegisterRequestModel data)
    {
        var response = new RegisterResponseModel();

        if(data.getPassword() == null && data.getPassword().isEmpty()==true)
        {
            response.setMsg("password harus diisi");
            return response;
        }

        if((data.getEmail() == null || data.getEmail().isEmpty()==true) && (data.getUsername() == null || data.getUsername().isEmpty() == true))
        {
            response.setMsg("email atau username tidak boleh kosong");
            return response;
        }

        if(data.getEmail() != null && data.getEmail().isEmpty() == false)
        {
            var existByEmail = authService.findByEmail(data.getEmail());
            if(existByEmail != null)
            {
                response.setMsg("email sudah dipakai");
                return response;
            }
        }

        if(data.getUsername() != null && data.getUsername().isEmpty() == false)
        {
            var existByUsername = authService.findByUsername(data.getUsername());
            if(existByUsername!=null)
            {
                response.setMsg("username sudah dipakai");
                return response;
            }
        }


        var newUser = new AuthModel();
        newUser.setPassword(data.getPassword());
        newUser.setEmail(data.getEmail());
        newUser.setUsername(data.getUsername());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        authService.registerNewUser(newUser);

        response.setStatus(HttpStatus.OK);

        return response;
    }
}
