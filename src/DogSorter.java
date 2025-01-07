import java.util.ArrayList;
import java.util.Comparator;

public class DogSorter {
    private static void swapDogs(ArrayList<Dog> dogs,int indexOne,int indexTwo) {
        if(indexOne > dogs.size() || indexTwo > dogs.size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Dog dogOne = dogs.get(indexOne);
        Dog dogTwo = dogs.get(indexTwo);

        dogs.set(indexOne, dogTwo);
        dogs.set(indexTwo, dogOne);

    }

    private static int nextDog(Comparator<Dog> dogComparator,ArrayList<Dog> dogs,int startIndex) {
        int size = dogs.size();
        int minIndex = startIndex;
        for(int i = startIndex; i < size; i++ )  {
            int comparison = dogComparator.compare(dogs.get(i),dogs.get(startIndex));
                if(comparison < 0) {
                    minIndex = i;
                }

        }
        return minIndex;
    }
}
