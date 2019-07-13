package tuc.ece.cs102.car_rental.model.vehicles;

import tuc.ece.cs102.car_rental.model.vehicles.enums.BikeType;

public class Bike extends Passenger {

	private BikeType bikeType;

	public Bike(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price,
			int maxNumOfPassengers, int engineCapacity, BikeType bikeType) {
		super(vehicleId, vehicleModel, yearOfRelease, distanceCovered, price, maxNumOfPassengers, engineCapacity);
		this.bikeType = bikeType;
	}

	public BikeType getBikeType() {
		return bikeType;
	}

	public void setBikeType(BikeType bikeType) {
		this.bikeType = bikeType;
	}

	@Override
	public void print() {
		System.out.print("Bike: ");
		super.print();
		System.out.println("Bike Type: "+bikeType);
		System.out.println();
		System.out.println();
	}

	
}
