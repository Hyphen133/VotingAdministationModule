package app.web_controller;

import app.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import app.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/delete")
public class WebDeleteUserController {

    @Autowired
    UserRepository repository;

    public class SelectedUsers {
        List<String> usernames;

        public SelectedUsers() {
            usernames = new ArrayList<>();
        }

        public List<String> getUsernames() {
            return usernames;
        }

        public void setUsernames(List<String> usernames) {
            this.usernames = usernames;
        }
    }

    @GetMapping
    public String deleteUserForm(Model model) {

        model.addAttribute("users", repository.findAll());
        model.addAttribute("selectedUsers", new SelectedUsers());
        return "deleteUserForm";
    }

    @PostMapping
    public String deleteUserSubmit(@ModelAttribute("selectedUsers") @RequestBody SelectedUsers selectedUsers, BindingResult result, Model model) {
        for (String username : selectedUsers.usernames) {
            repository.deleteByUsername(username);
        }

        return "index";
    }


}
