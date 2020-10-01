import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        // Create some random boards
//        Grid g = new Grid(5, 5);
//        System.out.println(g);
//
//        Grid g2 = new Grid(2, 5);
//        System.out.println(g2);
//
//        Grid g3 = new Grid(3, 2);
//        System.out.println(g3);

        // Read in a good saved file
        try {
            Grid g = Grid.createGrid("phase2data.txt");
            System.out.println(g);
        }
        catch(IOException ioe) {
            // shouldn't run!
            System.out.println(ioe);
        }

        // Bad dimensions
        try {
            Grid g = Grid.createGrid("phase2data_badDimensions1.txt");
            // shouldn't run!
            System.out.println(g);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        try {
            Grid g = Grid.createGrid("phase2data_badDimensions2.txt");
            // shouldn't run!
            System.out.println(g);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }

        // bad Grid data
        try {
            Grid g = Grid.createGrid("phase2data_badRows.txt");
            // shouldn't run!
            System.out.println(g);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        try {
            Grid g = Grid.createGrid("phase2data_badColumns.txt");
            // shouldn't run!
            System.out.println(g);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }

        // now valid, but weird
        try {
            Grid g = Grid.createGrid("phase2data_fineIGuess.txt");
            // shouldn't run!
            System.out.println(g);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }

        // make a rando one, save
        Grid old = new Grid(5, 6);
        old.save("phase2SaveFile.txt");
        // load it up again
        Grid reload = null;
        try {
            reload = Grid.createGrid("phase2SaveFile.txt");
        } catch(IOException ioe) {
            System.out.println("This shouldn't be shown!");
            System.out.println(ioe);
        }
        System.out.println("These should be the same:");
        System.out.println(old);
        System.out.println();
        System.out.println(reload);
    }



//        Grid grid = new Grid(5,5);
//        System.out.println(grid);
//        grid.save("C:\\Users\\family gefen\\Downloads\\Maze.txt");
//        System.out.println("============================================");
//        System.out.println(grid.createGrid("C:\\Users\\family gefen\\Downloads\\Maze.txt"));
//        System.out.println("======================================");
////        System.out.println(grid.extractRow(2));
////        System.out.println(grid.extractColumn(3));
//        char[] testArray = {3,2,1,1,1,4,5};
//        System.out.println(Grid.replaceSets(testArray));

        // Read in a good saved file
//        Grid g = null;
//        try {
//            g = Grid.createGrid("phase3data.txt");
//            System.out.println(g);
//        }
//        catch(IOException ioe) {
//            // shouldn't run!
//            System.out.println(ioe);
//        }
//
//        System.out.println("Should match:");
//        System.out.println(g);
//        for (int i = 0; i < 4; i++)
//            System.out.println(Arrays.toString(g.extractRow(i)));
//
//        System.out.println("Should be the board reflected on the x=y axis");
//        for (int i = 0; i < 10; i++)
//            System.out.println(Arrays.toString(g.extractColumn(i)));
//
//    }

        // try some arrays
       /* char[] b1 = {'b', 'b', 'b'};
        char[] a1 = Grid.replaceSets(b1);
        System.out.println("Before: " + Arrays.toString(b1));
        System.out.println("After: " + Arrays.toString(a1));
*/
        // Read in a good saved file
//            Grid g = null;
//            try {
//                g = Grid.("phase4data.txt");
//                System.out.println(g);
//            }
//            catch(IOException ioe) {
//                // shouldn't run!
//                System.out.println(ioe);
//            }
//
//            for (int i = 0; i < 4; i++) {
//                char[] prev = g.extractRow(i);
//                char[] replaced = Grid.replaceSets(prev);
//                System.out.println("Replacing on row " + i);
//                System.out.println("old: " + Arrays.toString(prev));
//                System.out.println("new: " + Arrays.toString(replaced));
//            }
//
//        }



}

