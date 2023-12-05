package com.example.bikeshop.controllers;

import com.example.bikeshop.models.User;
import com.example.bikeshop.sevices.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.security.Principal;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testLogin() {
        Principal principal = mock(Principal.class);
        Model model = mock(Model.class);

        when(userService.getUserByPrincipal(principal)).thenReturn(new User());

        String viewName = userController.login(principal, model, null);

        verify(model).addAttribute(eq("user"), any());
    }

    @Test
    void testLoginWithError() {
        Principal principal = mock(Principal.class);
        Model model = mock(Model.class);

        when(userService.getUserByPrincipal(principal)).thenReturn(new User());

        String viewName = userController.login(principal, model, "someError");

        verify(model).addAttribute(eq("user"), any());
        verify(model).addAttribute(eq("loginError"), eq("The username or password is not correct"));

    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        User updatedUser = new User();
        Model model = mock(Model.class);

        String viewName = userController.updateUser(userId, updatedUser, model);

        verify(userService).updateUser(updatedUser, userId);
        verify(model).addAttribute(eq("successMessage"), eq("User updated successfully"));
    }

    @Test
    void testRegistration() {
        String viewName = userController.registration();

    }

    @Test
    void testCreateUser() {

        User user = new User();
        Model model = mock(Model.class);

        when(userService.createUser(user)).thenReturn(true);

        String viewName = userController.createUser(user, model);

        verify(userService).createUser(user);
    }
}