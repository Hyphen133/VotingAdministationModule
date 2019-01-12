package app.database;

import org.springframework.data.repository.CrudRepository;
import app.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
