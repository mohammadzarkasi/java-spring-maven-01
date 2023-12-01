package id.zar.spring01.repository;

import id.zar.spring01.DbModel.AuthModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthRepository extends MongoRepository<AuthModel, String> {
    Optional<AuthModel> findAuthModelByEmail(String email);
    Optional<AuthModel> findAuthModelByUsername(String username);
}
