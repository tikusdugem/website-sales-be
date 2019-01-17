package info.rothem.sales.salesbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.rothem.sales.salesbackend.model.User;
import info.rothem.sales.salesbackend.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:7000")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/add")
    public String addNewUser(@RequestParam String name, @RequestParam String username, @RequestParam String password) {
        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
        
        return "Saved!";
    }

    @RequestMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/del")
    public String deleteUser(@RequestParam Integer id) {
        userRepository.deleteById(id);

        return "Deleted!";
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String username, @RequestParam String password) {
        User user = userRepository.findById(id).get();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);

        return "Updated";
    }
}