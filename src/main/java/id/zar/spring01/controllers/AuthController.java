package id.zar.spring01.controllers;

import id.zar.spring01.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private AuthService authService;
    public AuthController(AuthService authService)
    {
        this.authService=authService;
    }

    @GetMapping
    public String testController()
    {
//        return "ini adalah tes controller";
        var result = authService.loginByUsername("admin");
        if(result != null)
        {
            return "username->admin ditemukan::" + result;
        }
        return "username->admin tidak ditemukan";
    }


}
