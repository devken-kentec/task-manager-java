package br.com.kentec.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.taskmanager.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
