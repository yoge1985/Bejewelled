import java.io.FileWriter;

public class Grid {

    private char[][] board;
    private Grid gridClass;

    public Grid(char[][] anotherGrid){

    }

    public Grid(int height, int width) {
        this.board = new char[height][width];
        fillBoard();
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
//    //displays the current gems board saved in a file
//    public Grid createGrid(String fileName){
//        int rows = 4;
//        int columns = 4;
//        char [][] myArray = new char[rows][columns];
//        try {
//        Scanner sc = new Scanner(new BufferedReader(new BufferedReader(new FileReader(fileName))));
//        while(sc.hasNextLine()) {
//                String line = sc.nextLine();
//                for (int j=0; j<line.length(); j++) {
//                    myArray[i][j] = line.charAt(j);
//                }
//
//        }
//        System.out.println(Arrays.deepToString(myArray));
//    }catch (Exception e){
//            System.out.println("could not find file");
//        }
//        return
//
//    }

    //saves the current gems board to a file
    public void save(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            char text = ' ';
            for (int i = 0; i < this.board.length; i++){
                for (int j = 0; j < this.board[0].length; j++){
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

}
