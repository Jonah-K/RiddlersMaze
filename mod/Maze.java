
public class Maze {

    //INSTANCE VARIABLES
    private Position _flash;

    public boolean[][] _maze;

    private Position _start;

    private Position _end;

    private static int[] startRow = new int[] { 9, 8, 5, 9, 8, 3, 13, 13, 8 };

    private static int[] startCol = new int[] { 8, 13, 1, 2, 2, 13, 17 };

    private static int[] endRow = new int[] { 0, 1, 9, 5, 8, 2, 5, 13, 13, 8 };

    private static int[] endCol = new int[] { 12, 12, 8, 1, 2, 2, 13, 17 };

    static int x = (int)(Math.random() * 9.0D);

    static int xx = (int)(Math.random() * 9.0D);

    private static final int PLAYER_START_ROW = 6;

    private static final int PLAYER_START_COL = 9;

    private static int PLAYER_END_ROW = 12;

    private static int PLAYER_END_COL = 17;

    private static int[] flashRow = new int[] { 5, 5, 2, 13, 10, 11, 8 };

    private static int[] flashCol = new int[] { 1, 17, 8, 11, 9, 5, 1 };

    static int z = (int)(Math.random() * 7.0D);

    private static final int FLASHBACK_ROW = flashRow[z];

    private static final int FLASHBACK_COL = flashCol[z];


    //GETTERS
    public Position getStart() {
        return this._start;
    }

    public Position getEnd() {
        return this._end;
    }

    public boolean[][] getMaze() {
        return this._maze;
    }

    //CONSTRUCTOR
    public Maze() {
        boolean[][] maze = {
                {
                        true, true, true, true, true, true, true, true, true, true,
                        true, true, true, true, true, true, true, true }, { true, true, true, true, true, true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true },
                {
                        true, true, true, true, true, true, true, true, true, true,
                        true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true }, { true, true, true, true }, {
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true } };
        this._maze = maze;
        this._start = new Position(6, 9);
        this._end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        this._flash = new Position(FLASHBACK_ROW, FLASHBACK_COL);
    }


}
