//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Owner  implements Comparable<Owner> {
    private  final String name;
    private ArrayList<Dog> dogList = new ArrayList<>();



    public Owner(String name){
        this.name = name.trim().toUpperCase();
    }

    public String getName(){
        return name;
    }
    public boolean addDog(Dog dog){
        if(dog != null && !dogList.contains(dog) && dog.getOwner() == null){
            dogList.add(dog);
            return dog.setOwner();
        }
        return false;
    }

    public boolean removeDog(Dog dog){
        if(dog.getOwner() !=null && dogList.contains(dog)){
            return false;
        }
        if (dogList.remove(dog)){
            dog.setOwner(null);
            return true;
        }
        return false;

    }

    public ArrayList<Dog> getDogs(){
        DogTailNameComparator dogTailNameComparator = new DogTailNameComparator();
        DogSorter.sortDogs(dogTailNameComparator,dogList);
        return new ArrayList<>(Collections.unmodifiableList(dogList));
    }

    @Override
    public String toString(){
        return String.format("Owner{name='%s', dogs=%s}", name, dogList);
    }


    @Override
    public int compareTo(Owner otherName) {
        return this.name.compareTo(otherName.name);
    }
}
