public class Owner {
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

}
