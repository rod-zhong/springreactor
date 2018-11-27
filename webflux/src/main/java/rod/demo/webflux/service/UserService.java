package rod.demo.webflux.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rod.demo.webflux.domain.User;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserService {
    private List<User> userStore = new LinkedList<>();

    @PostConstruct
    public void init(){
        for ( int i = 0; i<=10;i++){
           userStore.add(User.builder().id(i).name("User:U00"+i).build());
        }
    }

    public Flux<User> getAll(){
        System.out.println("Service been called!");
        return Flux.fromStream(userStore.stream());
    }

    public Mono<User> findUser(Integer id){
        return Mono.just(
            userStore.stream().filter( i -> id.equals(i.getId())).findFirst().orElse(null)
        );

    }

}
