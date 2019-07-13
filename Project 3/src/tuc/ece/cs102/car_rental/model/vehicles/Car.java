package tuc.ece.cs102.car_rental.model.vehicles;

import tuc.ece.cs102.car_rental.model.vehicles.enums.CarType;
import tuc.ece.cs102.car_rental.model.vehicles.enums.EnergyType;

public class Car extends Passenger {

	private int numOfDoors;
	private EnergyType energy;
	private CarType carType;
	public Car(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price,
			int maxNumOfPassengers, int engineCapacity, int numOfDoors, EnergyType energy) {
		super(vehicleId, vehicleModel, yearOfRelease, distanceCovered, price, maxNumOfPassengers, engineCapacity);
		this.numOfDoors = numOfDoors;
		this.energy = energy;
		
		if(maxNumOfPassengers<=7)
			carType=CarType.IX;
		else
			carType=CarType.DX;
		
		
	}
	
	
	public int getNumOfDoors() {
		return numOfDoors;
	}
	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	public EnergyType getEnergy() {
		return energy;
	}
	public void setEnergy(EnergyType energy) {
		this.energy = energy;
	}


	public CarType getCarType() {
		return carType;
	}


	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	
	public String toString() {
		return null;
	}

	@Override
	public void print() {
		System.out.print("Car: ");
		super.print();
		System.out.println("Number of doors: "+numOfDoors);
		System.out.println("Energy Source: "+energy);
		System.out.println("Public/Private usage(DX/IX): "+carType);
		System.out.println();
		System.out.println();
		
	}



	
	
	
}
