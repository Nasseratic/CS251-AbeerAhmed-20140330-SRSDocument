import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 */
class Student extends Account {

    Vector<Double> array_scores = new Vector<>();
    void add_score(double x){
        array_scores.add(x);
    }

    @Override
    String verify() {
        return "Student";
    }
}
