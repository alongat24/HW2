package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] items;
	private int count;

	public NaiveInventory() {
		items = new Collectible[INITIAL_CAPACITY];
		count = 0 ;
	}

	@Override
	public void collect(Collectible collectible) {
		if (count < items.length) {
			items[count] = collectible ;
			count ++ ;
		}
		else {
			Collectible[] temp = items ;
			items = new Collectible[(items.length)*2];
			for (int i=0 ; i<temp.length ; i++) {
				items[i] = temp[i] ;
			}
			items[count] = collectible ;
			count ++ ;
		} 
	}
	@Override
	public float getTotalWeight() {
		float weight = 0;
		for (int i=0 ; i<count ; i++) {
			weight += items[i].getWeight() ;
		}
	return weight;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return items;
	}
}
