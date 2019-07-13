package car_rental;
import tuc.ece.cs102.util.DatePeriod;
import java.util.Date;

public class Rental {
	
	private static int staticRentalId=100;
	private Customer customer;
	private Car car;
	private Date rentalDate, returnDate;
	private int rentalId,discount;
	private float fullPrice;
	private DatePeriod datePeriod= new DatePeriod(rentalDate,returnDate);
	//Constructor 
	public Rental( Customer customer, Car car, Date rentalDate, Date returnDate, int discount) {
		this.rentalDate=rentalDate;
		this.customer=customer;
		this.car=car;
		this.returnDate=returnDate;
		this.discount=discount;
		
		rentalId=staticRentalId;
		
		fullPrice=(datePeriod.toDays())*car.getPricePerDay();
		fullPrice-=(float)discount/100*fullPrice;
		System.out.println(fullPrice);
		staticRentalId++;

		
	}
	//Constructor for initialization
	public Rental(Customer customer, Car car, Date rentalDate, Date returnDate,float fullPrice) {
		this.rentalDate=rentalDate;
		this.customer=customer;
		this.car=car;
		this.returnDate=returnDate;
		this.fullPrice=fullPrice;
		rentalId=staticRentalId;
		staticRentalId++;
		
	}
	//Outputs information about rental type objects 
	public void printRentalInfo() {
		System.out.println("Rental Id: "+rentalId);
		System.out.println("Rental Date: "+rentalDate);
		System.out.println("Return Date: "+returnDate);
		System.out.println("Rental price: "+fullPrice);
		System.out.println("Rented By: "+customer.getName());
		System.out.println("Car Model: "+car.getCarModel());
		System.out.println("Car Id: "+car.getCarId());

		System.out.println();
		System.out.println();
				
	}
	
	//Getters/Setters
	public int getRentalId() {
		return rentalId;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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
	this.fullPrice=fullPrice;
}

public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}

public DatePeriod getDatePeriod() {
	return datePeriod;
}

public void setDatePeriod(DatePeriod datePeriod) {
	this.datePeriod = datePeriod;
}


}