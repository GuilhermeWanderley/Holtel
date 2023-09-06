package Aplication;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Model.Entities.Reservation;
import Model.Exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try{
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.println("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), dtf);

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
		}
		
		catch(DomainException e) {
			System.out.println("Erro in reservation: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
