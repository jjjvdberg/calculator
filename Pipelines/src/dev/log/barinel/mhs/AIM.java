package dev.log.barinel.mhs;

import java.util.ArrayList;

import dev.log.barinel.activity.ComponentVector;

/**
 * This class increments the hitting set by analyzing each execution and adapt
 * the currently known hitting sets to the new set of hitting sets that still explain
 * all the executions.
 * 
 * @author Joel van den Berg
 *
 */
public class AIM {

	/**
	 * The list of minimum hitting sets
	 */
	private ArrayList<HittingSet> hittingsets = new ArrayList<HittingSet>();
	
	/**
	 * Adds an execution which is broken up and analyzed. When an execution has
	 * no error, it adds no extra information for the hitting set and can be discarded.
	 * When an execution results in a failure (error) then we search through the
	 * current known hitting sets to see if they contain an component in the execution.
	 * If it contains an component, this means that this execution is also covered by the
	 * same hit set.
	 * if it does not contain an component we add all possible combinations of the hit set
	 * with the components in the execution. If this results in a hit set that is not
	 * consumed by the current hit sets, it is added to the set of hit sets.
	 * 
	 * @param execution The execution which contains the hit components
	 * @param error
	 */
	public void addExecution(ArrayList<String> execution, Integer error) {
		if(error == 1) {
			if(hittingsets.isEmpty()) {// no errors occured yet
				for(String c : execution) {
					HittingSet set = new HittingSet();
					set.addComponent(c);
					hittingsets.add(set);
				}
			} else { /* check if there are sets that can't explain this set */
				ArrayList<HittingSet> toAdd = new ArrayList<HittingSet>();
				ArrayList<HittingSet> toRemove = new ArrayList<HittingSet>();
				
				for(HittingSet hitset : hittingsets) {
					if(!hitset.containsAnyComponent(execution)) {
						toRemove.add(hitset);
					}
				}
				hittingsets.removeAll(toRemove);

				for(HittingSet hitset : toRemove) {
					for(String c : execution) {
						HittingSet copy = hitset.copy();
						copy.addComponent(c);
						if(!this.subsumedByHittingSets(copy))
							toAdd.add(copy);
					}
				}
				hittingsets.addAll(toAdd);
			}
//			System.out.println("new hittingsets " + hittingsets);
		}
	}
	
	/**
	 * If set contains all components of an component in sets, it is subsumed by sets.
	 * 
	 * @param set the hitset that is checked to be subsumed
	 * @param sets the list of hittingsets that may subsume set
	 * @return true when set is subsumed by sets; false otherwise
	 */
	public boolean subsumedByHittingSets(HittingSet set) {
		for(HittingSet hitset : this.hittingsets) {
			boolean subsumed = true;
			
			subsumed = hitset.containsAllComponents(set);
			
			if(subsumed)
				return true;
		}
		return false;
	}
	
	/**
	 * Get the found hitting sets
	 * @return The hitting sets
	 */
	public ArrayList<HittingSet> getHittingSets() {
		return hittingsets;
	}

	/**
	 * Sorts the hitting sets for this AIM by the error that was obtained
	 * from the barinel algorithm. Since the errors are initialized by 0.0
	 * sorting without having performed the barinel algorithm doesn't change
	 * the order.
	 */
	public void sortByError() {
		for(int i = 0; i < this.hittingsets.size(); i++) {
			HittingSet v = this.hittingsets.get(i);
			int k;
			for(k = i; k-1 >= 0 && v.getError() > this.hittingsets.get(k-1).getError(); k--);
//			System.out.println("put component " + i + " at position " + k);
			this.hittingsets.add(k, this.hittingsets.remove(i));
		}
	}
	
	/**
	 * More human readable representation of the minimum-size hitting set
	 * @return human readable string
	 */
	@Override
	public String toString() {
		return this.hittingsets.toString();
	}

}
