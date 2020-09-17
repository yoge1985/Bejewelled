import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Grid {

    private char[][] board;
    private Grid gridClass;

    public Grid(int height, int width) {
        this.board = new char[height][width];
        fillBoard();
    }

    public Grid(char[][] anotherGrid,String file){
        gridClass = createGrid(file);

    }

    //fills the board with random gems overwriting whatever is in the board
    public void fillBoard() {
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridPrint += board[i][j];
            }
            gridPrint += "\n";
        }
        return gridPrint;
    }

    public Grid createGrid(String fileName){
        char[][]gemsBoard = null;
        Grid grid = new Grid(gemsBoard,fileName);
        int pos = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                pos++;
                char gem = scanner.next().charAt(pos);
                String gridPrint = "";
                int height = gemsBoard.length;
                int width = gemsBoard[0].length;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        gem += gemsBoard[i][j];
                    }
                    gridPrint += "\n";
                }
            }

        }catch (IOException e){
            System.out.println("no dimensions to read");
        }
        return grid;
    }

    public void save(String filename){
        try {
            String saveInfo = "";
            for (int i = 0; i < this.board.length; i++){
                for (int j = 0; j < this.board[0].length; j++){
                    saveInfo += board[i][j] + "";
                }
                saveInfo += "\n";
            }
        }catch (Exception e){
            System.out.println("could not save!");
            
        }

    }

}
