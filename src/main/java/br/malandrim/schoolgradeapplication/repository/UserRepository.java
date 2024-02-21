package br.malandrim.schoolgradeapplication.repository;

import br.malandrim.schoolgradeapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
