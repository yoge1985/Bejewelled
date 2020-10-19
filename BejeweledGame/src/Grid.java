import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Grid {

    private static char[][] board;

    public Grid(int column, int row) {

        board = new char[column][row];
        fillBoard();
    }

    public Grid(char[][] anotherGrid) {
        board = anotherGrid;
    }

    public char[][] getBoard() {
        return board;
    }

    //fills the board with random gems overwriting whatever is in the board
    public void fillBoard() {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                board[i][j] = getRandomGem();
            }
        }
    }

    public static char[] gems = {'r', 'g', 'b', 'y'};

    public static char getRandomGem() {
        int choice = (int) (Math.random() * gems.length);
        return gems[choice];

    }

    @Override
    public String toString() {
        String gridPrint = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                gridPrint += board[i][j];
            }
            gridPrint += "\n";
        }
        return gridPrint;
    }

    //displays the current gems board saved in a file
    public static Grid createGrid(String fileName) throws IOException {
        int column = 0;
        int row = 0;
        int lengthOfFileColumn = 0;
        int numberOfFileRows = 0;
        String str = null;
        int test = 0;

        Scanner scanner = null;

        char[][] myArray = null;

        Grid grid = null;
        try {//attempts to retrieve file
            scanner = new Scanner(new FileReader(fileName));

        } catch (FileNotFoundException e) {
            throw new IOException("cannot find file");
        }
        try {//attempts to retrieve number of columns and rows from file

            row = scanner.nextInt();
            column = scanner.nextInt();

        } catch (NoSuchElementException nsee) {
            if (!scanner.hasNext()) {

                throw new IOException("no dimensions available");

            } else if (!scanner.hasNextInt()) {
                throw new IOException("size values not numeric");
                //if stated amount of columns (listed at top of file) is not found in f
            }
        }

        try {
            while (scanner.hasNext()) {
                scanner.next();
                numberOfFileRows++;
            }

            test = row / numberOfFileRows;
            test = row / test;
            test = numberOfFileRows / row;
            test = row / test;


        }catch (ArithmeticException ae){
            throw new IOException("not enough rows. found " + numberOfFileRows + " require " + row);
        }
        //test to see if correct number of columns
        try {
            scanner = new Scanner(new FileReader(fileName));
            scanner.nextLine();
            str = scanner.nextLine();
            lengthOfFileColumn = str.length();
            test = column / lengthOfFileColumn;
            test = column / test;
            test = lengthOfFileColumn / column;
            test = column / test;

        } catch (ArithmeticException ae) {
            throw new IOException("there was not enough columns. found " + lengthOfFileColumn + " require " + column);
        }


        myArray = new char[row][column];
        int i = 0;
        scanner = new Scanner(new FileReader(fileName));
        scanner.nextLine();

        while (scanner.hasNext()) {
            str = scanner.nextLine();

            for (int j = 0; j < column; j++) {
                char letter = str.charAt(j);

                myArray[i][j] = letter;

            }
            i++;
        }

        if (myArray.length <= 0) {
            System.out.println("there are no dimensions to read");
        }
        return new Grid(myArray);
    }

    //saves the current gems board to a file
    public void save(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            char text = ' ';
            int column = board.length;
            int row = board[0].length;
            fw.write(column + "" + " " + row + "" + "\n");

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    text = board[i][j];
                    fw.write(text);
                }
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("could not save!");

        }
    }

    //prompts user to select row from the grid. 0 = first row etc.
    public char[] extractRow(int rowNum) throws IOException {
        System.out.println("select row. 0 = first row etc");

        String selectedRow = "";
        char[] arrayOfSelectedRow = null;

        try {

                for (int j = 0; j < board[0].length; j++) {
                    selectedRow += board[rowNum][j];
                }

                // Creating array of string length
                arrayOfSelectedRow = new char[selectedRow.length()];

                // Copy character by character into array
                for (int i = 0; i < selectedRow.length(); i++) {
                    arrayOfSelectedRow[i] = selectedRow.charAt(i);
                }


        } catch (InputMismatchException ime) {
            throw new IOException("did not enter valid row number");
        }
        return arrayOfSelectedRow;
    }

    public char[] extractColumn(int colNum) {

        colNum -= 1;
        char[] selected = new char[board[0].length];

        try {
            for (int i = 0; i < this.board.length; i++) {

                selected[i] = board[i][colNum];
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return selected;
    }

    //passes a 1d array of gems and checks if there is set of 3 (or more) gems in a row. if yes, then replaces with
    //new array
    public static char[] replaceSets(char[] input) {
        char[] newArray;
        boolean matchFound = true;
        int i = 0;
        int thirdLastCell = input.length - 2;
        while (matchFound && i != thirdLastCell) {

            for (i = 0; i < thirdLastCell; i++) {

                int j = i + 1;

                if (input[i] == input[j] && input[i] == input[j + 1]) {
                    newArray = new char[input.length];
                    for (int k = 0; k < input.length; k++) {
                        newArray[k] = getRandomGem();
                        matchFound = false;
                    }
                    return newArray;
                }

            }
        }
        return input;
    }
}


