package com.francomartin.find_your_guide.service;


import com.francomartin.find_your_guide.auth.AuthenticationResponse;
import com.francomartin.find_your_guide.config.JwtService;
import com.francomartin.find_your_guide.dtos.UsuarioDTO;
import com.francomartin.find_your_guide.models.Usuario;
import com.francomartin.find_your_guide.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UsuarioRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(UsuarioDTO request) {

                var user = Usuario.builder()
                        .nombre(request.getNombre())
                        .apellido(request.getApellido())
                        .dni(request.getDni())
                        .sexo(request.getSexo())
                        .email(request.getEmail())
                        .telefono(request.getTelefono())
                        .fotoperfil(request.getFotoperfil())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .tipo(request.getTipo())
                        .build();
                repository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build();
        }
        /*

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                var user = repository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build();
        }

         */
}
