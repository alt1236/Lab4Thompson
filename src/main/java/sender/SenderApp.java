/**
 * Project: Lab 4 - Pizza Shop
 * Purpose Details: Demonstrates sending and receiving Pizza objects using
 * flat file format and JSON serialization via RabbitMQ.
 * Course: (IST 242)
 * Author: (Alyssa Thompson)
 * Date Developed: (3/28)
 * Last Date Changed: (3/30)
 * Rev: 2.0
 */


package sender;

import com.rabbitmq.client.*;
import model.Pizza;
import util.FlatFileUtil;
import util.JsonUtil;

/**
 * Sends Pizza data using RabbitMQ in both flat file and JSON formats.
 */

public class SenderApp {

    /**
     * Main method to send messages.
     *
     * @param args command line arguments
     * @throws Exception if connection fails
     */

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
