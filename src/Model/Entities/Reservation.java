package Model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Exception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException ("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getDayOfYear() - checkIn.getDayOfYear();
		return diff;
	}

	public void updateDates(LocalDate checkIn, LocalDate chechOut) throws DomainException {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new  DomainException ("Reservation dates for update must be future dates");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException ("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String toString() {
		return "Room " 
				+ +roomNumber 
				+ ", check-in " 
				+ dtf.format(checkIn) 
				+ ", check-out " 
				+ dtf.format(checkOut)		
				+ ", " + duration() 
				+ " nights";
	}
}
