import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * CS 221 Assignment 1: Warm-up
 * 
 * Checks to see if an inputted file is a magic square.
 * Also is able to create new magic squares of size n, assuming n is odd.
 * 
 * @author Aidan VanLeuven
 * @version 1.0
 */

public class MagicSquare {

    //checker function
    public static String checkMatrix(File matrixFile) {
        Scanner lineScanner; // scans the file
        Scanner columnScanner; // scans each line
        int size; // size of the array neccessary
        int magicNumber; // number each row, column, and diagonal adds up to

        // try to load the file; should be unneccessary because of previous checks but
        // the compiler likes it
        try {
            lineScanner = new Scanner(matrixFile);
        } catch (FileNotFoundException e) {
            return "Error reading " + matrixFile + ".";
        }

        // use the first line to establish matrix size
        size = Integer.parseInt(lineScanner.nextLine());

        // make a new 1d array for the numbers
        int[] numberList = new int[size * size];

        // create 2d array of proper size
        int[][] grid = new int[size][size];

        // loop through rows and columns and add values to a 1d and 2d array
        for (int i = 0; lineScanner.hasNextLine(); i++) {
            columnScanner = new Scanner(lineScanner.nextLine());
            for (int j = 0; columnScanner.hasNextInt(); j++) {
                int next = columnScanner.nextInt();
                numberList[i * size + j] = next;
                grid[i][j] = next;
            }
            columnScanner.close();
        }
        lineScanner.close();

        // sort the array
        Arrays.sort(numberList);

        // get the magic number
        magicNumber = (size * (size * size + 1)) / 2;

        // go through test conditions

        // check the arrays numbers to verify the magic square
        for (int i = 0; i < numberList.length; i++) {
            if (i + 1 != numberList[i]) {
                return outputValues(grid, false);
            }
        }

        //set up some values to check against the magic number
        int checkValue1 = 0;
        int checkValue2 = 0;

        // check the sums to verify the magic square
        // check rows and columns
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                checkValue1 += grid[i][j];
                checkValue2 += grid[j][i];
            }
            if (checkValue1 != magicNumber || checkValue2 != magicNumber) {
                return outputValues(grid, false);
            } else {
                checkValue1 = 0;
                checkValue2 = 0;
            }
        }

        //one more check value
        int checkValue3 = 0;

        // check first diagonal
        for (int i = 0; i < grid.length; i++) {
            checkValue3 += grid[i][i];
        }
        if (checkValue3 != magicNumber) {
            return outputValues(grid, false);
        }

        //reset check value
        checkValue3 = 0;

        //check second diagonal
        for (int i=size-1;i>=0;i--){
            checkValue3 += grid[i][i];
        }

        if (checkValue3 != magicNumber) {
            return outputValues(grid, false);
        }

        // if it passes all tests, output a success message
        return outputValues(grid, true);
    }

    public static String createMagicSquare(String fileName, int size) {
        int[][] grid = new int[size][size];
        int row = size - 1;
        int col = size / 2;
        int oldRow;
        int oldCol;
        File file = new File(fileName);
        String output = "";

        //only allows odd numbers
        if (size%2 != 1){
            return "Error: only odd sizes are supported at this time.";
        }

        //fills in the 2d array
        for (int i = 1; i < size * size + 1; i++) {
            grid[row][col] = i;
            oldRow = row;
            oldCol = col;
            row++;
            col++;
            if (row == size) {
                row = 0;
            }
            if (col == size) {
                col = 0;
            }
            if (grid[row][col] != 0) {
                row = oldRow;
                col = oldCol;
                row--;
            }
        }
        //builds the final format
        output += size + "\n";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j != size - 1) {
                    output += grid[i][j] + " ";
                } else {
                    output += grid[i][j];
                }
            }
            output += "\n";
        }

        //writes the output to a file
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
            outFile.println(output);
            outFile.close();
        } catch (IOException e) {
            return "Error creating file. Is the filename actually a directory?";
        }

        //return the square and a success message
        return "The magic square:\n" + output + "\nHas been successfully created at: " + fileName;
    }

    //formats the output from the checker function
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