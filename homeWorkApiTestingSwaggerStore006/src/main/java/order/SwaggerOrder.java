package order;

import java.util.Random;

public class SwaggerOrder {

    public Order dummyOrder() {
        Order order = new Order();
        order.setPetId(new Random().nextInt(100));
        order.setId(new Random().nextInt(100));
        order.setQuantity(new Random().nextInt(10));
        return order;
    }
}
