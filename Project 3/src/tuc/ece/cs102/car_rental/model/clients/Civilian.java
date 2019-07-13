package tuc.ece.cs102.car_rental.model.clients;

public class Civilian extends Client {

	public Civilian(String name, String afm, String cityOfResidence, String countryOfResidence, String phoneNumber) {
		super(name, afm, cityOfResidence, countryOfResidence, phoneNumber);
	}

	@Override
	public void print() {
		System.out.print("Client: ");
		super.print();
		System.out.println();
		System.out.println();
		
	}

	
	
}
