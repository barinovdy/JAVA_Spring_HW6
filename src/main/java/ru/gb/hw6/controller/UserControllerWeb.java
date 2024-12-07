package ru.gb.hw6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw6.model.User;
import ru.gb.hw6.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/users")
@Profile("web")
public class UserControllerWeb {
    private final UserService userService;

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("user-update/{id}")
    public String createUpdateForm(User user){
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }






/*
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user;
        try {
            user = userService.getUserById(id);
        } catch (RuntimeException e){
            //return ResponseEntity.badRequest().build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public String createUser(User user, Model model){
        model.addAttribute("user-create", userService.createUser(user));
        return "user-create";
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

 */
}
