

import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StringMap {

    //INSTANCE VARIABLES
    private JPanel _Maze = new JPanel(new GridLayout(1, 1));

    JLabel[][] arr = new JLabel[14][18];

    public int rCnt = 0;

    private JFrame dab;

    public boolean blackOutTime = false;

    private String _map;

    private Icon w;

    private Icon d;

    private Icon e;

    private Icon cs;

    private Icon pu;

    private Icon pp;

    private Icon bl;

    //CONSTRUCTOR
    public StringMap() {
        this.w = new ImageIcon(getClass().getResource("white.png"));
        this.d = new ImageIcon(getClass().getResource("ben.jpg"));
        this.e = new ImageIcon(getClass().getResource("house.jpg"));
        this.cs = new ImageIcon(getClass().getResource("blue.png"));
        this.pu = new ImageIcon(getClass().getResource("red s.png"));
        this.pp = new ImageIcon(getClass().getResource("dark blues.png"));
        this.bl = new ImageIcon(getClass().getResource("black.png"));
        this._map = "";
    }


    //GETTER
    public JPanel getMaze() {
        return this._Maze;
    }

    //Updates the map with each icon depending on whether it is true or false in the position
    public JPanel updateMap(Player p, Maze z) {
        this._Maze = new JPanel(new GridLayout(14, 18));
        JPanel _Maze = new JPanel(new GridLayout(14, 18));
        _Maze.setFocusable(false);
        for (int r = 0; r < (z.getMaze()).length; r++) {
            for (int c = 0; c < (z.getMaze()[r]).length; c++) {
                if (z.getMaze()[r][c]) {
                    this.arr[r][c] = new JLabel(this.pp);
                    _Maze.add(this.arr[r][c]);
                } else if (r == z.getEnd().getRow() &&
                        c == z.getEnd().getCol()) {
                    this.arr[r][c] = new JLabel(this.e);
                    _Maze.add(this.arr[r][c]);
                } else if (r == p.getPosition().getRow() &&
                        c == p.getPosition().getCol()) {
                    this.arr[r][c] = new JLabel(this.d);
                    _Maze.add(this.arr[r][c]);
                } else {
                    this.arr[r][c] = new JLabel(this.pu);
                    _Maze.add(this.arr[r][c]);
                }
            }
        }
        return _Maze;
    }
}
