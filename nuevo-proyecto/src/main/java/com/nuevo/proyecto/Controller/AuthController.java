package com.nuevo.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private ProductoService productoService;


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        userService.register(registerDto);

        return new ResponseEntity<>("User register success!", HttpStatus.CREATED);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToke(Authentication authentication){

        String token = jwtGenerator.refreshToken(authentication);

        JwtResponseDto jwtRefresh = new JwtResponseDto(token);
        return new ResponseEntity<JwtResponseDto>(jwtRefresh, HttpStatus.OK);
    }

    @GetMapping("/logued")
    public ResponseEntity<UserDto> getLoguedUser(@RequestHeader HttpHeaders headers){
        return new ResponseEntity<>(userService.getLoguedUser(headers), HttpStatus.OK);
    }

    @GetMapping("/home")
    public List<Producto>getAllProductos(){
        return productoService.getAllProductos();
    }
}
