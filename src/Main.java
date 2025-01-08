import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Steve","mops",1,10);
        Dog dog2 = new Dog("Rari","tax",7,9);
        Dog dog3 = new Dog("Lalla","bulldog",8,3);
        Dog dog4 = new Dog("Illo","chiwaua",2,4);
        Dog dog5 = new Dog("Steven","Great Dane",2,4);

        DogSorter sorter = new DogSorter();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        DogTailNameComparator tailNameComparator = new DogTailNameComparator();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
        System.out.println(DogSorter.sortDogs(tailNameComparator,dogs));
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("Index5" +dogs.get(4));
    }
}