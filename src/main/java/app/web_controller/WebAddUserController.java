package app.web_controller;

import app.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.domain.User;


@Controller
@RequestMapping("/user/add")
public class WebAddUserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String addUserForm(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "addUserForm";
    }

    @PostMapping()
    public String addUserSubmit(@ModelAttribute User user) {

        //Encrypt Password with 10 rounds of BCrypt
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);    //strength - num of rounds
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);

        return "index";
    }

}
