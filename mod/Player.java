

public class Player {
    //INTANCE VARIABLES
    public Position _curPos;


    private boolean _isAlive = true;

    //GETTERS
    public Position getPosition() {
        return this._curPos;
    }

    public boolean isAlive() {
        return this._isAlive;
    }


    //sets the player to being dead
    public void killPlayer() {
        this._isAlive = false;
    }


//Constructor
    public Player(Maze z) {
        this._curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
    }

    //moves the player on the maze, depending on the avalible postions and the direction choosen
    public boolean move(Direction d, Maze z) {
        if (d == Direction.North) {
            if (this._curPos.getRow() - 1 >= 0 && !z.getMaze()[this._curPos.getRow() - 1][this._curPos.getCol()]) {
                this._curPos = new Position(this._curPos.getRow() - 1, this._curPos.getCol());
                return true;
            }
        } else if (d == Direction.South) {
            if (this._curPos.getRow() + 1 < (z.getMaze()).length && !z.getMaze()[this._curPos.getRow() + 1][this._curPos.getCol()]) {
                this._curPos = new Position(this._curPos.getRow() + 1, this._curPos.getCol());
                return true;
            }
        } else if (d == Direction.East) {
            if (this._curPos.getCol() + 1 < (z.getMaze()[this._curPos.getRow()]).length &&
                    !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() + 1]) {
                this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() + 1);
                return true;
            }
        } else if (this._curPos.getCol() - 1 >= 0 && !z.getMaze()[this._curPos.getRow()][this._curPos.getCol() - 1]) {
            this._curPos = new Position(this._curPos.getRow(), this._curPos.getCol() - 1);
            return true;
        }
        return false;
    }
}

