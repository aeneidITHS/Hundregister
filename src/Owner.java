public class Owner  implements Comparable<Owner> {
    private  final String name;



    public Owner(String name){
        this.name = name.trim().toUpperCase();
    }

    public String getName(){
        return name;
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
