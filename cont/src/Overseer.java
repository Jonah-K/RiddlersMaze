
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Overseer {

    //INSTANCE VARIABLES
    private Player _p;
    private Maze _z;
    private StringMap _s;
    private Window _w;
    private Question _q;
    String ans;
    int shutCnt;
    String name = System.getProperty("user.name");
    int z;
    Runtime runtime = Runtime.getRuntime();
    private static final String[] BUTTONS = new String[] { "UP", "DOWN", "LEFT", "RIGHT", "EXIT", "HELP" };
    private static final String[] Loop = new String[] { "Yes", "No" };


    //CONSTRUCTOR
    public Overseer() throws IOException, InterruptedException {
        this._w = new Window();
        this._q = new Question();
        this._z = new Maze();
        this._s = new StringMap();
        this._p = new Player(this._z);

        int y = this._w.option(Loop, "WARNING: This program will cause your computer to shut off if you get a question wrong and cannot either exit the maze or\nget a question correct or press the exit button. If you consent to playing this press YES, if not then press NO so the program will close.");
        Consent(y);
        this._w.msg("Welcome " + this.name + " to the Presidential Race for the 2020 election. You are Ben Shapiro, the nominee for the Republican Party. Follow" + "\n" +
                "the trail to encounter important political issues, and answer them honestly as Ben Shapiro would. Answering questions correct will grow your follower base" + "\n" +
                "but, beware as answering questions wrong will cuase you to lose supporters and be afflicted with other penalties. Progress your way through the labyrinth to" + "\n" +
                "secure your spot in the White House and become President of the United States. But beware, answering questions wrong will cause you to lose" + "\n" +
                "supporters and be afflicted with other penalties. Good Luck in the upcoming elections.");
        getPlayerMovement();
    }

    //gets what direction the player wants to move in, by displaying mutiple buttons
    public void getPlayerMovement() throws IOException, InterruptedException {
        while (this._p.isAlive()) {
            int x = this._w.option((Object[])BUTTONS, this._s.updateMap(this._p, this._z));
            Help(x);
            move(x);
            gamecheck();
        }
    }
    //moves the player based on the direction on the maze
    public void move(int x) throws IOException {
        if (!this._p.move(getPlayerDirection(x), this._z))
            this._w.msg("Don't try to leave the path, you'll let down your supporters and give those libtards a chance at the presidency");
    }

    //Assigns each button to a direction, buttons will be labled with Up, Down, Left, Right. If the user cliicks exit any shutdown processes are stopped
    public Direction getPlayerDirection(int x) throws IOException {
        if (x == 0)
            return Direction.North;
        if (x == 1)
            return Direction.South;
        if (x == 2)
            return Direction.West;
        if (x == 3)
            return Direction.East;
        Process p = this.runtime.exec("shutdown -a");
        System.exit(0);
        return null;
    }

    //checks if the players position is on one of the question or at the end. If the player is on a question, then display a input box and check the answer
    public void gamecheck() throws IOException, InterruptedException {
        int x = 1;
        if (this.z < 0)
            this.z = 0;
        if (this._p.getPosition().getRow() == this._z.getEnd().getRow() && this._p.getPosition().getCol() == this._z.getEnd().getCol()) {
            this._p.killPlayer();
            this._w.msg("You win! You've managed to defeat all the libtards and become the President of the U.S. Good luck in the coming year\n You finished with " + this.z + ",000 supporters");
            Process p = this.runtime.exec("shutdown -a");
            System.exit(0);
        }
        if (this._p.getPosition().getRow() == this._q.getPosition1().getRow() && this._p.getPosition().getCol() == this._q.getPosition1().getCol()) {
            this.ans = JOptionPane.showInputDialog(this._q.usedQues.get(0));
            this._q.killQues1();
            checkAnswer();
        }
        if (this._p.getPosition().getRow() == this._q.getPosition2().getRow() && this._p.getPosition().getCol() == this._q.getPosition2().getCol()) {
            this.ans = JOptionPane.showInputDialog(this._q.usedQues.get(1));
            this._q.killQues2();
            checkAnswer();
        }
        if (this._p.getPosition().getRow() == this._q.getPosition3().getRow() && this._p.getPosition().getCol() == this._q.getPosition3().getCol()) {
            this.ans = JOptionPane.showInputDialog(this._q.usedQues.get(2));
            this._q.killQues3();
            checkAnswer();
        }
        if (this._p.getPosition().getRow() == this._q.getPosition4().getRow() && this._p.getPosition().getCol() == this._q.getPosition4().getCol()) {
            this.ans = JOptionPane.showInputDialog(this._q.usedQues.get(3));
            this._q.killQues4();
            checkAnswer();
        }
        if (this._p.getPosition().getRow() == this._q.getPosition5().getRow() && this._p.getPosition().getCol() == this._q.getPosition5().getCol()) {
            this.ans = JOptionPane.showInputDialog(this._q.usedQues.get(4));
            this._q.killQues5();
            checkAnswer();
        }
    }

    //creates a help button at the bottom of the screen that tips to the player
    public void Help(int x) throws IOException, InterruptedException {
        if (x == 5) {
            this._w.msg("Use the buttons at the bottom of the screen to move through the path and encounter questions to answer. Answering questions correctly will allow you to\ngrow your fanbase and further your chances of becoming the president. If you get the problem wrong, you'll lose some supporters and be hit by another penalty\nProgress to the end with your supporters to be elected president and reign over the U.S");
            getPlayerMovement();
        }
    }
//checks what the question is, and the once the question is determined, check it against the answer, if the answer is correct add a random amount of followers and stops any shutdowns, if incorrect shutdowns the computer in 15 seconds
    public void checkAnswer() throws IOException, InterruptedException {
        int x = (int)(Math.random() * 1000.0D);
        int y = (int)(Math.random() * 1000.0D);
        this.shutCnt = 0;
        for (int i = 0; i < this._q.usedQues.size(); i++) {
            if (((String)this._q.usedQues.get(i)).equals("Who is the better Hartog, Alexis or Nick?") && this.ans.equalsIgnoreCase("Alexis") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                Process process = this.runtime.exec("shutdown -a");
                this.z += x;
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("____ - sex people should not be allowed to marry") && this.ans.equalsIgnoreCase("Same") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("The known pedophile, ________ did not kill himself in prison? ( Last name only) ") && this.ans.equalsIgnoreCase("Epstein") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("_____ brutality is not real") && this.ans.equalsIgnoreCase("Police") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("Should there be a genocide to eliminate furries?") && this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000\t supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("Churches have full control over the government (True or False) ") && this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("_____ are the most oppresed race") && this.ans.equalsIgnoreCase("Gamers") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("The ____ landing and the assassination of JFK were faked") && this.ans.equalsIgnoreCase("Moon") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("What color of skin do you believe to be superior?") && this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("What is your stance on abortion? (Pro-Life or Pro-Choice") && this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("No") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equals("_______ change is not real and the enviorment is fine") && this.ans.equalsIgnoreCase("Climate") && !this.ans.equalsIgnoreCase("Yes") && !this.ans.equalsIgnoreCase("True") && !this.ans.equalsIgnoreCase("White") && !this.ans.equalsIgnoreCase("Pro-Life") && !this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
            if (((String)this._q.usedQues.get(i)).equalsIgnoreCase("______ is not  a legitimate state in the Middle East") && this.ans.equalsIgnoreCase("Israel")) {
                this._w.msg("Correct, you gained " + x + ",000 supporters" + "\n" + "#JewsForPalestine");
                x = (int)(Math.random() * 100.0D);
                this.z += x;
                Process process = this.runtime.exec("shutdown -a");
                getPlayerMovement();
            }
        }
        this._w.msg("That is wrong " + this.name + " , you lost " + y + ",000 supporters");
        this._w.msg("Because you got a question wrong, your computer will shutdown in 15 seconds. Complete the labrythin or get a question\ncorrect or click the exit button to stop this from happening");
        y = (int)(Math.random() * 1000.0D);
        this.z -= y;
        Process p = this.runtime.exec("shutdown -s -t 15\t");
        this.shutCnt++;
    }
    //displays message if the person is ok with the game being able to shutdown your computer
    public void Consent(int y) {
        if (y == 1)
            System.exit(0);
    }
}

