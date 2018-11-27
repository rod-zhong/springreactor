package rod.demo.reactor.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MyWebClientTest {
    public static void main(String[] args) throws Exception {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        webClient.get().uri("/api/users").accept(MediaType.APPLICATION_JSON).
                retrieve().bodyToFlux(MyUser.class).toStream(2)
                .filter(myUser -> myUser.getId().intValue() == 5 || myUser.getId().intValue() == 9)
                .forEach(s -> {
                    System.out.println("I found you =>"+s);
                });

        Mono<MyUser> myUserMono = webClient.get().uri("/api/users/{id}", 1).retrieve()
                .bodyToMono(MyUser.class);

        System.out.println("Mono example"+myUserMono.block());
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class MyUser{
    private Integer id;
    private String name;
}
