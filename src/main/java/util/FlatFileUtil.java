package util;

import model.Pizza;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FlatFileUtil {
    /**
     * Convert Pizza object to delimited string
     */

    public static String toDelimitedString(Pizza pizza) {
        return pizza.getSize() + "," +
                pizza.getCrust() + "," +
                pizza.getSauce() + "," +
                pizza.getToppings() + "," +
                pizza.getPrice();
    }
    /**
     * Convert delimited string back to Pizza object
     */

    public static Pizza fromDelimitedString(String line) {

        String[] parts = line.split(",");

        if (parts.length == 5) {
            return new Pizza(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    Double.parseDouble(parts[4])
            );
        } else {
            throw new IllegalArgumentException("Invalid data: " + line);
        }

    }
}
