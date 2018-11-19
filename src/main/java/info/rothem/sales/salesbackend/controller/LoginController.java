package info.rothem.sales.salesbackend.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public Map<String, String> auth(@RequestParam String username, @RequestParam String password) {
        String usernameToken = "hello";
        String passwordToken = "there";

        Map<String, String> response = new LinkedHashMap<>();

        if(username.equals(usernameToken) && password.equals(passwordToken)) {
            response.put("Status", "1");
        } else {
            response.put("Status", "0");
        }

        return response;
    }
}