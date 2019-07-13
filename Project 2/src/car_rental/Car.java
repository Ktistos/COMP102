package car_rental;

public class Car {

	private String carModel, carId;
	private int yearOfRelease, distanceCovered, pricePerDay;
	private float averageConsumption;
	private String[] features=new String[3];
	//Constructor
	public Car(String carId,String carModel, int yearOfRelease, int distanceCovered, int pricePerDay,  float averageConsumption,String[] features ) {
		this.carModel=carModel;
		this.yearOfRelease=yearOfRelease;
		this.distanceCovered=distanceCovered;
		this.pricePerDay=pricePerDay;
		this.carId=carId;
		this.averageConsumption=averageConsumption;
		this.features=features;
		
	}
	//Constructor for initialization
	public Car(String carId,String carModel, int yearOfRelease, int distanceCovered, int pricePerDay,  float averageConsumption,String feature1,String feature2,String feature3 ) {
		this.carModel=carModel;
		this.yearOfRelease=yearOfRelease;
		this.distanceCovered=distanceCovered;
		this.pricePerDay=pricePerDay;
		this.carId=carId;
		this.averageConsumption=averageConsumption;
		this.features[0]=feature1;
		this.features[1]=feature2;
		this.features[2]=feature3;
	}
	//Outputs information about the car object 
	public void printCarInfo() {
		int count=0;
		System.out.println("================Car Info=================");
		System.out.println("Car model: "+carModel);
		System.out.println("Year of release: "+yearOfRelease);
		System.out.println("Distance covered: "+distanceCovered);
		System.out.println("Rental price per day: "+pricePerDay);
		System.out.println("Average fuel consumption per 100 km: "+averageConsumption);
		System.out.print("Car features:");
		System.out.println(features.length);
		//Prints the features 
		while(count<features.length ){
			if(features[count]==null) {
				break;
			}
			System.out.println(features[count]+" ");
			count++;
		}
		System.out.println();
		System.out.println("========================================");
		System.out.println();
		System.out.println();
	}
	
	//Getters/Setters
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public int getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(int distanceCovered) {
		this.distanceCovered = distanceCovered;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPrice(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public float getAverageConsumption() {
		return averageConsumption;
	}

	public void setAverageConsumption(float averageConsumption) {
		this.averageConsumption = averageConsumption;
	}

	public String[] getFeatures() {
		return features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}

}
