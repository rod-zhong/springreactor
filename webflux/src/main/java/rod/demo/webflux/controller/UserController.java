package rod.demo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rod.demo.webflux.domain.User;
import rod.demo.webflux.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    Flux<User> findAllUser(){
        System.out.println("controller been called!");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    Mono<User> findUser(@PathVariable Integer id){
        return userService.findUser(id);
    }
}
