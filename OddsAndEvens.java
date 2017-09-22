import java.io.*;
import java.util.*;

public class OddsAndEvens {
    static String name;
    static String side;
    static Scanner kb = new Scanner(System.in);
    static int fingers;
    static int computerNum;

    public static void main(String[] args) {
        greetUser();
        playGame();
        determineWinner();
    }

    public static void greetUser(){
        System.out.println("Let's play a game called \"Odds and Evens\".");
        System.out.print("Enter your name: ");
        name = kb.next();

        System.out.println("Welcome, " + name + ".");
        System.out.print("Do you want to be odds or evens? Type O for odds or E for evens: ");
        side = kb.next();

        while(!side.equalsIgnoreCase("O") && !side.equalsIgnoreCase("E")){
            System.out.print("Please input O for odds or E for evens: ");
            side = kb.next();
        }
        if(side.equalsIgnoreCase("O"))
            System.out.println(name + " has picked odds! The computer will be evens.");
        else if (side.equalsIgnoreCase("E"))
            System.out.println(name + " has picked evens! The computer will be odds.");

        System.out.println("------------------------------------------------------------");
    }

    public static void playGame(){
        Random rand = new Random();

        if(side.equalsIgnoreCase("O")){
            System.out.print("How many " + "odd \"fingers\" do you put out? Choose a number between 0 and 5: ");
            fingers = kb.nextInt();

            while(fingers != 1 && fingers != 3 && fingers != 5) {
                System.out.print("Please input a number between 0 and 5: ");
                fingers = kb.nextInt();
            }
        }
        else if(side.equalsIgnoreCase("E")){
            System.out.print("How many " + "even \"fingers\" do you put out? Choose a number between 0 and 5: ");
            fingers = kb.nextInt();

            while(fingers != 0 && fingers != 2 && fingers != 4) {
                System.out.print("Please input a number between 0 and 5: ");
                fingers = kb.nextInt();
            }
        }
        computerNum = rand.nextInt(6);
        System.out.println("The computer plays " + computerNum + " fingers.");
        System.out.println("------------------------------------------------------------");
    }

    public static void determineWinner(){
        int sum = fingers + computerNum;
        boolean oddOrEven = sum%2 == 0;

        System.out.println(fingers + " + " + computerNum + " = " + sum);

        if(oddOrEven == true){
            System.out.println("The sum is even.");
            if(side.equalsIgnoreCase("E"))
                System.out.println(name + " wins!");
            else
                System.out.println("The computer wins.");
        }
        else{
            System.out.println("The sum is odd.");
            if(side.equalsIgnoreCase("O"))
                System.out.println(name + " wins!");
            else
                System.out.println("The computer wins.");
        }
        System.out.println("------------------------------------------------------------");
    }
}
