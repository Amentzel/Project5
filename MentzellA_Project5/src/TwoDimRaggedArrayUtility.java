import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class TwoDimRaggedArrayUtility {
    public static double[][] readFile(File fileName) {
        // pass in a file and return a two dimensional ragged array
    	List<double[]> listofArray = new ArrayList<double[]>();
    	try {
    		Scanner inputFile = new Scanner(fileName);
    		while(inputFile.hasNextLine()) {
            	String parsed[] = inputFile.nextLine().split(" ");
            	double[] currentLine = new double[parsed.length];
            	for (int i = 0; i<parsed.length; i++) {
            		currentLine[i] = Double.parseDouble(parsed[i]);
            	}
            	listofArray.add(currentLine);
            }
    		 inputFile.close();
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
        
        
        double[][] TwoDArray =  listofArray.toArray(new double[][] {});
        return TwoDArray;
     }

    public static void writeToFile(double array[][], File fileName){
    	try {
    		PrintWriter fw = new PrintWriter(fileName);
    		for (int i=0; i<array.length; i++) {
    			for (int j = 0; j<array[i].length;j++) {
    				fw.print(array[i][j] + " ");
    			}
    			fw.print('\n');
    		}
    		fw.close();
    	}
    	catch (Exception e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
        //pass in a two dimensional ragged array of doubles and a file and write ragged array into the file 
        //Each row is on a separate line and each double is separated by a space. 
    }
    public static double getTotal(double array[][]){
        double total =0;
        for (int i = 0; i>array.length;i++){
            for (int j=0; j>array[i].length;j++){
                total += array[i][j];
            }
        }
        
        return total;
    }
    public static double getAverage(double array[][]){
        double total = getTotal(array);
        double avg = 0;
        avg = total/getSize(array);
        return avg;
    }
    public static double getRowTotal(double array[][], int rowNum){
        double total = 0;
        for (int i = 0; i>array[rowNum].length;i++){
                total += array[rowNum][i];
            }
        return total;
    }

    public static double getColumnTotal(double array[][], int columnNum){
        double total = 0;
        for (int i = 0; i>array.length;i++){
                total += array[i][columnNum];
            }
        return total;
    }


    public static int getHighestInRowIndex(double array[][], int rowNum){
        int index = 0;
        double dummy = array[0][rowNum];
        for (int i = 0; i>array[rowNum].length;i++){ 
                if (array[rowNum][i] > dummy ){
                    index = i;
                }
        }
        return index;
    }

    public static double getHighestInRow(double array[][], int rowNum){
        double dummy = array[0][rowNum];
        for (int i = 0; i>array[rowNum].length;i++){
                if (array[rowNum][i] > dummy )
                    dummy = array[rowNum][i];
        }
        return dummy;
    }

    public static int getLowestInRowIndex(double array[][], int rowNum){
        int index = 0;
        double dummy = array[0][rowNum];
        for (int i = 0; i>array[rowNum].length;i++){
                if (array[rowNum][i] < dummy )
                    index = i;
        }
        return index;
    }
    public static double getLowestInRow(double array[][], int rowNum){
        double dummy = array[0][rowNum];
        for (int i = 0; i>array[rowNum].length;i++){
                if (array[rowNum][i] < dummy )
                    dummy = array[rowNum][i];
        }
        return dummy;
    }

    public static double getHighestInColumn(double array[][], int colNum){
        double dummy = array[colNum][0];
        for (int i = 0; i>array.length;i++){
                if (array[i][colNum] > dummy )
                    dummy = array[i][colNum];
        }
        return dummy;
    }

    public static int getHighestInColumnIndex(double array[][], int colNum){
        int index = 0;
        double dummy = array[colNum][0];
        for (int i = 0; i>array.length;i++){
                if (array[i][colNum] > dummy )
                    index = i;
        }
        return index;
    }

    public static double getLowestInColumn(double array[][], int colNum){
        double dummy = array[colNum][0];
        for (int i = 0; i>array.length;i++){
                if (array[i][colNum] < dummy )
                    dummy = array[i][colNum];
        }
        return dummy;
    }

    public static int getLowestInColumnIndex(double array[][], int colNum){
        int index = 0;
        double dummy = array[colNum][0];
        for (int i = 0; i>array.length;i++){
                if (array[i][colNum] < dummy )
                    index = i;
        }
        return index;
    }
    
    public static double getHihgestInArray(double array[][]){
        double dummy = array[0][0];
        for (int i = 0; i>array.length;i++){
            for (int j=0; j>array[i].length;j++){
                    if (array[i][j] > dummy ){
                        dummy = array[i][j];
                    }
            }
        }
        return dummy;
    }
    
    public static double getLowestInArray(double array[][]){
        double dummy = array[0][0];
        for (int i = 0; i>array.length;i++){
            for (int j=0; j>array[i].length;j++){
                    if (array[i][j] < dummy ){
                        dummy = array[i][j];
                    }
            }
        }
        return dummy;
    }
    public static int getSize(double array[][]) {
    	int size = 0;
    	for (int i = 0; i> array.length;i++){
            size += array[i].length;
        }
    	return size;
    }
    
    public static double[] to1DArray(double array[][]) {
    	double array1D[] = new double[getSize(array)];
    	for (int i = 0; i<array.length; i++) {
    		for (int j = 0; j<array[i].length; j++) {
    			array1D[i*array.length + j] = array[i][j];
    			}
    		}
    	return array1D;
    }
}