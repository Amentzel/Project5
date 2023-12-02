
public class HolidayBonus {
	private static double highestBonus = 5000;
	private static double lowestBonus = 1000;
	private static double middleBonus = 2000;
	
	
	public static double[] calculateHolidayBonus(double array[][]) {
		// find highest 
		double dummyHigh = array[0][0]; 
		int[] indexHigh = new int [2];
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length;j++) {
				if (array[i][j] > dummyHigh) {
					indexHigh[0]  = i;
					indexHigh[1] = j;
					dummyHigh = array[i][j];
					}
				}
			}
		// find lowest
		double dummyLow = 0; 
		int[] indexLow = new int [2];
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length;j++) {
				if (array[i][j] < dummyLow && array[i][j] > 0) {
					indexLow[0]  = i;
					indexLow[1] = j;
					dummyLow= array[i][j];
					}
				}
			}
		// assign bonus
		double bonusArray[][] = new double[array.length][];
		for (int i = 0; i<array.length; i++) {
			bonusArray[i] = new double[array[i].length];
			for (int j = 0; j<array[i].length;j++) {
				if (indexLow[0] == i && indexLow[1] == j) { // assign lowest bonus
					bonusArray[i][j] = lowestBonus;
					}
				if ((indexHigh[0] == i) && (indexHigh[1] == j)) {
					bonusArray[i][j] = highestBonus;
					}
				else {
					if (array[i][j] > 0) {
						bonusArray[i][j] = middleBonus;
						}
					}
				}
			}
	double[] bonusArray1D = TwoDimRaggedArrayUtility.to1DArray(bonusArray);
	
	return bonusArray1D;	
	} 
	
	
	public static double calculateTotalHolidayBonus(double[][] array) {
		double bonusArray[] = calculateHolidayBonus(array);
		double total = 0;
		for (int i = 0; i<bonusArray.length;i++) {
			total+=bonusArray[i];
		}
		return total;
	}
}
