package main.java.arduino;

import arduino.Arduino;

import java.util.Scanner;

public class Connector {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Arduino arduino = new Arduino("COM3", 9600);

        boolean connected = arduino.openConnection();
        System.out.println("Connection is " + connected);
        Thread.sleep(2000);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();

            switch (s) {
                case "on":
                    arduino.serialWrite('1');
                    break;
                case "off":
                    arduino.serialWrite('0');
                    break;
                case "exit":
                    arduino.serialWrite('0');
                    arduino.closeConnection();
                    scanner.close();
                    break;
                default:
                    System.out.println("Wrong command...");
            }
        }
    }
}
