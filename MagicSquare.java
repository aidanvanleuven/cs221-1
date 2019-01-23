import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MagicSquare {

    public static String checkMatrix(File matrixFile){
        Scanner lineScanner;
        Scanner columnScanner;
        int size;
        String output = "The matrix: \n\n";
        boolean valid;

        try {
            lineScanner = new Scanner(matrixFile);
        } catch (FileNotFoundException e) {

            return "Error reading " + matrixFile + ".";
        }

        size = Integer.parseInt(lineScanner.nextLine());
        int[][] grid = new int[size][size];

        for (int i=0;lineScanner.hasNextLine();i++){

            columnScanner = new Scanner(lineScanner.nextLine());

            for (int j=0;columnScanner.hasNextInt();j++){

                grid[i][j] = columnScanner.nextInt();
            }

            columnScanner.close();
        }

        for (int i=0;i<grid.length;i++){
            output += "\t";
            for (int j=0;j<grid.length;j++){
                output += grid[i][j] + " ";
            }
            output += "\n";
        }

        // if (valid){
        //     output += "\nis a magic square";
        // } else {
        //     output += "\nis not a magic square";
        // }

        lineScanner.close();
        return output;
    }
}