package tuc.ece.cs102.car_rental.items;

import tuc.ece.cs102.car_rental.model.rentals.*;
import tuc.ece.cs102.list.Item;

import java.util.Date;

public class RentalItem extends Item {

	private Rental rental;

	public RentalItem(Rental rental) {
		super();
		this.rental = rental;
	}
	
	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if ( ((Date) key()).compareTo((Date) o.key()) < 0)
			return true;
		return false;

	}

	@Override
	public Object key() {
		return rental.getRentalDate();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		this.rental.print();
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return this.rental;
	}
}
