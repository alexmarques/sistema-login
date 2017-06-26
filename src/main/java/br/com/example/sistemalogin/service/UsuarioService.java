package br.com.example.sistemalogin.service;

import br.com.example.sistemalogin.entities.Usuario;

/**
 * Created by alex on 23/06/17.
 */
public interface UsuarioService {

    Usuario autenticar(Usuario usuario);
}
