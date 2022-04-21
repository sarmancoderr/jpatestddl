package es.sarman.jpatestddl.models;

import es.sarman.jpatestddl.DTO.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class UserEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Id
    @Column(length = 50)
    private String email;

    @Column
    private String password;

    public UserEntity () {}

    public UserEntity (UserDTO userDTO) {
        setName(userDTO.getName());
        setEmail(userDTO.getEmail());
        setSurname(userDTO.getSurname());
        setPassword(userDTO.getPassword());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
