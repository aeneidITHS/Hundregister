//Josef Lilja joli9146
import java.util.Comparator;

public class DogTailComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dogOne, Dog dogTwo) {
        return Double.compare(dogOne.getTailLength(), dogTwo.getTailLength());
    }
}
