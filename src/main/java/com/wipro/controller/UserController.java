package com.wipro.controller;

import com.wipro.config.UserServiceAspect;
import com.wipro.model.User;
import com.wipro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model) {
        List<User> allUsers = this.userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "user_list";
    }

    @PostMapping("/add/")
    public String addUser(@ModelAttribute User user){
        log.info("Details Received for creating user : {}" , user);
        this.userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id")  int id, Model model){
        User user = this.userService.getUserById(id);
        model.addAttribute("user",user);
        return "editUser";
    }

    @PostMapping("/update/")
    public String updateUser(@ModelAttribute User user){
        log.info("Details Received for updating user : {}" , user);
        this.userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id , Model model) {
        log.info("Id received for deleting user : {}" , id);
        this.userService.deleteUser(id);
        return "redirect:/users";
    }


}


