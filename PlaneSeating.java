/*
Programmer:     Sara Sunny
Language:       Java
Purpose:        Application to create an airplane passenger list
URL:
Assignment:     Homework 9
Date:           12/11/20
Course:         Info-210
 */
package edu.iusb.cs;

/**
 *
 * @author slbru
 */
//import java.util.Arrays;
import java.util.Scanner;

public class HW9_MP {
    public static void main (String [] args) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    int row = 0; String response;
    int column = 0;
    char [][] seating = {{'-','-'},{'-','-'},{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}};
   
    do {
       display(seating);
       
       row = getRow(); //call method to obtain row from user
       column = getColumn(row); //call method to obtain seat from user
       
       while (seating[row][column] == 'X'){ //loop checks to see if seat is already reserved
           System.out.println("Seat taken, please enter again ");
           column = getColumn(row);
       } //breaks out if not reserved yet
       
       seating = assignSeat(seating, row, column); //calls method to reserve seat

       System.out.println("\nYour seat has been reserved ");
       display(seating); //new seating arrangement with new reservation added

       System.out.println("\nDo you want to continue? (Y/N)");
       response = input.next();

    } while ("Y".equals(response)); //loops on Y
} 
 
    //method to display seating arrangement 
public static void display(char[][] seating) {
    
    System.out.println("\t A \t B \t C \t D");
    for (int row = 0; row < seating.length; row++) {
        System.out.printf("%s%d\t", "Row ", row+1);
        for (int column = 0; column <seating[row].length; column++){
            System.out.printf(" %s\t", seating[row][column]);
        }
        System.out.println();
    }
}

    //method to manipulate array and return new array
public static char[][] assignSeat(char[][] seating, int row, int column){
    
    seating[row][column] = 'X'; //reassigns value to X

    return seating;   //returns updated array to main
}

    //method to obtain row choice from user and check for invalid inputs
public static Integer getRow() {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    int r = 0; int row = 0;
    System.out.println("\nEnter the row (1 to 5) ");
    while (input.hasNext()) {
        if (input.hasNextInt()) {
            r = input.nextInt();
            if (r <= 0 || r >= 6) {
                System.out.println("Invalid row, please enter again ");
            }
            else {
                switch (r) { //assigns row choice with array index
                    case 1:
                        row = 0;
                        break;
                    case 2:
                        row = 1;
                        break;
                    case 3:
                        row = 2;
                        break;
                    case 4:
                        row = 3;
                        break;
                    case 5:
                        row = 4;
                        break;  
                }
                break;
            }
        }
        else {
            System.out.println("Invalid row, please enter again ");
            input.next();
        }
    }
    return row; //returns row value to main
}

    //method to obtain the user seat choice and check for invalid inputs
public static Integer getColumn(int row){ 
    Scanner input = new Scanner (System.in); //scanner for user input
    int column = 0; boolean validSeat = false;
    
    while (validSeat == false){
        System.out.println("Enter the seat (A, B, C, or D) ");
        String seat = input.next();
        switch (seat) { //to convert seat letter to column number
            case "A":
                column = 0;
                validSeat = true;
                break;
            case "B":
                column = 1;
                validSeat = true;
                break;
            case "C":
                if (row < 2) { //ensures that user cannot select a row out of range for column
                    System.out.println("Invalid seat, please enter again ");
                    
                    break;
                }
                column = 2;
                validSeat = true;
                break;
            case "D":
                if (row < 2) {
                    System.out.println("Invalid seat, please enter again ");
                    
                    break;
                }
                column = 3;
                validSeat = true;
                break;
            default:
                System.out.println("Invalid seat, please enter again ");
                
                break;
        }
    } //loops on false - if user does not enter valid input or out of range input
    return column; //returns column to main
}
}

