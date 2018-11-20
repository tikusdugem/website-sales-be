package info.rothem.sales.salesbackend.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @CrossOrigin(origins = "http://localhost:7000")
    @RequestMapping("/login")
    public Map<String, String> auth(@RequestParam String username, @RequestParam String password) {
        final String usernameToken = "hello";
        final String passwordToken = "there";

        Map<String, String> data = new LinkedHashMap<>();
        
        if(username.equals(usernameToken) && password.equals(passwordToken)) data.put("Status", "1");
            else data.put("Status", "0");

        return data;
    }
}