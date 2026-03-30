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

package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pizza;

/**
 * Utility class for converting Pizza objects to and from JSON format.
 */

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converts a Pizza object into a JSON string.
     *
     * @param pizza The Pizza object
     * @return JSON string
     * @throws Exception if conversion fails
     */

    public static String toJson(Pizza pizza) throws Exception {
        return mapper.writeValueAsString(pizza);
    }

    /**
     * Converts a JSON string into a Pizza object.
     *
     * @param json JSON string
     * @return Pizza object
     * @throws Exception if conversion fails
     */

    public static Pizza fromJson(String json) throws Exception {
        return mapper.readValue(json, Pizza.class);
    }
}
