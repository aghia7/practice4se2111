package controllers;

import models.User;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository userRepo;

    public UserController(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public String getById(int id) {
        User user = userRepo.get(id);

        if (user == null)
            return "The user with id = " + id + " does not exist.";

        return user.toString();
    }

    public String getAll() {
        List<User> users = userRepo.getAll();
        if (users.isEmpty())
            return "Users list is empty!";

        String response = "";

        for (User user : users)
            response += user + "\n";

        return response;
    }

    public String create(String name, String surname) {
        User user = new User(name, surname);

        boolean created = userRepo.create(user);

        if (created)
            return "A new user " + name + " " + surname + " was created successfully!";

        return "User cannot be created!";
    }

    public String removeById(int id) {
        User user = userRepo.get(id);

        if (user == null)
            return "The user with id = " + id + " does not exist.";

        boolean removed = userRepo.delete(id);

        if (removed)
            return "User " + user.getName() + " " + user.getSurname() +
                    " was removed successfully!";

        return "User cannot be removed!";
    }
}
