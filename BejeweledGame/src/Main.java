import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Grid g = Grid.createGrid("C:\\phase5data1(new).txt");
            System.out.println(g);
            g.replaceAll();
            System.out.println("===================");
            System.out.println(g);
        }catch (IOException ioe){
            System.out.println(ioe);
        }



        // try some arrays
//        char[] b1 = {'b','b','b'};
//        char[] a1 = Grid.replaceSets(b1);
//        System.out.println("Before: " + Arrays.toString(b1));
//        System.out.println("After: " + Arrays.toString(a1));
//
//        // Read in a good saved file
//        Grid g = null;
//        try {
//            g = Grid.createGrid("C:\\phase4data.txt");
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            // shouldn't run!
//            System.out.println(ioe);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            char[] prev = g.extractRow(i);
//            char[] replaced = Grid.replaceSets(prev);
//            System.out.println("Replacing on row " + i);
//            System.out.println("old: " + Arrays.toString(prev));
//            System.out.println("new: " + Arrays.toString(replaced));
//        }

    }




//        // Read in a good saved file
//        try {
//            Grid g = Grid.createGrid("C:\\phase2data.txt");
//            System.out.println(g);
//
//            System.out.println(g.extractRow(1));
//            System.out.println(g.extractColumn(1));
//        }
//        catch(IOException ioe) {
//            // shouldn't run!
//            System.out.println(ioe);
//        }

//        // Bad dimensions
//        try {
//            Grid g = Grid.createGrid("C:\\phase2data_badDimensions1.txt");
//            // shouldn't run!
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//        try {
//            Grid g = Grid.createGrid("C:\\phase2data_badDimensions2.txt");
//            // shouldn't run!
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//
//        // bad Grid data
//        try {
//            Grid g = Grid.createGrid("C:\\phase2data_badRows.txt");
//            // shouldn't run!
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//        try {
//            Grid g = Grid.createGrid("C:\\phase2data_badColumns.txt");
//            // shouldn't run!
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//
//        // now valid, but weird
//        try {
//            Grid g = Grid.createGrid("phase2data_fineIGuess.txt");
//            // shouldn't run!
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            System.out.println(ioe);
//        }
//
//        // make a rando one, save
//        Grid old = new Grid(5, 6);
//        old.save("phase2SaveFile.txt");
//        // load it up again
//        Grid reload = null;
//        try {
//            reload = Grid.createGrid("phase2SaveFile.txt");
//        } catch(IOException ioe) {
//            System.out.println("This shouldn't be shown!");
//            System.out.println(ioe);
//        }
//        System.out.println("These should be the same:");
//        System.out.println(old);
//        System.out.println();
//        System.out.println(reload);

}


