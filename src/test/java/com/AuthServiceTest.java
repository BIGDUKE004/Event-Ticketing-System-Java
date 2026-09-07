package com;

import com.data.repository.UserRepository;
import com.dto.authservicedto.reponse.LogOutUserResponse;
import com.dto.authservicedto.reponse.LoginUserResponse;
import com.dto.authservicedto.reponse.RegisterUserResponse;
import com.dto.authservicedto.request.LogOutUserRequest;
import com.dto.authservicedto.request.LoginUserRequest;
import com.dto.authservicedto.request.RegisterUserRequest;
import com.exceptions.authServiceExceptions.IncorrectPasswordException;
import com.exceptions.authServiceExceptions.InvalidDataInputException;
import com.service.AuthServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthServiceImplementation service;

    @BeforeEach
    public void clearAll(){
        this.service.deleteAll();
    }

    @Test
    public void testThatUserCreatesAnAccount(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("mirjsdunf");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());
    }

    @Test
    public void testThatUserCreatesAccountWithAEmptyEmail(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("");
        request.setName("miracle");
        request.setPassword("1234567890");

        assertThrows(InvalidDataInputException.class, () -> this.service.registerUser(request));
    }

    @Test
    public void testThatUserLogsInAfterCreatingAnAccount(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("elijah456");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("elijah456");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());
    }

    @Test
    public void testThatUserLogsInWithEmailThatDoesNotExist(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("elijah456");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("omor");
        loginUserRequest.setPassword("1234567890");

        assertThrows(IncorrectPasswordException.class, () -> this.service.loginUser(loginUserRequest));
    }

    @Test
    public void testThatUserLogsInIncorrectPassword(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("elijah456");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("elijah456");
        loginUserRequest.setPassword("omor");

        assertThrows(IncorrectPasswordException.class, () -> this.service.loginUser(loginUserRequest));
    }

    @Test
    public void testThatUserLogsInAfterCreatingAnAccountAndThenLogsOut(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("elijah456");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("elijah456");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setEmail("elijah456");

        LogOutUserResponse logOutUserResponse = this.service.logoutUser(logOutUserRequest);
        assertEquals("Log out successful", logOutUserResponse.getMessage());
    }

    @Test
    public void testThatUserLogsInAfterCreatingAnAccountAndThenLogsOutWithAnNonExistingEmail(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("elijah456");
        request.setName("miracle");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("miracle", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("elijah456");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setEmail("omor");

        assertThrows(IncorrectPasswordException.class, () -> this.service.logoutUser(logOutUserRequest));

    }
}
