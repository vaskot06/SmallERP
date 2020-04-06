package app.service;

import app.domain.models.service.UserServiceModel;
public interface UserService {

    void save(UserServiceModel user);

    UserServiceModel findByFirstName(String firstName);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}