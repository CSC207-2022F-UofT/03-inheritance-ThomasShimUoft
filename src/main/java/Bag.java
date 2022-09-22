/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /**
     * Constructs a bag object.
     *
     * @param color    The color of the bag
     * @param capacity The capacity of the bag
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[capacity];
    }


    /**
     * Returns the capacity of this bag.
     *
     * @return The capacity of this bag.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the color of this bag.
     *
     * @return The color of this bag.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the number of contents of this bag.
     *
     * @return The number of contents of this bag.
     */
    public int getNumberOfContents() {
        return numberOfContents;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Adds an item to the array, contents if there is space.
     *
     * @param item Item to add in the bag.
     * @return Whether item was successfully added.
     */
    public Boolean addItem(String item) {
        if (numberOfContents < capacity) {
            contents[numberOfContents] = item;
            numberOfContents += 1;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Return and remove the last item in the bag.
     *
     * @return The last item of the bag. If bag is empty return null.
     */
    public String popItem() {
        if (numberOfContents == 0) {
            return null;
        } else {
            String temp = contents[numberOfContents - 1];
            contents[numberOfContents - 1] = null;
            numberOfContents -= 1;

            return temp;
        }
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        capacity += n;
        String[] newContents = new String[contents.length + n];

        for (int i = 0; i < contents.length; i += 1) {
            newContents[i] = contents[i];
        }
        contents = newContents;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return String of bag details.
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}