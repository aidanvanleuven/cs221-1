import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {

    public static String checkMatrix(File matrixFile){
        Scanner lineScanner; //scans the file
        Scanner columnScanner; //scans each line
        int size; //size of the array neccessary
        //boolean valid; //bool for validity
        int magicNumber;

        //try to load the file; should be unneccessary because of previous checks but the compiler likes it
        try {
            lineScanner = new Scanner(matrixFile);
        } catch (FileNotFoundException e) {
            return "Error reading " + matrixFile + ".";
        }

        //use the first line to establish matrix size
        size = Integer.parseInt(lineScanner.nextLine());
        
        //make a new 2d array for the numbers
        int[] numberList = new int[size*size];

        //create 2d array of proper size
        int[][] grid = new int[size][size];

        //loop through rows and columns and add values to a 1d and 2d array
        for (int i=0;lineScanner.hasNextLine();i++){

            columnScanner = new Scanner(lineScanner.nextLine());
            for (int j=0;columnScanner.hasNextInt();j++){
                int next = columnScanner.nextInt();
                numberList[i*size+j] = next;
                grid[i][j] = next;
            }
            columnScanner.close();
        }
        lineScanner.close();

        //sort the array
        Arrays.sort(numberList);

        //get the magic number
        magicNumber = (size*(size*size+1))/2;

        //initial state is true, if this is changed, return the false output
        //valid = true;

        //check the arrays numbers to verify the magic square
        for (int i=0;i<numberList.length;i++){
            if (i+1 != numberList[i]){
                //valid = false;
                return outputValues(grid, false);
            }
        }

        int checkValue1 = 0;
        int checkValue2 = 0;

        System.out.println(magicNumber);

        //check the sums to verify the magic square
        //check rows and columns
        for (int i=0;i<grid.length;i++){

            for (int j=0;j<grid.length;j++){
                checkValue1 += grid[i][j];
                checkValue2 += grid[j][i];
            }

            if (checkValue1 != magicNumber || checkValue2 != magicNumber){
                return outputValues(grid, false);
            } else {
                checkValue1 = 0;
                checkValue2 = 0;
            }
        }

        int checkValue3 = 0;

        //check diagonals
        for (int i=0;i<grid.length;i++){
            checkValue3 += grid[i][i];
        }

        if (checkValue3 != magicNumber){
            return outputValues(grid, false);
        }

        //if it passes all tests, output a success message
        return outputValues(grid, true);

        //return "There was an error checking the square.";
    }

    public static String createMagicSquare(String fileName, int size){
        int[][] grid = new int[size][size];
        int row = size - 1;
        int col = size/2;
        int oldRow;
        int oldCol;

        for (int i=1;i<size*size;i++){
            grid[row][col] = i;
            oldRow = row;
            oldCol = col;
            if (row == size){
                row = 0;
            }
            if 
            (col == size){
                col = 0;
            }
            
        }
        return "";
    }

    private static String outputValues(int[][] matrix, boolean isValid){
        String output = "The matrix: \n\n";

        //format the output
        for (int i=0;i<matrix.length;i++){
            output += "\t";
            for (int j=0;j<matrix.length;j++){
                output += matrix[i][j] + " ";
            }
            output += "\n";
        }
        
        //add the appropriate message
        if (isValid){
            output += "\nis a magic square.";
        } else {
            output += "\nis not a magic square.";
        }

        return output;
    }
}