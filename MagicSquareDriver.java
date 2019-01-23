import java.io.File;

public class MagicSquareDriver{

    public static void main(String[] args){
        File matrixFile;
        int length = 0;

        if (args.length == 0){
            System.out.println("Please check your arguments, for a list of valid arguments enter \"MagicSquareDriver -arguments\"");
            return;
        }

        if (args[0].equals("-arguments")){
            System.out.println("MagicSquareDriver");
            System.out.println("\t[-check | -create] [filename] [size]");
            System.out.println("\t*Size only required when using the \"-create\" flag.");
            return;
        }

        if (args[0].equals("-check") && args.length == 2 && new File(args[1]).isFile()){
            matrixFile = new File(args[1]);
            System.out.println(MagicSquare.checkMatrix(matrixFile));

        } else if (args[0].equals("-create") && args.length == 3 && !new File(args[1]).isFile()){

            length = Integer.parseInt(args[2]);

        } else {
            System.out.println("Please check your arguments, for a list of valid arguments enter \"MagicSquareDriver -arguments\"");
            return;
        }

    }
}