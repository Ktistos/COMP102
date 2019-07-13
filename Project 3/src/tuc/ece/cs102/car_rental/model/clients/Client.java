package tuc.ece.cs102.car_rental.model.clients;

public abstract class Client {

	private String name,afm,cityOfResidence,countryOfResidence,phoneNumber;
	private float discount=0;
	public Client(String name, String afm, String cityOfResidence, String countryOfResidence, String phoneNumber) {
		this.name = name;
		this.afm = afm;
		this.cityOfResidence = cityOfResidence;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return this.name;
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
	public String getCityOfResidence() {
		return cityOfResidence;
	}
	public void setCityOfResidence(String cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	public void print() {
		System.out.println("Name : "+name);
		System.out.println("Afm: "+ afm);
		System.out.println("Residence: "+ cityOfResidence+", "+countryOfResidence);
		System.out.println("Phone Number: "+ phoneNumber);
	}
	
}
