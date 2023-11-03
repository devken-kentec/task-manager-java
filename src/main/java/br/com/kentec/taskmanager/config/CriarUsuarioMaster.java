package br.com.kentec.taskmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kentec.taskmanager.domain.User;
import br.com.kentec.taskmanager.enuns.StatusEnum;
import br.com.kentec.taskmanager.repository.UserRepository;
//import org.springframework.context.annotation.Profile;


@Configuration
//@Profile("prod")
public class CriarUsuarioMaster {
	
	@Autowired
	private UserRepository ur;
	
	@Bean
	CommandLineRunner executar() {
		return args -> {
			long userQuant = ur.count();
			if(userQuant == 0) {
				User user = new User();
				user.setNome("Kennedy");
				user.setStatus(StatusEnum.ATIVO);
				user.setMatricula("1039092");
				user.setSenha("123");
				ur.save(user);
			
			}
		};
	}
}
