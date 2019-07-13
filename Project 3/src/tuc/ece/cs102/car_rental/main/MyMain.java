package tuc.ece.cs102.car_rental.main;

import tuc.ece.cs102.car_rental.model.company.*;
import tuc.ece.cs102.car_rental.model.vehicles.enums.BikeType;
import tuc.ece.cs102.car_rental.model.vehicles.enums.EnergyType;
import tuc.ece.cs102.util.StandardInputRead;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class MyMain {

	public static void main(String[] args) throws ParseException{
		Company carRental= new Company("tui","2018030004","Chania");
		//Class used to initialize the Dates of rental objects
		SimpleDateFormat formater= new SimpleDateFormat("dd/MM/yyyy");
		Boolean exit=false;
		StandardInputRead input = new StandardInputRead();
		String option;
		//Vehicle Initializations
		carRental.initializeCar("XNK5544", "Mercedes C200", 2012, 120000, 50, 5, 1800, 4, EnergyType.BATTERY);
		carRental.initializeCar("XNA1204", "Honda Pilot", 2019, 5000, 70, 7, 3000, 5, EnergyType.DIESEL);
		carRental.initializeCar("XNM1345", "Mercendes MiniBXS", 2018, 6000, 100, 12, 3000, 4, EnergyType.DIESEL);
		carRental.initializeBike("XNO1706", "Yamaha YZF-R3", 2015, 60500, 45, 2, 600, BikeType.TOURING);
		carRental.initializeBike("XNX9901", "Kawasaki Ninja 300", 2012, 32000, 30, 2, 300, BikeType.CRUISER);
		carRental.initializeTruck("XNA1207", "Volvo FH16", 2017, 90000, 250, 20000, 3, 4);
		carRental.initializeTruck("XNA1208", "Scania XD1", 2018, 80000, 300, 25000, 3, 3);
		//Client Initializations
		carRental.initializeCivilian("Nikos Arabatzis", "123456789", "Chania", "Greece", "3028210373");
		carRental.initializeCivilian("Johanes Stevenson", "987654321", "Stockholm", "Sweden", "3536975589");
		carRental.initializeBusiness("Nick Malone", "741258963", "Dublin", "Ireland", "3536975589",(float) 0.1);
		carRental.initializeBusiness("Tim Roberg", "258963147", "Brussels", "Belgium", "3265738648",(float) 0.2);
		//Rental Initializations
		carRental.initializeRental("123456789", "XNK5544", formater.parse("03/04/2019"), formater.parse("22/04/2019"), 950);
		carRental.initializeRental("987654321", "XNA1204", formater.parse("05/04/2019"), formater.parse("08/04/2019"), 210);
		carRental.initializeRental("741258963", "XNO1706", formater.parse("05/06/2019"),formater.parse("15/06/2019"), 405);
		carRental.initializeRental("258963147", "XNX9901", formater.parse("05/06/2019"), formater.parse("15/06/2019"), 240);
		carRental.initializeRental("123456789", "XNA1207", formater.parse("05/06/2019"), formater.parse("14/06/2019"), 2250);
		carRental.initializeRental("987654321", "XNA1208", formater.parse("07/06/2019"), formater.parse("15/06/2019"), 2400);
		carRental.initializeRental("741258963", "XNK5544", formater.parse("05/06/2019"), formater.parse("15/06/2019"), 450);
		carRental.initializeRental("258963147", "XNM1345", formater.parse("05/08/2019"), formater.parse("15/08/2019"), 800);
		
		System.out.println("Car Rental Management System. Please choose 1 of the following options: ");
		//Main menu
		do {
			System.out.println("*****************Main Menu*****************");
			System.out.println("1.Search vehicle by vehicleId.");
			System.out.println("2.Remove vehicle by vehicleId.");
			System.out.println("3.Print all vehicles");
			System.out.println("4.Print vehicles by vehicle category");
			System.out.println("5.Search client by afm.");
			System.out.println("6.Remove client by afm.");
			System.out.println("7.Enter a new Rental.");
			System.out.println("8.Print rentals.");
			System.out.println("9.New vehicle.");
			System.out.println("10.New client.");
			System.out.println("11.Exit Program.");
			System.out.println("***********************************");
			System.out.println();
			System.out.println();
			System.out.println();
			option=input.readString("Please enter an option:");
			switch(option) {
				case "1":
					carRental.searchandPrintVehicle();
					break;
				case "2":
					carRental.searchAndRemoveVehicle();
					break;
				case "3":
					carRental.printAllVehicles();
					break;
				case "4":
					carRental.searchVehiclesByClass();
					break;
				case "5":
					carRental.searchAndPrintClients();
					break;
				case"6":
					carRental.searchAndRemoveClients();
					break;
				case"7":
					carRental.newRental();
					break;
				case"8":
					carRental.printRentals();
					break;
				case"9":
					carRental.newVehicle();
					break;
				case"10":
					carRental.newClient();
					break;
				case "11":
					System.out.println("Exiting Program....");
					//boolean variable used as a flag to exit the program
					exit=true;
					break;
				default:
					System.out.println("Invalid option.");
					System.out.println();
					System.out.println();
			}
		}
		while(exit==false);
	}
	

		
		
		
		
		
		
		
		
		
	

}

