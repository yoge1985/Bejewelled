import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Grid {

    private char[][]grid;

    public Grid(int height, int width) {
        this.grid = new char[height][width];
        fillBoard();
    }

    public Grid(char[][] anotherGrid) {
        this.grid = createGrid();

    }

    //fills the board with random gems overwriting whatever is in the board
    public void fillBoard() {
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                    grid[i][j] = getRandomGem();
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
        int height = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridPrint += grid[i][j];
            }
            gridPrint += "\n";
        }
        return gridPrint;
    }

    public Grid createGrid(String fileName){
        Grid grid = new Grid(grid);
        int pos = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                pos++;
                char gem = scanner.next().charAt(pos);
                String gridPrint = "";
                int height = grid.length;
                int width = grid[0].length;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        gem += grid[i][j];
                    }
                    gridPrint += "\n";
                }
            }


        }catch (IOException e){
            System.out.println("no dimensions to read");
        }
        return place;

    }
    private String printCharMatrix(){
        String gridPrint = "";
        int height = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridPrint += grid[i][j];
            }
            gridPrint += "\n";
        }
        return gridPrint;

    }

}
