package tuc.ece.cs102.car_rental.model.company;

import tuc.ece.cs102.list.*;
import tuc.ece.cs102.util.DatePeriod;
import tuc.ece.cs102.util.StandardInputRead;

import java.util.Date;


import tuc.ece.cs102.car_rental.items.*;
import tuc.ece.cs102.car_rental.model.clients.*;
import tuc.ece.cs102.car_rental.model.rentals.Rental;
import tuc.ece.cs102.car_rental.model.vehicles.*;
import tuc.ece.cs102.car_rental.model.vehicles.enums.BikeType;
import tuc.ece.cs102.car_rental.model.vehicles.enums.CarType;
import tuc.ece.cs102.car_rental.model.vehicles.enums.EnergyType;

public class Company {
	//String constants that are required for Class.forName(String className) functionality
	private final String packgVehicles="tuc.ece.cs102.car_rental.model.vehicles.";
	private final String packgClients="tuc.ece.cs102.car_rental.model.clients.";
	//local variables
	private String companyName;
	private String afm;
	private String location;
	//Lists
	private EnhancedSortedList vehiclesList=new EnhancedSortedList(),clientsList=new EnhancedSortedList(),rentalsList=new EnhancedSortedList();
	
	private StandardInputRead input = new StandardInputRead();
	
	
	//Company constructor
	public Company(String companyName,String afm, String location) {
		this.companyName=companyName;
		this.afm=afm;
		this.location=location;
	}
	
	
	//Private method used later in method newVehicle().It's purpose is to simplify its functionality and enhance its readability
	private void newTruck(String vehicleId) {
		//Truck initialization
		initializeTruck(vehicleId, input.readString("Please enter Truck's Model: "), input.readPositiveInt("Please enter Truck's year of release: "), 
				input.readPositiveFloat("Please enter Truck's total distance covered: "), input.readPositiveFloat("Please enter Truck's daily price: "), 
				input.readPositiveInt("Please enter Truck's max load: "), input.readPositiveFloat("Please enter Truck's width: "), 
				input.readPositiveFloat("Please enter Truck's height: "));
		System.out.println("The truck has been added.");
		System.out.println();
		System.out.println();
	}
	
	
	//Private method used later in method newVehicle().It's purpose is to simplify its functionality and enhance its readability
	private void newCar(String vehicleId) {
		
		EnergyType energy = null;
		System.out.println("*****************Choose the car's energy source*****************");
		System.out.println("1.Diesel");
		System.out.println("2.Gas");
		System.out.println("3.Battery");
		System.out.println("***********************************");
		System.out.println();
		System.out.println();
		switch(input.readString("Please choose an option either 1,2 or 3:")) {
			
			case "1":
				energy=EnergyType.DIESEL;
				break;
			case "2":
				energy=EnergyType.GAS;
				break;
			case"3":
				energy=EnergyType.BATTERY;
				break;
			default:
				System.out.println("Invalid option,returning to main menu...");
				System.out.println();
				System.out.println();
				return;
		}
				
				initializeCar(vehicleId, input.readString("Please enter Car's Model: "), input.readPositiveInt("Please enter Car's year of release: "), 
						input.readPositiveFloat("Please enter Car's total distance covered: "), input.readPositiveFloat("Please enter Car's daily price: "), 
						input.readPositiveInt("Please enter Car's max number of Passengers: "), input.readPositiveInt("Please enter Car's engine capacity(in cc): "),
						input.readPositiveInt("Please enter Car's number of doors: "), energy);
				System.out.println("The car has been added.");
				System.out.println();
				System.out.println();
				
		}
		
	
	
