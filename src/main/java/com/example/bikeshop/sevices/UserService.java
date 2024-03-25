package com.example.bikeshop.sevices;

import com.example.bikeshop.models.AdditionalInformation;
import com.example.bikeshop.models.User;
import com.example.bikeshop.models.enums.Role;
import com.example.bikeshop.repositories.UserRepository;
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

    public boolean createUser(User user) {

        String email = user.getEmail();
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        AdditionalInformation additionalInformation = new AdditionalInformation();
        additionalInformation.setUser(user);
        user.setAdditionalInformation(additionalInformation);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

    @Transactional
    public void updateUser(AdditionalInformation newInformation, int id) {

        User userInDatabase = userRepository.findById(id).orElse(null);

        if (userInDatabase == null)
            return;

        AdditionalInformation additionalInformation = userInDatabase.getAdditionalInformation();

        if (!newInformation.getAddress().equals("")) {
            additionalInformation.setAddress(newInformation.getAddress());
            log.info("Update {} with Address: {}", userInDatabase.getEmail(), additionalInformation.getAddress());
        }

        if (!newInformation.getCity().equals("")) {
            additionalInformation.setCity(newInformation.getCity());
            log.info("Update {} with City: {}", userInDatabase.getEmail(), additionalInformation.getCity());
        }

        if (!newInformation.getCountry().equals("")) {
            additionalInformation.setCountry(newInformation.getCountry());
            log.info("Update {} with Country: {}", userInDatabase.getEmail(), additionalInformation.getCountry());
        }

        if (!newInformation.getPhoneNumber().equals("")) {
            additionalInformation.setPhoneNumber(newInformation.getPhoneNumber());
            log.info("Update {} with Phone Number: {}", userInDatabase.getEmail(), additionalInformation.getPhoneNumber());
        }

        userInDatabase.setAdditionalInformation(additionalInformation);
        userRepository.save(userInDatabase);
        log.info("User {} was updated", userInDatabase.getEmail());
    }

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
