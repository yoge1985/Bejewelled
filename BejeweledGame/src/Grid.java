public class Grid {

    private char[][]grid;

    public Grid(int height, int width) {
        this.grid = new char[height][width];
        fillBoard();

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

}
