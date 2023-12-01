package id.zar.spring01.service;

import id.zar.spring01.DbModel.AuthModel;
import id.zar.spring01.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }
    public AuthModel loginByUsername(String username)
    {
        var result = authRepository.findAuthModelByUsername(username);
        if(result.isEmpty())
        {
            return null;
        }
        return result.get();
    }
    public void loginByEmail(String email)
    {
        authRepository.findAuthModelByEmail(email);
    }
}
