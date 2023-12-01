package id.zar.spring01.repository;

import id.zar.spring01.DbModel.AuthModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<AuthModel, String> {
}
