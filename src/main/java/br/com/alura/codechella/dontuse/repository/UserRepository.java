package br.com.alura.codechella.dontuse.repository;

import br.com.alura.codechella.dontuse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
