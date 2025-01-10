//Josef Lilja joli9146
import java.util.Comparator;

public class DogTailNameComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dogOne, Dog dogTwo) {
        int tailComparison = Double.compare(dogOne.getTailLength(), dogTwo.getTailLength());
        if (tailComparison != 0) {
            return tailComparison;
        }
        return dogOne.getName().compareTo(dogTwo.getName());
    }
}
