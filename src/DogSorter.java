//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Comparator;


public class DogSorter {
    private static int swapCounter;

    private static void swapDogs(ArrayList<Dog> dogs,int indexOne,int indexTwo) {
        if(indexOne > dogs.size() || indexTwo > dogs.size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Dog dogOne = dogs.get(indexOne);
        Dog dogTwo = dogs.get(indexTwo);

        dogs.set(indexOne, dogTwo);
        dogs.set(indexTwo, dogOne);
        System.out.println("Dog swapped at " + indexOne + " and " + indexTwo);

        swapCounter++;



    }

    private static int nextDog(Comparator<Dog> dogComparator,ArrayList<Dog> dogs,int startIndex) {
        int size = dogs.size();
        int minIndex = startIndex;
        for (int i = startIndex; i <= size - 1; i++) {
            if (dogComparator.compare(dogs.get(i), dogs.get(minIndex)) < 0) {
                minIndex = i;
            }
        }
        return minIndex;


    }

    public static int sortDogs(Comparator<Dog> dogComparator,ArrayList<Dog> dogs) {
        if(dogs.isEmpty()){
            return 0;
        }
        if(dogs.size()==1){
            return 0;
        }
        swapCounter = 0;
        for (int i = 0; i < dogs.size(); i++) {
            int minIndex = nextDog(dogComparator,dogs,i);
            if(minIndex != i) {
                swapDogs(dogs,minIndex,i);
            }
        }
        return swapCounter;

    }


}
