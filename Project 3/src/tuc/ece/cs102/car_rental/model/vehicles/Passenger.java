package tuc.ece.cs102.car_rental.model.vehicles;

public abstract class Passenger extends Vehicle {

	int maxNumOfPassengers,engineCapacity;

	public Passenger(String carId, String carModel, int yearOfRealease, float distanceCovered, float price,
			int maxNumOfPassengers, int engineCapacity) {
		super(carId, carModel, yearOfRealease, distanceCovered, price);
		this.maxNumOfPassengers = maxNumOfPassengers;
		this.engineCapacity = engineCapacity;
	}

	public int getMaxNumOfPassengers() {
		return maxNumOfPassengers;
	}

	public void setMaxNumOfPassengers(int maxNumOfPassengers) {
		this.maxNumOfPassengers = maxNumOfPassengers;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Max number of Passengers: "+maxNumOfPassengers);
		System.out.println("Engine Capacity : "+engineCapacity+" cc");
		
	}
	
	
}
