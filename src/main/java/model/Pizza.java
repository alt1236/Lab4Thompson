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

package model;

/**
 * Represents a Pizza object.
 */

public class Pizza {
    /**
     * The size of the pizza.
     */
    private String size;
    /**
     * The type of the crust.
     */
    private String crust;
    /**
     * The type of the sauce.
     */
    private String sauce;
    /**
     * The toppings on the pizza.
     */
    private String toppings;
    /**
     * The price of the pizza.
     */
    private double price;

    /**
     * Constructor to initialize a Pizza object.
     *
     * @param size The size of the pizza
     * @param crust The crust type
     * @param sauce The sauce type
     * @param toppings The toppings
     * @param price The price
     */

    public Pizza(String size, String crust, String sauce, String toppings, double price) {
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
        this.price = price;
    }
    // Getters and Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings='" + toppings + '\'' +
                ", price=" + price +
                '}';
    }
}

