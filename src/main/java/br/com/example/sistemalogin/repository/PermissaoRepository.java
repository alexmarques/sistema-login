package br.com.example.sistemalogin.repository;

import br.com.example.sistemalogin.entities.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by alex on 25/06/17.
 */
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    Set<Permissao> findByLogin(String login);
}
