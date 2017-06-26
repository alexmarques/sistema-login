package br.com.example.sistemalogin;

import br.com.example.sistemalogin.entities.Permissao;
import br.com.example.sistemalogin.entities.Usuario;
import br.com.example.sistemalogin.repository.PermissaoRepository;
import br.com.example.sistemalogin.repository.UsuarioRepository;
import br.com.example.sistemalogin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by alex on 23/06/17.
 */
@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha inválido."));
        return new User(usuario.getLogin(), usuario.getSenha(), getPermissoes(login));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(String login) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Permissao> permissoes = permissaoRepository.findByLogin(login);
        permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getRole())));
        return authorities;
    }
}