import java.io.File;

/**
 * CS 221 Assignment 1: Warm-up
 * 
 * Acts as a driver class for MagicSquare.java.
 * Takes user input as command line arguments.
 * 
 * @author Aidan VanLeuven
 * @version 1.0
 */

public class MagicSquareDriver{

    public static void main(String[] args){
        File matrixFile; //filename
        int length = 0; //desired length

        //make sure there aren't 0 args
        if (args.length == 0){
            System.out.println("Please check your arguments, for a list of valid arguments enter \"MagicSquareDriver -arguments\"");
            return;
        }

        //print an argument helper
        if (args[0].equals("-arguments")){
            System.out.println("MagicSquareDriver");
            System.out.println("\t[-check | -create] [filename] [size]");
            System.out.println("\t*Size only required when using the \"-create\" flag. Must be odd.");
            return;
        }

        //run the checker if the args are correct
        if (args[0].equals("-check") && args.length == 2 && new File(args[1]).isFile()){
            matrixFile = new File(args[1]);
            System.out.println(MagicSquare.checkMatrix(matrixFile));
            return;

        //run the builder if the args are correct
        } else if (args[0].equals("-create") && args.length == 3){
            if (new File(args[1]).isFile()){
                System.out.println("File " + args[1] + " will be overwritten.");
            }
            length = Integer.parseInt(args[2]);
            System.out.println(MagicSquare.createMagicSquare(args[1], length));
            return;

        //if not, return some advice
        } else {
            System.out.println("Please check your arguments, for a list of valid arguments enter \"MagicSquareDriver -arguments\"");
            return;
        }

    }
}