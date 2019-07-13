package tuc.ece.cs102.car_rental.items;

import tuc.ece.cs102.car_rental.model.vehicles.*;
import tuc.ece.cs102.list.*;

public class VehicleItem extends Item{

	private Vehicle vehicle;
	
	public VehicleItem(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if ( ((String) key()).compareTo((String) o.key()) < 0)
			return true;
		return false;

	}

	@Override
	public Object key() {
		// TODO Auto-generated method stub
		return vehicle.getVehicleId();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		this.vehicle.print();
	}

	@Override
	public Object getData() {
		return this.vehicle;
	}

	
}
