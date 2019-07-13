package tuc.ece.cs102.car_rental.items;

import tuc.ece.cs102.car_rental.model.clients.*;
import tuc.ece.cs102.list.Item;;

public class ClientItem extends Item{

	private Client client;
	
	public ClientItem(Client client) {
		super();
		this.client = client;
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
		return client.getAfm();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		this.client.print();
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return this.client;
	}

	
}
