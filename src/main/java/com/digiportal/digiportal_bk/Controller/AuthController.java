package com.digiportal.digiportal_bk.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiportal.digiportal_bk.Security.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtUtil jwtUtil;

@PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
    String username=request.get("username");
    String password =request.get("password");
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    String token=jwtUtil.generateToken(username);
    return ResponseEntity.ok(Map.of("token",token));
}

}
