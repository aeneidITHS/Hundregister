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
        if(dog == null || dogList.contains(dog)){
            return false;
        }
        if(dog.getOwner() != null){
            return false;
        }
            this.dogList.add(dog);
            return true;


    }

    public boolean removeDog(Dog dog){
        if(dog == null || !dogList.contains(dog)){
            return false;
        }
        if(dog.getOwner() == null){
            return false;
        }
        if(dog.getOwner() != this){
            return false;
        }
        if(dog.getOwner() != null){
            return false;
        }

        dogList.remove(dog);
        return true;


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