	private void newBike(String vehicleId) {
		BikeType type = null;
		System.out.println("*****************Choose the bike's type*****************");
		System.out.println("1.Touring");
		System.out.println("2.Cruiser");
		System.out.println("3.Sport");
		System.out.println("4.On/Off");
		System.out.println("***********************************");
		System.out.println();
		System.out.println();
		switch(input.readString("Please choose an option either 1,2 or 3:")) {
			
			case "1":
				type=BikeType.TOURING;
				break;
			case "2":
				type=BikeType.CRUISER;
				break;
			case"3":
				type=BikeType.SPORT;
				break;
			case "4":
				type=BikeType.ON_OFF;
			default:
				System.out.println("Invalid option,returning to main menu...");
				System.out.println();
				System.out.println();
				return;
		}
		int maxNumOfPassengers=input.readPositiveInt("Please enter bike's max amount of Passengers(under 3): ");
		if(maxNumOfPassengers>3||maxNumOfPassengers<=0){
			System.out.println("Invalid input , returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		
				initializeBike(vehicleId, input.readString("Please enter Bike's Model: "), input.readPositiveInt("Please enter Truck's year of release: "), 
						input.readPositiveFloat("Please enter Truck's total distance covered: "), 
						 input.readPositiveFloat("Please enter Truck's daily price: "),
						 maxNumOfPassengers, 
						 input.readPositiveInt("Please enter Truck's engine capacity(in cc): "), type);
				System.out.println("The bike has been added.");
				System.out.println();
				System.out.println();
	}
	
	private boolean checkIfPeriodsOverlap(DatePeriod datePeriod, Vehicle vehicle) {
		Rental tmp;
		rentalsList.resetIterationNode();
		for(int count=0;count<rentalsList.getLength();count++) {
			tmp=(Rental) rentalsList.getItemForIteration().getData();
			if(tmp.getDatePeriod().overlaps(datePeriod)&&tmp.getVehicle().equals(vehicle))
				return true;
		}
		return false;
	}
	
	private void searchAndPrintRentalsByString(String searchKey) {
		Rental tRental;
		rentalsList.resetIterationNode();
		for(int count=0;count<rentalsList.getLength();count++) {
			tRental=(Rental) rentalsList.getItemForIteration().getData();
			if(tRental.getVehicle().getVehicleId().equals(searchKey)||tRental.getClient().getAfm().equals(searchKey))
				tRental.print();
			
		}
	}
	
	private void searchAndPrintRentalsByDate(Date start,Date end) {
		Rental tRental;
		rentalsList.resetIterationNode();
		for(int count=0;count<rentalsList.getLength();count++) {
			tRental=(Rental) rentalsList.getItemForIteration().getData();
			if(((start.equals(tRental.getRentalDate()))||start.before(tRental.getRentalDate()))&&((end.equals(tRental.getReturnDate())||end.after(tRental.getReturnDate()))))
				tRental.print();	
		}
	}
	
	private Boolean checkForCarType(Vehicle vehicle,Client client) {
		try {
			if(Class.forName(packgClients+"Civilian").isInstance(client)&&Class.forName(packgVehicles+"Car").isInstance(vehicle)) {
				Car tCar=(Car) vehicle;
				CarType tCarType= CarType.DX;
				if(tCar.getCarType().equals(tCarType))
					return true;
				}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Problem with ckeckCarType method.");
			System.out.println();
			System.out.println();
		
		} 
		return false;
	}
	
	
	public void initializeCar(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price,
			int maxNumOfPassengers, int engineCapacity, int numOfDoors, EnergyType energy) {
		vehiclesList.insert(new VehicleItem(new Car(vehicleId,vehicleModel,yearOfRelease,distanceCovered,price,maxNumOfPassengers,engineCapacity,numOfDoors,energy)) );
	}
	
	public void initializeBike(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price,
			int maxNumOfPassengers, int engineCapacity, BikeType bikeType) {
		vehiclesList.insert(new VehicleItem(new Bike(vehicleId,vehicleModel,yearOfRelease,distanceCovered,price,maxNumOfPassengers,engineCapacity,bikeType)));
	}
	
	public void initializeTruck(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price, float maxLoad,
			float width, float height) {
		vehiclesList.insert(new VehicleItem(new Truck(vehicleId,vehicleModel,yearOfRelease,distanceCovered,price,maxLoad,width,height)));
	}
	
	public void initializeCivilian(String name, String afm, String cityOfResidence, String countryOfResidence, String phoneNumber) {
		clientsList.insert(new ClientItem(new Civilian(name, afm, cityOfResidence, countryOfResidence, phoneNumber)));
	}
	public void initializeBusiness(String name, String afm, String cityOfResidence, String countryOfResidence, String phoneNumber,float discount) {
		clientsList.insert(new ClientItem(new Business(name, afm, cityOfResidence, countryOfResidence, phoneNumber,discount)));
	}
	
	public void initializeRental(String Afm, String vehicleId, Date rentalDate, Date returnDate, float fullPrice) {
		Item tmp1=vehiclesList.search(vehicleId);
		Item tmp2=clientsList.search(Afm);
		if(tmp1==null ||tmp2==null) {
			System.out.println("Problem with initialization.");
			System.out.println();
			System.out.println();
			return;
		}
		rentalsList.insert(new RentalItem(new Rental((Client)tmp2.getData(),(Vehicle)tmp1.getData(),rentalDate,returnDate,fullPrice)));
		
	}
	
	
	public void searchandPrintVehicle() {
		Item tmp=vehiclesList.search(input.readString("Enter vehicleId: " ));
		if(tmp==null) {
			System.out.println("Vehicle not found,returning to main menu");
			System.out.println();
			System.out.println();
		}
			
		else
			tmp.print();
	}
	
	public void searchAndRemoveVehicle() {
		Item tmp=vehiclesList.search(input.readString("Enter vehicleId: "));
		if(tmp==null) {
			System.out.println("Vehicle not found,returning to main menu");
			System.out.println();
			System.out.println();
		}
			
		else
			vehiclesList.delete(tmp);
	
	}
	public void printAllVehicles() {
		vehiclesList.print();
	}
	public void searchAndPrintClients() {
		Item tmp=clientsList.search(input.readString("Enter client's afm: " ));
		if(tmp==null) {
			System.out.println("Client not found,returning to main menu");
			System.out.println();
			System.out.println();
		}
		else
			tmp.print();
	}
	
	public void searchAndRemoveClients() {
		Item tmp=clientsList.search(input.readString("Enter client's afm: "));
		if(tmp==null) {
			System.out.println("Client not found,returning to main menu");
			System.out.println();
			System.out.println();
			return;
		}
			
		clientsList.delete(tmp);
	}
	
	
	public void newRental(){
		Item tmp1=clientsList.search(input.readString("Enter customer's afm:"));
		
	
		if(tmp1==null){
			System.out.println("Afm not found , returning to main menu...");
			System.out.println();
			System.out.println();
	        return;
		}
		Client tClient=(Client)tmp1.getData();
		Item tmp2=vehiclesList.search(input.readString("Enter Vehicle's Id:"));
	
		if(tmp2==null) {
			System.out.println("Car Id not found , returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		Vehicle tVehicle=(Vehicle)tmp2.getData();
		DatePeriod datePeriod= new DatePeriod(input.readDate("Please enter the rental Date:"),input.readDate("Please enter the rental Date:"));
		if(checkIfPeriodsOverlap(datePeriod,tVehicle)) {
			System.out.println("The car has been already rented for these Dates, returning to main menu...");
			System.out.println();
			System.out.println();
	        return;
		}
		
		if(checkForCarType(tVehicle, tClient)) {
			System.out.println("Clients which are not registered as business clients cannot rent DX cars, returning to main menu...");
			System.out.println();
			System.out.println();
			
		}
		
		rentalsList.insert(new RentalItem(new Rental(tClient,tVehicle,datePeriod.getStart(),datePeriod.getEnd())));
		System.out.println("The Rental has been added to the System.");
		System.out.println();
		System.out.println();
		
	}
		
	public void searchVehiclesByClass(){
		String className=null;
		System.out.println("*****************Select category *****************");
		System.out.println("1.Vehicles");
		System.out.println("2.Passenger vehicles");
		System.out.println("3.Trucks");
		System.out.println("4.Cars");
		System.out.println("5.Bikes");
		System.out.println("***********************************");
		System.out.println();
		System.out.println();
		switch(input.readString("Please choose an option 1,2,3,4 or 5:")) {
			case "1":
				className="Vehicle";
				break;
			case "2":
				className="Passenger";
				break;
			case"3":
				className="Truck";
				break;
			case"4":
				className="Car";
				break;
			case"5":
				className="Bike";
				break;
			default:
				System.out.println("Invalid option,returning to main menu...");
				System.out.println();
				System.out.println();
				return;
		}
		vehiclesList.printItemsInHierarchy(className);
		System.out.println();
		System.out.println();
	}
	
	public void printRentals() {
		System.out.println("*****************Rentals*****************");
		System.out.println("a.Search and print by Vehicle Id");
		System.out.println("b.Search and print by Afm");
		System.out.println("c.Search and print by Date");
		System.out.println("***********************************");
		System.out.println();
		String option=input.readString("Please choose an option either a,b or c:");	
		switch(option) {
		case "a":
			//Searching based on the Car Id and then printing the rental
			searchAndPrintRentalsByString(input.readString("Please enter Vehicle's Id:"));
			break;
		case "b":
			//Searching based on the License Id and then printing the rental
			searchAndPrintRentalsByString(input.readString("Please enter Client's Id:"));
			break;
		case "c":
			//Searching based on a range of given dates
			 searchAndPrintRentalsByDate(input.readDate("Enter a start Date: "),input.readDate("Enter a return Date: "));
			break;
		default:
			System.out.println("Invalid option, option not found, returning to main menu...");
			System.out.println();
			System.out.println();
		}
	}
	
	public void newVehicle() {
		String vehicleId;
		System.out.println("*****************Enter a vehicle in the company fleet*****************");
		System.out.println("a.Truck");
		System.out.println("b.Car");
		System.out.println("c.Bike");
		System.out.println("***********************************");
		System.out.println();
		System.out.println();
		String option=input.readString("Please choose an option either a,b or c: ");
		if(!(option.equals("a")||option.equals("b")||option.equals("c"))){
			System.out.println("Invalid option returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		vehicleId=input.readString("Please enter Vehicle Id: ");
		if(vehiclesList.search(vehicleId)!=null) {
			System.out.println("That vehicle Id is taken, returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		switch(option) {
		case "a":
			newTruck(vehicleId);
			break;
		case "b":
			newCar(vehicleId);
			break;
		case "c":
			newBike(vehicleId);
			break;
		default:
		}
	}
	
	public void newClient() {
		String afm;
		System.out.println("*****************Enter a client in the company client list*****************");
		System.out.println("a.Regular client");
		System.out.println("b.Business client");
		System.out.println("***********************************");
		System.out.println();
		System.out.println();
		String option=input.readString("Please choose an option either a,b or c: ");
		if(!(option.equals("a")||option.equals("b")||option.equals("c"))){
			System.out.println("Invalid option returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		afm=input.readString("Please enter client afm: ");
		if(clientsList.search(afm)!=null) {
			System.out.println("There is already a client registered to the system with that afm, returning to main menu...");
			System.out.println();
			System.out.println();
			return;
		}
		switch(option) {
		case "a":
			initializeCivilian(input.readString("Please enter the client's name: "), afm, 
					input.readString("Please enter client's city of Residence: "), input.readString("Please enter client's country of Residence: "), 
					input.readString("Please enter client's phone Number: "));
			System.out.println();
			System.out.println();
			break;
		case "b":
			float discount=input.readPositiveFloat("Please enter a discount (if there is any) 0-100%: ");
			if(discount<0 || discount>100) {
				System.out.println("Invalid input, returning to main menu ...");
				System.out.println();
				System.out.println();
				return;
			}
				
			initializeBusiness(input.readString("Please enter the client's name: "), afm, 
					input.readString("Please enter client's city of Residence: "), input.readString("Please enter client's country of Residence: "), 
					input.readString("Please enter client's phone Number: "),discount);
			System.out.println();
			System.out.println();
		default:
		}
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
