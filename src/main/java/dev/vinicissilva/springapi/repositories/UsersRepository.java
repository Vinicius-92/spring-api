package dev.vinicissilva.springapi.repositories;

import dev.vinicissilva.springapi.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
