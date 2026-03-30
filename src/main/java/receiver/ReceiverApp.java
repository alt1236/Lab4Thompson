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

package receiver;

import com.rabbitmq.client.*;
import model.Pizza;
import util.FlatFileUtil;
import util.JsonUtil;

/**
 * Receives Pizza data from RabbitMQ and converts it
 * from flat file and JSON back into Pizza objects.
 */

public class ReceiverApp {

    /**
     * Main method to receive messages.
     *
     * @param args command line arguments
     * @throws Exception if connection fails
     */

    private final static String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("Waiting for messages...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println("\nReceived: " + message);

            try {
                // 🔍 Detect JSON vs Flat File
                if (message.startsWith("{")) {
                    Pizza pizza = JsonUtil.fromJson(message);
                    System.out.println("JSON → Pizza: " + pizza);
                } else {
                    Pizza pizza = FlatFileUtil.fromDelimitedString(message);
                    System.out.println("Flat → Pizza: " + pizza);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
