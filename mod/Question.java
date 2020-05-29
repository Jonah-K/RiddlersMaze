

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    //INSTANCE VARIABLES WITH POSITION OF EACH QUESTION
    Position[] ques1 = new Position[] { new Position(6, 8), new Position(7, 8), new Position(8, 8), new Position(9, 8), new Position(10, 8), new Position(11, 8) };

    Position ques1Place;

    Position[] ques2 = new Position[] { new Position(11, 1), new Position(10, 1), new Position(9, 1), new Position(8, 1), new Position(7, 1), new Position(6, 1) };

    Position ques2Place;

    Position[] ques3 = new Position[] { new Position(1, 5), new Position(1, 6), new Position(1, 7), new Position(1, 8), new Position(1, 10), new Position(1, 11) };

    Position ques3Place;

    Position[] ques4 = new Position[] { new Position(2, 14), new Position(3, 14), new Position(4, 14), new Position(5, 14), new Position(6, 14), new Position(7, 14) };

    Position ques4Place;

    Position[] ques5 = new Position[] { new Position(12, 16), new Position(12, 15), new Position(12, 14), new Position(12, 13), new Position(12, 12), new Position(12, 11) };

    Position ques5Place;

    ArrayList<String> ques = new ArrayList<>();

    public ArrayList<String> usedQues = new ArrayList<>();

    int x;
//CONSTRUCTOR
    public Question() {
        setQuestions();
        int x = (int)(Math.random() * 6.0D);
        int xx = (int)(Math.random() * 6.0D);
        int xxx = (int)(Math.random() * 6.0D);
        int xxxx = (int)(Math.random() * 6.0D);
        int xxxxx = (int)(Math.random() * 6.0D);
        this.ques1Place = this.ques1[x];
        this.ques2Place = this.ques2[xx];
        this.ques3Place = this.ques3[xxx];
        this.ques4Place = this.ques4[xxxx];
        this.ques5Place = this.ques5[xxxxx];
    }
    //puts the question into the arraylist and then adds random questions to the maze
    public void setQuestions() {
        addQuestions();
        for (int i = 0; i < 6; i++) {
            this.x = (int)(Math.random() * 12.0D);
            this.usedQues.add(this.ques.get(i));
        }
        Collections.shuffle(this.usedQues);
    }
//adds the questions to the array list
    public void addQuestions() {
        this.ques.add("Who is the better Hartog, Alexis or Nick?");
        this.ques.add("____ - sex people should not be allowed to marry");
        this.ques.add("The known pedophile, ________ did not kill himself in prison? ( Last name only) ");
        this.ques.add("_____ brutality is not real");
        this.ques.add("Should there be a genocide to eliminate furries?");
        this.ques.add("Churches have full control over the government (True or False) ");
        this.ques.add("_____ are the most oppresed race");
        this.ques.add("The ____ landing and the assassination of JFK were faked");
        this.ques.add("What color of skin do you believe to be superior?");
        this.ques.add("What is your stance on abortion? (Pro-Life or Pro-Choice");
        this.ques.add("_______ change is not real and the enviorment is fine");
        this.ques.add("______ is not  a legitimate state in the Middle East");
        Collections.shuffle(this.ques);
    }
    //GETTERS
    public Position getPosition1() {
        return this.ques1Place;
    }

    public Position getPosition2() {
        return this.ques2Place;
    }

    public Position getPosition3() {
        return this.ques3Place;
    }

    public Position getPosition4() {
        return this.ques4Place;
    }

    public Position getPosition5() {
        return this.ques5Place;
    }

    //METHODS TO GET RID OF QUESTIONS
    public void killQues1() {
        this.ques1Place = new Position(0, 0);
    }

    public void killQues2() {
        this.ques2Place = new Position(0, 0);
    }

    public void killQues3() {
        this.ques3Place = new Position(0, 0);
    }

    public void killQues4() {
        this.ques4Place = new Position(0, 0);
    }

    public void killQues5() {
        this.ques5Place = new Position(0, 0);
    }
}
