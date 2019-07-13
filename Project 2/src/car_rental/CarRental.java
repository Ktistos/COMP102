package car_rental;

import java.util.Date;
import java.util.Vector;
import tuc.ece.cs102.util.StandardInputRead;
public class CarRental {
	private String name;
	private String afm;
	private String base;
	private Car[] cars=new Car[50];
	private Customer[] customers=new Customer[100];
	private Rental[] rentals= new Rental[100];
	private static int numOfCars,numOfCustomers,numOfRentals;
	private StandardInputRead input = new StandardInputRead();
	
	//Constructor
	public CarRental(String name,String afm, String base) {
		this.name=name;
		this.afm=afm;
		this.base=base;
		
	}
	//Private methods (for later use in the class)
	
	//Method used to return a String array which includes car features that the user has selected.It also prints a menu of all the available car features and then takes input for the user.

	private String[] insertFeatures() {
		
		String[] availableFeatures= {"4-by-4","diesel","hybrid","automatic","cabriolet","7-seat","air-condition","leather-seats"};
		String[] tmpFeatures= new String[3];
		String option;
		int numOfFeatures;
		do {
			numOfFeatures=input.readPositiveInt("Please enter the number(3 or less) of features you would like:");
			if(numOfFeatures>3||numOfFeatures<0)
				System.out.println("Invalid Input , please try again.");
		}
		while(numOfFeatures>3||numOfFeatures<0);
		if(numOfFeatures>0) {
			System.out.println("-----------------Car Features-----------------");
			System.out.println("Available Car Features, please choose:");
			System.out.println("a.4-by-4");
			System.out.println("b.diesel");
			System.out.println("c.hybrid");
			System.out.println("d.automatic");
			System.out.println("e.cabriolet");
			System.out.println("f.7-seat");
			System.out.println("g.air-condition");
			System.out.println("h.leather-seats");
			System.out.println("-----------------------------------");
			System.out.println();
			for(int count=0;count<numOfFeatures;count++) {
				option=input.readString("Please enter an option:");
				switch(option) {
				case "a":
					tmpFeatures[count]=availableFeatures[0];
					break;
				case "b":
					tmpFeatures[count]=availableFeatures[1];
					break;
				case "c":
					tmpFeatures[count]=availableFeatures[2];
					break;
				case "d":
					tmpFeatures[count]=availableFeatures[3];
					break;
				case "e":
					tmpFeatures[count]=availableFeatures[4];
					break;
				case "f":
					tmpFeatures[count]=availableFeatures[5];
					break;
				case "g":
					tmpFeatures[count]=availableFeatures[6];
					break;
				case "h":
					tmpFeatures[count]=availableFeatures[7];
					break;
				default:
					return null;
				}
			}
		}
		
		return tmpFeatures;
		
	}
	//Method used to check if the the car (that is about to be rented) has already been rented during the given period  
	private boolean checkIfPeriodsOverlapCar(Date tRentalDate,Date tReturnDate, Car tCar) {
		Date date1,date2;
		Vector<Integer> listOfRentalIndexes= new Vector<Integer>();
		//Searches all rentals and adds the indexes of the positions of the rentals that have been made with the car and stores them in a vector
		for(int count1=0;count1<numOfRentals;count1++) 
			if(tCar.equals(rentals[count1].getCar()))
				listOfRentalIndexes.add(count1);
		//Checking whether the dates of the rentals that have been made with the car overlap with the given ones. If they do overlap the method returns true.
		for(int count2=0;count2<listOfRentalIndexes.size();count2++) {
			date1=rentals[listOfRentalIndexes.get(count2)].getRentalDate();
			date2=rentals[listOfRentalIndexes.get(count2)].getReturnDate();
			if ((date1.equals(tRentalDate) || date1.before(tRentalDate)) && (!date2.before(tRentalDate)))
				return true;
			else if ((date1.equals(tRentalDate) || tRentalDate.before(date1)) && !tReturnDate.before(date1)) 
				return true;
		}
		//If no rental was found or the given dates do not overlap with any other dates, the method returns false			
		return false;
		
	}
	
	//Method to search customer by name from the array of the customers
	private Customer searchCustomer(String tmpName) {
		Customer tmpCustomer=null;
		for(int count1=0;count1<numOfCustomers;count1++) 
			if(tmpName.equals(customers[count1].getName()))
				tmpCustomer=customers[count1];	
		return tmpCustomer;
	}
	
	
	//Method to search from the cars that have been rented and print the rental's information
	private void searchAndPrintRentalCar(String tmpCarId) {
		boolean carFound=false;
		for(int count=0;count<numOfCars;count++)
			if(tmpCarId.equals(rentals[count].getCar().getCarId())) {
				rentals[count].printRentalInfo();
				carFound=true;
			}
				
		if(carFound==false) 
			System.out.println("Invalid input, car Id not found, returning to main menu...");
		
		
	}
	//Method to search from the customers' licenses and print the rental's information
	private void searchAndPrintRentalCustomer( String tmpLicenceId) {
		boolean carFound=false;
		for(int count=0;count<numOfRentals;count++)
			if(tmpLicenceId.equals(rentals[count].getCustomer().getLicenceId())) {
				rentals[count].printRentalInfo();
				carFound=true;
			}
		if(carFound==false) 
			System.out.println("Invalid input, car Id not found, returning to main menu...");		
	     
	}
	//Method that prints out rental information between start and end date(with start and end dates included).
	private void searchInRangeOfDates(Date start,Date end) {
		for(int count=0;count<numOfRentals;count++) {
			if(((start.equals(rentals[count].getRentalDate()))||start.before(rentals[count].getRentalDate()))&&((end.equals(rentals[count].getReturnDate())||end.after(rentals[count].getReturnDate()))))
				rentals[count].printRentalInfo();	
		}
	}
	
