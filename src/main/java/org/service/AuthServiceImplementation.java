package org.service;
import org.data.models.User;
import org.data.repository.UserRepository;
import org.dto.authservicedto.reponse.LogOutUserResponse;
import org.dto.authservicedto.reponse.LoginUserResponse;
import org.dto.authservicedto.reponse.RegisterUserResponse;
import org.dto.authservicedto.request.LogOutUserRequest;
import org.dto.authservicedto.request.LoginUserRequest;
import org.dto.authservicedto.request.RegisterUserRequest;
import org.exceptions.authServiceExceptions.IncorrectPasswordException;
import org.exceptions.authServiceExceptions.InvalidDataInputException;
import org.exceptions.authServiceExceptions.InvalidPasswordLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.util.Mapper;

@Service
public class AuthServiceImplementation implements AuthService{

    @Autowired
    private UserRepository repository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if(request.getName().isEmpty() == true || request.getEmail().isEmpty() == true || request.getPassword().isEmpty() == true){
            throw new InvalidDataInputException("ALl required field must not be left empty");
        }
        if(request.getPassword().length() < 8){
            throw new InvalidPasswordLength("password length must be greater than 8");
        }
        User user = Mapper.mapToUser(request);
        this.repository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        if(request.getEmail().isEmpty() == true || request.getPassword().isEmpty() == true){
            throw new InvalidDataInputException("ALl required field must not be left empty");
        }
        User user = repository.findByEmail(request.getEmail());
        if(user == null || !user.getPassword().equals(request.getPassword())){
            throw new IncorrectPasswordException("invalid credentials");
        }
        user.setLoggedIn(true);
        LoginUserResponse response = new LoginUserResponse();
        response.setEmail(request.getEmail());
        response.setLoggedIn(user.isLoggedIn());
        return response;
    }


    @Override
    public LogOutUserResponse logoutUser(LogOutUserRequest request) {
        if(request.getEmail().isEmpty() == true){
            throw new InvalidDataInputException("ALl required field must not be left empty");
        }
        User user = repository.findByEmail(request.getEmail());
        if(user == null){
            throw new IncorrectPasswordException("invalid credentials");
        }
        user.setLoggedIn(false);
        LogOutUserResponse response = new LogOutUserResponse();
        response.setMessage("Log out successful");
        return null;
    }
}
