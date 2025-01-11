//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Arrays;

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
        if(dog != null && !dogList.contains(dog)){
           return dogList.add(dog);
        }
        return false;
    }

    public boolean removeDog(Dog dog){
        return dogList.remove(dog);
    }

    public ArrayList<Dog> getDogs(){
        return new ArrayList<>(dogList);
    }

    @Override
    public String toString(){
        return "Owner " + name;
    }


    @Override
    public int compareTo(Owner otherName) {
        return this.name.compareTo(otherName.name);
    }
}
