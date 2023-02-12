/**
 * CSC 112 Lab5 (Exceptionally Unique Inventory) Spring 2023
 * This program reads an inventory file and creates a database (list)
 * of ID numbers and counts. Statistics about the database and file contents
 * are then displayed. The maximum list size and file name are read
 * from the user.
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Feb. 11, 2023
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;


public class Inventory3 {
    public static void main(String[] args) {
        int maxListSize;       // physical (maximum) size of the database
        String inFileName;     // inventory file name
        String upFileName;     // update file name
        Scanner keyboard = new Scanner(System.in);
        Scanner inFile = null;
        Scanner upFile = null;

        // read listSize and inFileName from the user
        System.out.print("Enter database size, inventory file name, and update file name  -> ");
        maxListSize = keyboard.nextInt();
        inFileName = keyboard.next();
        upFileName = keyboard.next();

        inFile = openFileScanner(inFileName);
        upFile = openFileScanner(upFileName);

        var list = new ID[maxListSize];  // the database
        int size = 0;                     // database logical size

        // process
        System.out.println("processing: " + inFileName);
        size = readInventoryFile(inFile, list);
        System.out.println(Arrays.toString(Arrays.copyOf(list, size)));
        System.out.println("processing: " + upFileName);
        size = readUpdateFile(upFile, list, size);

        // print in ascending order the unique IDs stored in list
        Arrays.sort(list, 0, size);
        System.out.println(Arrays.toString(Arrays.copyOf(list, size)));
    }


    /**
     * Opens the file fileName and returns an associated scanner if
     * possible.
     *
     * @param fileName String is the file name
     * @return Scanner for the file if is can be opened
     */
    private static Scanner openFileScanner(String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) {
            System.out.println("Error in opening " + fileName);
            System.exit(0);
        }
        return fileScanner;

    }


    /**
     * Reads the contents of inFileName and stores the unique IDs in
     * list. Maintains statistics about the items read.
     *
     * @param inFileName String is the inventory file name
     * @param list int[] is the static list of unique IDs
     * @return size is int logical size of list
     */
    private static int readInventoryFile(Scanner inFile, ID[] list) {
        int size = 0;  // number of items stored in list (logical size)

        inFile.close();
        return size;
    }


    /**
     * Reads the contents of upFileName and stores the unique IDs in
     * list. Maintains statistics about the items read.
     *
     * @param upFileName String is the inventory file name
     * @param list int[] is the static list of unique IDs
     * @return size is int logical size of list
     */
    private static int readUpdateFile(Scanner upFile, ID[] list, int size) {

        upFile.close();
        return size;
    }

    // other code here, hear?
}


/**
 * Class stores an ID and its count
 */
class ID implements Comparable {
    int id;     // item ID value
    int count;  // count for the number of items

    /**
     * Null constructor
     */
    public ID() {  id = -1;  count = 0;  }


    /**
     * ID and count constructor
     */
    public ID(int id, int count) {  this.id = id;  this.count = count;  }


    /**
     * Getter and setter methods
     */
    public int getID() {  return id;  }
    public int getCount() {  return count;  }
    public void incrCount() {  count++;  }
    public void decrCount() {  count--;  }


    /**
     * Compares two ID objects based on ID values
     * required for Comparable interface
     * returns >0 if caller greater, < 0 is less, 0 if equal
     */
    public int compareTo(Object other) {
        if(!(other instanceof ID))
            throw new RuntimeException();
        return id - ((ID) other).getID();
    }


    /**
     * Returns String version of the ID object
     */
    public String toString() {
        return new String("you write this");
    }
}
