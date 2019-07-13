package tuc.ece.cs102.car_rental.model.clients;

public class Business extends Client {



	public Business(String name, String afm, String cityOfResidence, String countryOfResidence, String phoneNumber, float discount) {
		super(name, afm, cityOfResidence, countryOfResidence, phoneNumber);
		super.setDiscount(discount);
	}

	public void print() {
		System.out.println("Business owner: ");
		super.print();
		System.out.println("Discount: " + super.getDiscount()*100+" %");
		System.out.println();
		System.out.println();
	}
	
}
