package tuc.ece.cs102.list;

public class EnhancedSortedList extends SortedList {
	private final String packgVehicles="tuc.ece.cs102.car_rental.model.vehicles.";
	
	protected Node iterationNode;
	public Item search(String key){
		Node tmpNode = head;
		while (tmpNode != null){
			if (tmpNode.getValue().key().equals(new String(key))){
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}
	
	public Item getItemForIteration() {
		Node tmp;
		if(iterationNode==null)
			iterationNode=head;
		tmp=iterationNode;
		iterationNode=iterationNode.getNext();
		return tmp.getValue();
	}
	
	public void resetIterationNode() {
		iterationNode=head;
	}
	public void printItemsInHierarchy(String className){
		Node tmp = head;
		try{
			while (tmp!=null){
				Item item = tmp.getValue();				
				if (Class.forName(packgVehicles+className).isInstance(item.getData())){
					item.print();
				}
				tmp = tmp.getNext();
			}
		}catch (ClassNotFoundException ex){
			System.out.println("This class "+className+" does not exist...");
		}		
	}
}
