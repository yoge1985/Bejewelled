import java.util.Arrays;

public class Grid {

    private char[][]grid;

    public Grid(int height, int width) {
        this.grid = new char[height][width];
        fillBoard();
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row).replace('[', ' ').replace(']', ' '));
        }
    }

    //fills the board with random gems overwriting whatever is in the board
    public void fillBoard() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = getRandomGem();
                }
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
        return Arrays.toString(grid);
    }
}
