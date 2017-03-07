package com.brainacademy.web.spring.db;

import com.brainacademy.web.spring.db.dao.UserDao;
import com.brainacademy.web.spring.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        User user = userDao.findOne(1);

        model.addAttribute("name", (user == null) ? "<none>" : user.getName());
        return "greeting";
    }

}