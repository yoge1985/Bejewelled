import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Grid {

//    private int column;
//    private int row;
    private char[][]board;

    public Grid(int column, int row) {
//        this.column = column;
//        this.row = row;
        board = new char[column][row];
        fillBoard();
    }

    public Grid(char[][] anotherGrid){
        board = anotherGrid;
    }
//
//    public int getHeight() {
//        return column;
//    }
//
//    public int getWidth() {
//        return row;
//    }

    //fills the board with random gems overwriting whatever is in the board
    public void fillBoard() {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                    board[i][j] = getRandomGem();
            }
        }
    }

    public static char[]gems = {'r','g','b', 'y'};

    public static char getRandomGem(){
        int choice = (int)(Math.random() * gems.length);
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
    public void save(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            char text = ' ';
            int column = board.length;
            int row = board[0].length;
            fw.write(column + "" + " " + row + "" + "\n");

            for (int i = 0; i < column; i++){
                for (int j = 0; j < row; j++){
                    text = board[i][j];
                    fw.write(text);
                }
                fw.write("\n");
            }
            fw.close();
        }catch (Exception e){
            System.out.println("could not save!");

        }
    }
    //extracts specified data from the grid.
    public char[] extractRow(int rowNum){
        char[] extractedRow = new char[0];
        try {
        String selected = Files.readAllLines(Paths.get("C:\\Users\\family gefen\\Downloads\\Maze.txt")).get(rowNum);
        extractedRow = selected.toCharArray();

        }catch (Exception e){
            System.out.println("row " + rowNum + " does not exist");
        }
        return extractedRow;
    }

    public char[] extractColumn(int colNum){
        char[] extractedRow = new char[0];
        try {

            extractedRow = selected.toCharArray();

        }catch (Exception e){
            System.out.println("row " + colNum + " does not exist");
        }
        return extractedRow;

    }

}
