public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.updateBoard(9, "X");
        board.updateBoard(9, "O");
        board.updateBoard(8, "X");
    }
}
