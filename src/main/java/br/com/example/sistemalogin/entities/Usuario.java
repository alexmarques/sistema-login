package br.com.example.sistemalogin.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex on 22/06/17.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Length(min = 3)
    private String login;
    @NotBlank
    @Length(min = 3)
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
