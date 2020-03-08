import java.util.Random;

public class CS4725A1 {
	
	public static int[] squares = {0,0};	// 2 Separate areas (0 = clean; 1 = Dirty)
	public static int VacLoc = 0;			// Vacuum Location
	
	
	public static int reward = 10;	// Reward for having clean square
	public static int Cs = 8;		// Cost to stay and clean
	public static int Cm = 4;		// Cost to move
	public static double p = 0.2;	// Probability of dirt appearing
	
	public static double q = 0.0;	// Probability of moving
	
	public static int timeStepScore = 0; // Score for each time step
	
	public static void main(String args[]){
		Random rand = new Random();
		for(int k = 0; k < 6; k++){
			timeStepScore = 0;
			q = (0.2 * k);
			if(k == 3) q = 0.6;
			
			for(int i=0; i < 100000; i++){
				for(int j=0; j < 2; j++){
					if(rand.nextDouble() < p){
						squares[j] = 1;
					}
				}
				
				// System.out.println("Before: Square A: " + squares[0] + "\tSquare B: " + squares[1]);
				
				//clean squares @ VacLoc
				if(squares[VacLoc] == 1){
					timeStepScore -= Cs;
					squares[VacLoc] = 0;
					
				}else if(squares[VacLoc] == 0 && rand.nextDouble() < q){
					if(VacLoc == 0){
						VacLoc = 1;
						timeStepScore -= Cm;
						//System.out.println("Move to B");
					}else if(VacLoc == 1){
						VacLoc = 0;
						timeStepScore -= Cm;
						//System.out.println("Move to A");
					}
				}/*else{
					System.out.println("Staying");
				}*/
				
				CalcScore();
				// System.out.println("After: Square A: " + squares[0] + "\tSquare B: " + squares[1]  + "\tScore: " + timeStepScore);
				// System.out.println("Step _________________________________ " + i + "\n");
			}
			System.out.print(timeStepScore + "\t");
		}
	}
	public static void CalcScore(){
		for(int i = 0; i < 2; i++){
			if(squares[i] == 0){
				timeStepScore += reward;
			}
		}
	}
}
