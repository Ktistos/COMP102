package main;
import tuc.ece.cs102.util.StandardInputRead;

import car_rental.CarRental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Main {

public static void main(String args[]) throws ParseException {
		
	String option;
	boolean exit=false;
 StandardInputRead input = new StandardInputRead();
 //Class used to initialize the Dates of rental objects
 SimpleDateFormat formater= new SimpleDateFormat("dd/MM/yyyy");
	CarRental rentAcar= new CarRental("tui","2018030004", "cHaNiA");
	//Initializations
	rentAcar.initializeCar("XNK5544", "Ford Fiesta", 2012, 120000, 33, (float) 6.4, "air-condition","diesel",null);
	rentAcar.initializeCar("XNA1204", "Opel Corsa", 2015, 80000, 45, (float) 4.7, "air-condition","diesel","leather-seats");
	rentAcar.initializeCar("XNO1706", "Νissan Micra", 2015, 60500, 45, (float) 5.0, "diesel","cabriolet","leather-seats");
	rentAcar.initializeCar("XNX9901", "Lancia Ypsilon", 2012, 32000, 30, (float) 3.5, "air-condition","diesel","automatic");
	rentAcar.initializeCar("XNA1207", "Τoyota Yaris", 2017, 17000, 50, (float) 2.7, "air-condition","hybrid","automatic");
	rentAcar.initializeCar("XNA1208", "Νissan Qashqai", 2015, 80000, 60, (float) 6.8, "seven-seats","diesel","4-by-4");
	rentAcar.initializeCar("XNA1209", "Ford Mustang", 2015, 80000, 45, (float) 4.7, "air-condition","automatic","leather-seats");
	rentAcar.initializeCar("XNH1210", "Opel Corsa", 2018, 500, 80, (float) 3.6, "automatic","air-condition","leather-seats");
	rentAcar.initializeCar("HKZ1211", "Τoyota aygo", 2018,6000, 45, (float) 3.2, "air-condition","diesel","automatic");
	rentAcar.initializeCar("MHO1212", "Audi A3", 2015,33000, 58, (float) 6.1, "air-condition","automatic","leather");
	rentAcar.initializeCustomer("Nikos Arabatzis", "RPS442", "Greece", 3);
	rentAcar.initializeCustomer("Johanes Stevenson", "RFF839", "Sweden", 12);
	rentAcar.initializeCustomer("Katerina Mpampinioti", "HK6689", "Greece", 2);
	rentAcar.initializeCustomer("Marilena Karopoulou", "PK0967", "Greece", 5);
	rentAcar.initializeCustomer("Nick Malone", "JFK8FR", "Ireland", 14);
	rentAcar.initializeCustomer("Tim Roberg", "HJK31F", "Belgium", 9);
	rentAcar.initializeCustomer("Mario Marcelano", "ITF934", "Italy", 6);
	rentAcar.initializeCustomer("Mantalena Paliarini", "ITJ798", "Italy", 3);
	rentAcar.initializeCustomer("Mario Marcelano", "ITJ798", "Italy", 3);
	rentAcar.initializeCustomer("Klaus Regling", "DEF987", "Germany", 18);
	rentAcar.initializeCustomer("Manousos Manousaki", "GR0912", "Greece", 20);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("RPS442"), rentAcar.searchCar("XNX9901"),  formater.parse("03/04/2019"),formater.parse("22/04/2019"), (float) 570.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("RFF839"), rentAcar.searchCar("XNA1207"), formater.parse("05/04/2019"),formater.parse("08/04/2019"), (float) 150.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("HK6689"), rentAcar.searchCar("XNA1208"), formater.parse("05/06/2019"),formater.parse("15/06/2019"), (float) 600.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("PK0967"), rentAcar.searchCar("XNA1209"), formater.parse("05/06/2019"),formater.parse("15/06/2019"), (float) 450.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("JFK8FR"), rentAcar.searchCar("XNH1210"), formater.parse("05/06/2019"),formater.parse("14/06/2019"), (float) 720.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("HJK31F"), rentAcar.searchCar("HKZ1211"), formater.parse("07/06/2019"),formater.parse("15/06/2019"), (float) 360.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("ITF934"), rentAcar.searchCar("MHO1212"), formater.parse("05/06/2019"),formater.parse("15/06/2019"), (float) 464.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("RPS442"), rentAcar.searchCar("XNX9901"), formater.parse("03/05/2019"),formater.parse("19/05/2019"), (float) 448.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("PK0967"), rentAcar.searchCar("XNA1207"), formater.parse("07/07/2019"),formater.parse("12/07/2019"), (float) 250.00);
	rentAcar.initializeRental(rentAcar.searchCustomerToInitialize("PK0967"), rentAcar.searchCar("XNX9901"), formater.parse("07/06/2019"),formater.parse("15/06/2019"), (float) 336.00);
	
	
	//Main menu
	System.out.println("Car Rental Management System. Please choose 1 of the following options: ");
	
		do {
			System.out.println("*****************Main Menu*****************");
			System.out.println("1.Enter a new Car.");
			System.out.println("2.Print available Cars.");
			System.out.println("3.Enter a new Customer.");
			System.out.println("4.Make a new rental.");
			System.out.println("5.Print Rentals.");
			System.out.println("6.Exit Program.");
			System.out.println("***********************************");
			System.out.println();
			option=input.readString("Please enter an option:");
			switch(option) {
				case "1":
					rentAcar.newCar();
					break;
				case "2":
					rentAcar.printCars();
					break;
				case "3":
					rentAcar.newCustomer();
					break;
				case "4":
					rentAcar.newRental();
					break;
				case "5":
					rentAcar.printRentals();
					break;
				case "6":
					System.out.println("Exiting Program....");
					//boolen variable used as a flag to exit the program
					exit=true;
					break;
				default:
					System.out.println("Invalid option.");
			}
		}
		while(exit==false);
	}
	
}
