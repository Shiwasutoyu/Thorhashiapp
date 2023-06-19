package thorhashiapp.example.thorhashiapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thorhashiapp.example.thorhashiapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
