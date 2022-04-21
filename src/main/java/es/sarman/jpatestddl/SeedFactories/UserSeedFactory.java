package es.sarman.jpatestddl.SeedFactories;

import es.sarman.jpatestddl.DTO.UserDTO;
import es.sarman.jpatestddl.models.UserEntity;
import es.sarman.jpatestddl.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Component
public class UserSeedFactory extends BaseSeedFactory<UserEntity, String, UsersRepository> {

    @Autowired
    public UserSeedFactory(UsersRepository usersRepository) {
        super(usersRepository);
    }

    public boolean customSeed () {
        System.out.println("Custom instances");
        Arrays.asList(
                new UserDTO("Raul", "Contreras", "sarmancoder@gmail.com", "alumno"),
                new UserDTO("Jaime", "Aguirre", "jaime@gmail.com", "alumno")
        ).forEach(u -> repository.save(new UserEntity(u)));
        return true;
    }

    public UserEntity makeEntityInstance () {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(faker.name().firstName());
        userEntity.setSurname(faker.name().lastName());
        userEntity.setEmail(faker.internet().emailAddress());
        userEntity.setPassword(new BCryptPasswordEncoder().encode("alumno"));
        return userEntity;
    }

}
