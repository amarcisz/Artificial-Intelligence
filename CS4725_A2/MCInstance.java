package aima.search.mc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justin Deschenes and Michael Fleming (Modified by Adam Marciszewski)
 * 
 */

public class MCInstance {

        public static String M3C0 = "3M";
        public static String M2C1 = "2M + 1C";
        public static String M0C3 = "3C";
        public static String M2C0 = "2M";
        public static String M1C1 = "1M + 1C";
        public static String M0C2 = "2C";
	public static String M1C0 = "1M";
        public static String M0C1 = "1C";

	public int[] getInstance() {
		return instance;
	}

	int[] instance;

/*
An instance is an array of five integers:
  the number of missionaries on the left
  the number of cannibals on the left
  the number of missionaries on the right
  the number of cannibals on the right
  a 0 or 1, indicating that the boat is on the left or right, respectively
*/
	public MCInstance(){
		instance = new int[5];
	}

/*
Initially, we have m missionaries and c cannibals on the left,
nobody on the right, with the boat on the left.
*/
	public MCInstance(int m, int c) {
		instance = new int[] { m, c, 0, 0, 0};
	}

	public MCInstance(int[] anInstance) {
		instance = anInstance;
	}

        public int atLocation(int i) {
                return instance[i];
        }

        public void setValueAtLocation(int i, int v) {
		instance[i] = v;
        }

        public void setInstance(int[] nums) {
                for (int i = 0; i < 5; i++) {
                        this.setValueAtLocation(i,nums[i]);
                }
        }

        public int[] getList() {
		int[] arr = new int[] {0, 0, 0, 0, 0};

                for (int i = 0; i < 5; i++) {
			arr[i] = this.atLocation(i);
                }
                return arr;
        }

        public void sendOver(int m, int c) {
		int[] nums = new int[5];


		if((this.atLocation(4)) == 0){	// if the boat is currently on the left
			nums[0] = instance[0] - m;
			nums[1] = instance[1] - c;
			nums[2] = instance[2] + m;
			nums[3] = instance[3] + c;
			nums[4] = 1;

       	}else{	// if the boat is currently on the right
   			nums[0] = instance[0] + m;
			nums[1] = instance[1] + c;
			nums[2] = instance[2] - m;
			nums[3] = instance[3] - c;
			nums[4] = 0;



		}
		this.setInstance(nums);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		MCInstance anInstance = (MCInstance) o;

		for (int i = 0; i < 5; i++) {
			if (this.atLocation(i) != anInstance.atLocation(i)) {
				return false;
			}
		}
		return true;
	}


	@Override
	public String toString() {
		String retVal =  "LM: " + instance[0] + " LC: " + instance[1] + " RM: "
				+ instance[2] + " RC: " + instance[3] + " Boat:";
		
		if(instance[4] == 0){
			retVal += " left";
		}else{
			retVal += " right";
		} 
		return retVal;
	}

}

