package tuc.ece.cs102.car_rental.model.rentals;

import java.util.Date;

import tuc.ece.cs102.car_rental.model.clients.Client;
import tuc.ece.cs102.car_rental.model.vehicles.Vehicle;
import tuc.ece.cs102.util.DatePeriod;

public class Rental {

	private static int  constant=0;
	private int rentalId=100;
	private Client client;
	private Vehicle vehicle;
	private Date rentalDate, returnDate;
	private float fullPrice;
	private DatePeriod datePeriod;
	public Rental(Client client, Vehicle vehicle, Date rentalDate, Date returnDate, float fullPrice) {

		this.client = client;
		this.vehicle = vehicle;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.fullPrice = fullPrice;
		datePeriod= new DatePeriod(rentalDate,returnDate);
		rentalId=(int)rentalId+constant;
		constant++;
		
	}
	public Rental(Client client, Vehicle vehicle, Date rentalDate, Date returnDate) {

		this.client = client;
		this.vehicle = vehicle;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		datePeriod= new DatePeriod(rentalDate,returnDate);
		fullPrice=vehicle.getPrice()*(datePeriod.toDays());
		fullPrice-=client.getDiscount()*fullPrice;
		rentalId=(int)rentalId+constant;
		constant++;
	}
	
	public DatePeriod getDatePeriod() {
		return datePeriod;
	}
	public void setDatePeriod(DatePeriod datePeriod) {
		this.datePeriod = datePeriod;
	}
	public int getStaticRentalId() {
		return rentalId;
	}
	public void setStaticRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public float getFullPrice() {
		return fullPrice;
	}
	public void setFullPrice(float fullPrice) {
		this.fullPrice = fullPrice;
	}
	
	public void print() {
		System.out.println("Rental Id: "+rentalId);
		if(client==null||vehicle==null) {
			System.out.println("Problem with Rental Class...");
			return;
		}
		System.out.println("Rented By: "+client.getName());
		System.out.println("Client's Afm: "+client.getAfm());
		System.out.println("Vehicle Model: "+vehicle.getVehicleModel());
		System.out.println("Vehicle Id: "+vehicle.getVehicleId());
		System.out.println("Full price of Rental: "+fullPrice);
		System.out.println("Discount: "+client.getDiscount()*100);
		System.out.println("Date of Rental: "+rentalDate);
		System.out.println("Return Date: "+ returnDate);
		System.out.println();
		System.out.println();
		
		
	}
}
