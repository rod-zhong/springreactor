package rod.demo.webflux.service;

import org.springframework.stereotype.Component;
import rod.demo.webflux.domain.Order;
import rod.demo.webflux.domain.User;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderService {
    private List<Order> store = new LinkedList<>();


    @PostConstruct
    public void init(){
        //TODO. upload codes
    }

    public List<Order> getOrderByUser(User user){
        List<Order> userOrders = store.stream().filter(order -> user.getId().equals(order.getOwner().getId())).collect(Collectors.toList());
        return userOrders;
    }
}
