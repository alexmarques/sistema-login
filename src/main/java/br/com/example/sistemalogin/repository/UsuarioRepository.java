package br.com.example.sistemalogin.repository;

import br.com.example.sistemalogin.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by alex on 23/06/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLoginAndSenha(String login, String senha);
    Optional<Usuario> findByLogin(String login);
}
