package com.example.tp2.service;

import com.example.tp2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        this.users.add(new User(1L, "Mohammed", "mhd@mail.com"));
        this.users.add(new User(2L, "Moad", "moad@mail.com"));
        this.users.add(new User(3L, "Sana", "sana@mail.com"));
        this.users.add(new User(4L, "Amina", "amina@mail.com"));
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUser(Long id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void updateUser(Long id, User user) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId().equals(id)) {
                user.setId(id);
                this.users.set(i, user);
                return;
            }
        }
    }

    public void suppUser(Long id) {
        this.users.removeIf(user -> user.getId().equals(id));
    }
}
