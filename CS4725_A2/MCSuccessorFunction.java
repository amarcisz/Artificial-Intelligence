package aima.search.mc;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/**
 * @author Justin Deschenes and Michael Fleming (Modified by Adam Marciszewski)
 *
 */

public class MCSuccessorFunction implements SuccessorFunction {

	public List getSuccessors(Object state) {
		MCInstance instance = (MCInstance) state;
		List<Successor> successors = new ArrayList<Successor>();
			MCInstance newInstance2 = copyOf(instance);
			MCInstance newInstance3 = copyOf(instance);
			MCInstance newInstance4 = copyOf(instance);
			MCInstance newInstance5 = copyOf(instance);
			MCInstance newInstance6 = copyOf(instance);
			MCInstance newInstance7 = copyOf(instance);
			MCInstance newInstance8 = copyOf(instance);
			MCInstance newInstance9 = copyOf(instance);

			newInstance2.sendOver(3,0);
			if(good(newInstance2))
				successors.add(new Successor(MCInstance.M3C0, newInstance2));

			newInstance3.sendOver(2,1);
			if(good(newInstance3))
				successors.add(new Successor(MCInstance.M2C1, newInstance3));

			newInstance4.sendOver(0,3);
			if(good(newInstance4))
				successors.add(new Successor(MCInstance.M0C3, newInstance4));

			newInstance5.sendOver(2,0);
			if(good(newInstance5))
				successors.add(new Successor(MCInstance.M2C0, newInstance5));

			newInstance6.sendOver(1,1);
			if(good(newInstance6))
				successors.add(new Successor(MCInstance.M1C1, newInstance6));

			newInstance7.sendOver(0,2);
			if(good(newInstance7))
				successors.add(new Successor(MCInstance.M0C2, newInstance7));

			newInstance8.sendOver(1,0);
			if(good(newInstance8))
				successors.add(new Successor(MCInstance.M1C0, newInstance8));

			newInstance9.sendOver(0,1);
			if(good(newInstance9))
				successors.add(new Successor(MCInstance.M0C1, newInstance9));

		return successors;
	}


	private boolean good(MCInstance x){
		if(x.atInstance(0) < x.atInstance(1)) return false;
		if(x.atInstance(2) < x.atInstance(3)) return false;

		return true;
/*
 *

Note: x.atLocation(0) and x.atLocation(1) can be used to access
the numbers of missionaries and cannibals, respectively, on the left
side of the river in instance x.  Similarly, x.atLocation(2) and
x.atLocation(3) provide the number of people on the right.
x.atLocation(4) provides the location of the boat (0=left, 1=right).
*/

	}


	private MCInstance copyOf(MCInstance instance) {
		MCInstance newInstance = new MCInstance();
		newInstance.setInstance(instance.getList());
		return newInstance;
	}

}
