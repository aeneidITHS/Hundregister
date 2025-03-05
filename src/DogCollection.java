//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DogCollection {
   private  ArrayList<Dog> dogs = new ArrayList<Dog>();

    public boolean addDog(Dog dog){
        if(containsDog(dog.getName())){
            return false;
        }

        return dogs.add(dog);
    }
    private boolean checkIfEmpty(){
      return dogs.isEmpty();
    }
    public boolean removeDog(String name){
        if (checkIfEmpty()){
            return false;
        }

        for (Dog i: dogs){
            if (i.getName().equals(name) && i.getOwner() ==null){
               return dogs.remove(i);
            }
        }
        return false;
    }
    public boolean removeDog(Dog dog){
        if (checkIfEmpty()){
            return false;
        }
        if(dog.getOwner() != null){
            return false;
        }
        for(Dog i: dogs){
            if(dog.getName().equals(i.getName()) && i.getOwner() == null){
                return dogs.remove(i);
            }
        }
        return false;
    }
    private int getDogIndex(String name){
        for(int i=0; i<dogs.size();i++ ){
                if(dogs.get(i).getName().equals(name)){
                    return i;
                }
            }
        return -1;
        }


    public boolean containsDog(String name){
        for(Dog i: dogs) {
            if(i.getName().equals(name)){
                return true;
        }
        }
        return false;
    }
    public boolean containsDog(Dog dog){
        return dogs.contains(dog);
    }
    public Dog getDog(String name){
        int index = getDogIndex(name);
        if(index >= 0 ){
           return dogs.get(index);
        }
        return null;
    }

    public ArrayList<Dog> getDogs(){
        ArrayList<Dog> copyOfDogs = new ArrayList<>(dogs);
        DogNameComparator comparator = new DogNameComparator();
        return dogSorter(comparator,copyOfDogs);
    }
    private ArrayList<Dog> dogSorter(Comparator<Dog> dogComparator, ArrayList<Dog> dogList){
      DogSorter.sortDogs(dogComparator,dogList);
      return new ArrayList<>(Collections.unmodifiableList(dogList));
    }


    public ArrayList<Dog> getDogWithMinTail(double tailLength){
        ArrayList<Dog> filteredList = new ArrayList<>();
        DogTailNameComparator comparator = new DogTailNameComparator();

        for(Dog i: dogs){
            if (i.getTailLength()>= tailLength){
                filteredList.add(i);
            }
        }
        return dogSorter(comparator,filteredList);
    }



}
