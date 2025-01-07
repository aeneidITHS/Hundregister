import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dogOne, Dog dogTwo) {
        return dogOne.getName().compareToIgnoreCase(dogTwo.getName());
    }
}