	//Method to search car by car id from the array of cars.
		public Car searchCar(String tmpCarId) {
			Car tmpCar=null;
			for(int count=0;count<numOfCars;count++)
				if(tmpCarId.equals(cars[count].getCarId()))
					tmpCar=cars[count];
			return tmpCar;
		}
		
	//Method to search customer by licenceId(Used in initialization)	
	public Customer searchCustomerToInitialize(String licenceId) {
		Customer tmpCustomer=null;
		for(int count=0;count<numOfCustomers;count++) 
			if(licenceId.equals(customers[count].getLicenceId()))
				tmpCustomer=customers[count];	
		return tmpCustomer;
	}
	
	//Method to use the constructor to initialize a car object via the CarRental Class.
	public void initializeCar(String carId,String carModel, int yearOfRelease, int distanceCovered, int pricePerDay,  float averageConsumption,String feature1,String feature2,String feature3 ) {
		cars[numOfCars]=new Car( carId, carModel, yearOfRelease,  distanceCovered,  pricePerDay,   averageConsumption, feature1, feature2, feature3 );
		numOfCars++;
	}
	//Option 1 of the main menu.It used to let the user to add a new car to the fleet.
	public void newCar() {
		//Features array
		String[] tmpFeatures=insertFeatures();
		if(tmpFeatures==null) {
			System.out.println("Invalid input, returning to main menu...");
			return;
		}
		cars[numOfCars]=new Car(input.readString("Please enter the car's id number:"),input.readString("Please enter the car Model:"),input.readPositiveInt("Please enter car's year of release:"),
				input.readPositiveInt("Please enter car's all time distance :"),input.readPositiveInt("Please enter car's price:"),
				input.readPositiveFloat("Please enter average fuel consumption of the car per 100 km:"),tmpFeatures);                                    
		numOfCars++;
	}
	//Option 2 of the main menu.It used to print all the available cars to the user.
	public void printCars() {
		for(int count=0;count<numOfCars;count++)
			cars[count].printCarInfo();	
	}
	//Method to use the constructor to initialize a customer object via the CarRental Class.
	public void initializeCustomer(String name,  String licenceId, String countryOfOrigin, int licenceYears) {
		customers[numOfCustomers]= new Customer(name,licenceId,countryOfOrigin,licenceYears);
		numOfCustomers++;
	}
	//Option 3 of the main menu. It used to add a new customer to the list of customers.
	public void newCustomer() {
		customers[numOfCustomers]=new Customer(input.readString("Please enter customer's name:"),input.readString("Please enter customer's licenceId:"),
				input.readString("Please enter customer's country of origin:"),input.readPositiveInt("Please enter customer's licence years:"));
		numOfCustomers++;
	}
	
	//Method to use the constructor to initialize a Rental object via the CarRental Class.
	public void initializeRental(Customer customer, Car car, Date rentalDate, Date returnDate,float fullPrice) {
		
		rentals[numOfRentals]= new Rental(customer,car,rentalDate, returnDate,fullPrice);
		numOfRentals++;
	}
	
	//Option 4 of the main menu.It is used to add a new Rental to the list of Rentals.
	public void newRental() {
		//Searching for the customer.
		Customer tCustomer=searchCustomer(input.readString("Enter customer's name:"));
		if(tCustomer==null)
		{
			System.out.println("Name not found , returning to main menu...");
			System.out.println();
			System.out.println();
	        return;
		}
		//Searching for the car.
		Car tCar=searchCar(input.readString("Enter car's Id:"));
		if(tCar==null)
		{
			System.out.println("Car Id not found , returning to main menu...");
			System.out.println();
			System.out.println();
	        return;
		}
		//Stores the input Dates
		Date tRentalDate=input.readDate("Please enter the rental Date:");
		Date tReturnDate=input.readDate("Please enter the renturn Date:");
		//Check whether the Dates overlap
		if(checkIfPeriodsOverlapCar(tRentalDate, tReturnDate, tCar)==true)
		{
			System.out.println("The car has been already rented for these Dates, returning to main menu...");
			System.out.println();
			System.out.println();
	        return;
		}
		rentals[numOfRentals]= new Rental(tCustomer,tCar,tRentalDate,tReturnDate,input.readPositiveInt("Please enter a discount(integer 0-100), enter 0 if there is no discount:"));
		numOfRentals++;
	}
	//Option 5 of the main menu.It used to print all the rentals based on a user search preference
	public void printRentals() {
		System.out.println("*****************Rentals*****************");
		System.out.println("a.Search and print by carId");
		System.out.println("b.Search and print by licenceId");
		System.out.println("c.Search and print by Date");
		System.out.println("***********************************");
		System.out.println();
		String option=input.readString("Please choose an option either a,b or c:");	
		switch(option) {
		case "a":
			//Searching based on the Car Id and then printing the rental
			searchAndPrintRentalCar( input.readString("Please enter car Id:"));
			break;
		case "b":
			//Searching based on the License Id and then printing the rental
			searchAndPrintRentalCustomer(input.readString("Please enter car Id:"));
			break;
		case "c":
			//Searching based on a range of given dates
			searchInRangeOfDates(input.readDate("Enter a start Date:"), input.readDate("Enter and end Date"));
			break;
		default:
			System.out.println("Invalid option, option not found, returning to main menu...");
		}
	}
	//Setters/Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Rental[] getRentals() {
		return rentals;
	}

	public void setRentals(Rental[] rentals) {
		this.rentals = rentals;
	}
	
}
