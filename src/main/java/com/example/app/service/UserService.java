package com.example.app.service;

import com.example.app.dto.AuthenticationRequest;
import com.example.app.dto.AuthenticationResponse;
import com.example.app.dto.RegistrationRequest;
import com.example.app.exception.AuthenticationFailException;
import com.example.app.exception.TokenNotPresentException;
import com.example.app.exception.UserAlreadyPresentException;
import com.example.app.exception.UserNotFoundException;
import com.example.app.model.user.AuthenticationToken;
import com.example.app.model.user.Role;
import com.example.app.model.user.User;
import com.example.app.repository.RoleRepository;
import com.example.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login).get(); //TODO:
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
//    public User getUserByEmail(String userEmail){
//        return userRepository.findByEmail(userEmail).orElseThrow(() -> new UserNotFoundException("User not found"));
//    }
//
//    public boolean existsByEmail(String email){
//        return userRepository.findByEmail(email).isPresent();
//    }
//
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    public ResponseEntity<Object> signUp(RegistrationRequest request){
//
//        if(userRepository.findByEmail(request.getEmail()).isPresent()){
//            throw new UserAlreadyPresentException("user already exists");
//        }
//
//        String passwordToEncrypt = request.getPassword();
//        try{
//            passwordToEncrypt = hashPassword(request.getPassword());
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
//
//        User user = User.builder()
//                .email(request.getEmail())
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .password(passwordToEncrypt)
//                .build();
//
//        userRepository.save(user);
//
//        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
//        authenticationService.saveConfirmationToken(authenticationToken);
//
//        return ResponseEntity.ok("Successfully created user");
//    }
//
//    private String hashPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[] digest = md.digest();
//        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
//        return hash;
//    }
//
//    public AuthenticationResponse signIn(AuthenticationRequest authenticationRequest){
//        User user = getUserByEmail(authenticationRequest.getEmail());
//
//        try{
//            if (!user.getPassword().equals(hashPassword(authenticationRequest.getPassword()))){
//                throw new AuthenticationFailException("Wrong password");
//            }
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
//
//        AuthenticationToken authenticationToken = authenticationService.getToken(user);
//
//        if (Objects.isNull(authenticationToken)){
//            throw new TokenNotPresentException("Token not present");
//        }
//
//        return new AuthenticationResponse("success", authenticationToken.getToken());
//    }
}
