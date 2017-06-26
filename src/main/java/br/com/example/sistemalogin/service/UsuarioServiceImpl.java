package br.com.example.sistemalogin.service;

import br.com.example.sistemalogin.entities.Usuario;
import br.com.example.sistemalogin.repository.UsuarioRepository;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by alex on 23/06/17.
 */
@Component("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario autenticar(Usuario usuario) {
        String encodedPassword = passwordEncoder.encodePassword(usuario.getSenha(), null);
        usuario = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), encodedPassword);
        return usuario;
    }
}
