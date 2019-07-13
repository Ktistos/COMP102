package tuc.ece.cs102.car_rental.model.vehicles;

public abstract class Vehicle {

	private String vehicleId,vehicleModel;
	private int yearOfRelease;
	private float distanceCovered,price;
	public Vehicle(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleModel = vehicleModel;
		this.yearOfRelease = yearOfRelease;
		this.distanceCovered = distanceCovered;
		this.price = price;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId= vehicleId;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public float getDistanceCovered() {
		return distanceCovered;
	}
	public void setDistanceCovered(float distanceCovered) {
		this.distanceCovered = distanceCovered;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleModel=" + vehicleModel + ", yearOfRelease=" + yearOfRelease
				+ ", distanceCovered=" + distanceCovered + ", price=" + price + "]";
	}
	
	public void print() {
		System.out.println("Vehicle Id: "+vehicleId);
		System.out.println("Vehicle Model: "+vehicleModel);
		System.out.println("Year Of Release: "+yearOfRelease);
		System.out.println("Distance Covered: "+ distanceCovered);
		System.out.println("Price: "+price);
	}
	
}
