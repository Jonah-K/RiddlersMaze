
public class Position {
    //INSTANCE VARIABLES
    private int _row;

    private int _col;


    //GETTERS
    public int getRow() {
        return this._row;
    }

    public int getCol() {
        return this._col;
    }

    //CONSTRUCTORS
    public Position(int r, int c) {
        this._row = r;
        this._col = c;
    }
}
