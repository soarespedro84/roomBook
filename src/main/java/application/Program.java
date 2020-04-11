/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import domainModels.Reservation;
import exceptions.DomainExceptions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room Number: ");
            int number = in.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(in.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(in.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter UPDATE date");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(in.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(in.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException e) {
            System.out.println("Invalid Date Format");
        } catch (DomainExceptions e) {
            System.out.println("Error in Reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected Error!!");
        } 

        in.close();
    }

}
