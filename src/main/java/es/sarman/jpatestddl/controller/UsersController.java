package es.sarman.jpatestddl.controller;

import es.sarman.jpatestddl.DTO.UserDTO;
import es.sarman.jpatestddl.SeedFactories.UserSeedFactory;
import es.sarman.jpatestddl.models.UserEntity;
import es.sarman.jpatestddl.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserSeedFactory userSeedFactory;

    @GetMapping
    public Page<UserEntity> findAllUsers (Pageable page) {
        return usersRepository.findAll(page);
    }

    @PostMapping
    public UserEntity createUser (@RequestBody UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        return (UserEntity) usersRepository.save(userEntity);
    }

    @PostMapping("/seed")
    public boolean seedUsersTable () {
        userSeedFactory.generateNInstances(20);
        return true;
    }

}
