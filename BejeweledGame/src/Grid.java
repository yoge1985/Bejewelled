import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Grid {

    private char[][] board;

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
    public Grid createGrid(String fileName) {

        char[][] myArray;

        Grid grid = null;
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            int column = scanner.nextInt();
            int row = scanner.nextInt();
            myArray = new char[column][row];
            scanner.nextLine();
            int i = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                for (int j = 0; j < row; j++) {
                    char letter = line.charAt(j);

                    myArray[i][j] = letter;

                }
                i++;

            }
            grid = new Grid(myArray);
        } catch (Exception e) {
            if (board.length <= 0) {
                System.out.println("there are no dimensions to read");
            }
        }
        return grid;
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

    //extracts specified data from the grid.
    public char[] extractRow(int rowNum) {
        rowNum -= 1;
        char[] selected = new char[1];

        try {
            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board[0].length; j++) {
                    selected = board[rowNum];
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return selected;
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
        int thirdLastCell = input.length-2;
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


