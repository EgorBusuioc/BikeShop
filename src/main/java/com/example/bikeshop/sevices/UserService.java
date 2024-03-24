package com.example.bikeshop.sevices;

import com.example.bikeshop.models.User;
import com.example.bikeshop.models.enums.Role;
import com.example.bikeshop.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

//    @Transactional
//    public void updateUser(User updatedUser, Long id) {
//        User userInDatabase = userRepository.findById(id).orElse(null);
//
//        if (userInDatabase != null) {
//            if(!updatedUser.getAddress().equals("")){
//                userInDatabase.setAddress(updatedUser.getAddress());
//                log.info("Update {} with Adress: {}", userInDatabase.getEmail(), updatedUser.getAddress());
//            }
//
//            if(!updatedUser.getCity().equals("")){
//                userInDatabase.setCity(updatedUser.getCity());
//                log.info("Update {} with City: {}", userInDatabase.getEmail(), updatedUser.getCity());
//            }
//
//            if(!updatedUser.getCountry().equals("")){
//                userInDatabase.setCountry(updatedUser.getCountry());
//                log.info("Update {} with Country: {}", userInDatabase.getEmail(), updatedUser.getCountry());
//            }
//
//            if(!updatedUser.getPhoneNumber().equals("")){
//                userInDatabase.setPhoneNumber(updatedUser.getPhoneNumber());
//                log.info("Update {} with Phone Number: {}", userInDatabase.getEmail(), updatedUser.getPhoneNumber());
//            }
//
//            log.info("User {} was updated", userInDatabase.getEmail());
//            User mergedUser = entityManager.merge(userInDatabase);
//        }
//    }

    public List<User> list() {
        return userRepository.findAll();
    }

//    public void banUser(Long id) {
//        User user = userRepository.findById(id).orElse(null);
//        if (user != null) {
//            if (user.isActive()) {
//                user.setActive(false);
//                log.info("Ban user with id: {}; email: {}", user.getId(), user.getEmail());
//            } else {
//                user.setActive(true);
//                log.info("Unban user with id: {}; email: {}", user.getId(), user.getEmail());
//            }
//        }
//        userRepository.save(user);
//    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
