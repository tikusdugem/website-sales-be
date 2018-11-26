package info.rothem.sales.salesbackend.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private DataSource datasource;

    @CrossOrigin(origins = "http://localhost:7000")
    @RequestMapping("/login")
    public Map<String, Integer> auth(@RequestParam String username, @RequestParam String password) {
        Map<String, Integer> data = new LinkedHashMap<>();

        try {
            Connection con = datasource.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username = ?");
                ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(password.equals(rs.getString("password"))) {
                    data.put("status", 1);
                } else {
                    data.put("status", 0);
                }
            } else {
                data.put("status", 0);
            }

            rs.close();
            ps.close();
            con.close();
        }catch(SQLException sqle) {
            sqle.printStackTrace();
        }

        return data; 
    }
}