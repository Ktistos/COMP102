package tuc.ece.cs102.car_rental.model.vehicles;

public class Truck extends Vehicle {

	private float width,height,maxLoad;
	
	
	
	public Truck(String vehicleId, String vehicleModel, int yearOfRelease, float distanceCovered, float price, float maxLoad,
			float width, float height) {
		super(vehicleId, vehicleModel, yearOfRelease, distanceCovered, price);
		this.maxLoad = maxLoad;
		this.width = width;
		this.height = height;
	}
	
	public float getMaxLoad() {
		return maxLoad;
	}
	public void setMaxLoad(float maxLoad) {
		this.maxLoad = maxLoad;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public void print() {
		System.out.print("Truck: ");
		super.print();
		System.out.println("Max Load: "+maxLoad+"kg");
		System.out.println("Width: "+width+"m");
		System.out.println("Height: "+height+"m");
		System.out.println();
		System.out.println();
		
		
	}
	
	
}
