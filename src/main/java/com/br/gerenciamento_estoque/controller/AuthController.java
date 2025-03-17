package com.br.gerenciamento_estoque.controller;

import com.br.gerenciamento_estoque.dto.auth.AuthDTO;
import com.br.gerenciamento_estoque.model.Usuario;
import com.br.gerenciamento_estoque.repository.UsuarioRepository;
import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthDTO login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.login(), login.senha());
        var auth = this.manager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AuthDTO register) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(register.senha());
        Usuario novoUsuario = new Usuario(register.login(), encryptedPassword);

        if (repository.findByLogin(register.login()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            repository.save(novoUsuario);
        }
        return ResponseEntity.ok("Usuario salvo com sucesso!");

    }
}
