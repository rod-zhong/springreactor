package rod.demo.reactor.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {

    public static void main(String[] args) {

        Mono.just("Hello").subscribe(System.out::println);


        Flux.range(0,10000).filter(x -> x<10).subscribe(x ->{
            System.out.println(x);
        });
    }
}
