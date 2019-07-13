package car_rental;

public class Customer {

	private String name,  licenceId, countryOfOrigin;
	private int licenceYears;
	//constructor
	public Customer(String name,  String licenceId, String countryOfOrigin, int licenceYears) {
		this.name=name;
		this.countryOfOrigin=countryOfOrigin;
		this.licenceYears=licenceYears;
		this.licenceId=licenceId;
		
	}

	
	//getters/setters
	public String getName() {
		return name;
	}

	public void setName(String firstName) {
		this.name = firstName;
	}
	
	public String getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(String licenceId) {
		this.licenceId = licenceId;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getLicenceYears() {
		return licenceYears;
	}

	public void setLicenceYears(int licenceYears) {
		this.licenceYears = licenceYears;
	}
	
	
}
