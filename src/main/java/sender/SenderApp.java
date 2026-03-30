package sender;

import com.rabbitmq.client.*;
import model.Pizza;
import util.FlatFileUtil;
import util.JsonUtil;

public class SenderApp {

    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            Pizza pizza = new Pizza("Large", "Thin", "Tomato", "Pepperoni", 12.99);

            // 🔹 FLAT FILE
            String flat = FlatFileUtil.toDelimitedString(pizza);
            channel.basicPublish("", QUEUE_NAME, null, flat.getBytes());
            System.out.println("Sent Flat: " + flat);

            // 🔹 JSON
            String json = JsonUtil.toJson(pizza);
            channel.basicPublish("", QUEUE_NAME, null, json.getBytes());
            System.out.println("Sent JSON: " + json);
        }
    }
}
