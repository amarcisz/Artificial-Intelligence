package aima.search.mc;

import aima.search.framework.GoalTest;

/**
 * @author Justin Deschenes and Michael Fleming (Modified by Adam Marciszewski)
 * 
 */

public class MCGoalTest implements GoalTest{
	MCInstance goal;

/* 
   Goal state has 0 missionaries on the left, 0 cannibals on the left,
   m missionaries on the right, c cannibals on the right
   (where m and c are the inital numbers of missionaries and cannibals),
   and the boat on the right (indicated by 1 as the fifth array element).
*/
	public MCGoalTest(int m, int c){
 		goal = new MCInstance(new int[] { 0, 0, m, c, 1 });
	}

	public boolean isGoalState(Object state) {
		MCInstance instance = (MCInstance) state;
		return instance.equals(goal);
	}
}
