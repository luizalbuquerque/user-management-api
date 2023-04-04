package api.usermanagement.repository;

import api.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


//    @Query("select * from `user` u where u.email = email")
    UserEntity findByEmail(String email);

}