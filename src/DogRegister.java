//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Scanner;


public class DogRegister {
    private InputReader inputReader;
    private DogCollection dogCollection;
    private OwnerCollection ownerCollection;

    public DogRegister(InputReader inputReader,DogCollection dogCollection,OwnerCollection ownerCollection){
        this.inputReader = inputReader;
        this.dogCollection = dogCollection;
        this.ownerCollection = ownerCollection;
    }
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OwnerCollection ownerCollection = new OwnerCollection();
        DogCollection dogCollection = new DogCollection();
        DogRegister dogRegister = new DogRegister(inputReader, dogCollection, ownerCollection);
        dogRegister.registerLoop();


    }
        public void registerLoop(){
        boolean running = true;
        System.out.println("Welcome to the dog register");

        while (running) {

            String command = inputReader.readLine("Command?>");

            switch (command.toLowerCase()) {
                case "exit":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                case "register new owner":
                    String newOwnerName = getValidName(inputReader, "Enter owner name?>");

                    if(ownerCollection.containsOwner(newOwnerName)){
                        System.out.println("The owner" + newOwnerName + "already exists");
                        break;
                    }
                    Owner owner = new Owner(newOwnerName);
                    ownerCollection.addOwner(owner);
                    System.out.println("The owner " + newOwnerName + "has been added to the register");
                    break;

                case "remove owner":
                    String removeOwnerName = getValidName(inputReader,"Enter owner name?>");
                    if(!ownerCollection.containsOwner(removeOwnerName)){
                        System.out.println("The owner "+ removeOwnerName + "doesn't exist");
                        break;
                    }
                    Owner removedOwner = ownerCollection.getOwner(removeOwnerName);
                    ArrayList<Dog> dogsToRemove = removedOwner.getDogs();
                    for (dogsToRemove:
                         Dog dog){
                        dog.setOwner();
                    }
                    break;

                case "register new dog":
                    String newDogName = getValidName(inputReader, "Enter dog name?>");
                    if(dogCollection.containsDog(newDogName)){
                        System.out.println("The dog "+ newDogName + "already exists");
                        break;
                    }
                    String newDogBreed = getValidName(inputReader,"Enter dog name?>");
                    int newDogAge = inputReader.readInt("Enter dog age?>");
                    int newDogWeight = inputReader.readInt("Enter dog weight?>");
                    Dog newDog = new Dog(newDogName,newDogBreed,newDogAge,newDogWeight);
                    dogCollection.addDog(newDog);
                    break;

                case "remove dog":
                    if(dogCollection.getDogs().isEmpty()){
                        System.out.println("No dogs in register");
                        break;
                    }
                    String removedDogName = getValidName(inputReader,"Enter dog name?>");
                    if(!dogCollection.containsDog(removedDogName)){
                        System.out.println("The dog " + removedDogName + "doesn't exist");
                        break;
                    }
                    Dog removedDog = dogCollection.getDog(removedDogName);
                    if(removedDog.getOwner() != null){
                        removedDog.setOwner(null);
                    }
                dogCollection.removeDog(removedDog);
                    break;

                case "list dogs":
                    if(dogCollection.getDogs().isEmpty()){
                        System.out.println("No dogs in register");
                        break;
                    }
                    double minTailLength = inputReader.readDouble("Enter minimum tail length?>");
                    System.out.println("Name  " + "Breed  "+ "Age  " + "Weight  " + "Owner" );
                    System.out.println("=====================================================");
                    for (Dog i : dogCollection.getDogsWithTail(minTailLength)
                         ) {
                        System.out.println(i.toString());
                    }
                    break;

                case "list owners":
                    if(ownerCollection.getOwners().isEmpty()){
                        System.out.println("No owners in register");
                        break;
                    }
                    System.out.println("Name   " + "Dogs   ");
                    System.out.println("====================================");
                    for (Owner i: ownerCollection.getOwners()
                         ) {
                        System.out.println(i.getName());
                        for (Dog j : i.getDogs()){
                            System.out.print(j.getName());
                        }
                    }
                    break;

                case "increase age":
                    if(dogCollection.getDogs().isEmpty()){
                        System.out.println("No dogs in register");
                        break;
                    }
                    String agedUpDog = getValidName(inputReader,"Enter dog name?>");
                    if(!dogCollection.containsDog(agedUpDog)){
                        System.out.println("The dog " + agedUpDog + "doesn't exist");
                        break;
                    }
                    dogCollection.getDog(agedUpDog).updateAge(1);
                    break;

                case "give dog to owner":
                    if(dogCollection.getDogs().isEmpty()){
                        System.out.println("No dogs in register");
                        break;
                    }
                    if(ownerCollection.getOwners().isEmpty()){
                        System.out.println("No owners in register");
                        break;
                    }
                    String





                default:
                    System.out.println("Error: Unknown command");
                    break;
            }
        }

        inputReader.close();




    }
    private static void registerNewOwner(InputReader inputReader){

    }
    private static void removeOwner(InputReader inputReader){

    }
    private static void registerNewDog(InputReader inputReader){

    }
    private static void removeDog(InputReader inputReader){

    }
    private static void increaseDogAge (InputReader inputReader){

    }
    private static void registerNewOwner(InputReader inputReader){

    }

    private static String getValidName(InputReader inputReader, String prompt){
        String name;
        while (true){
            name = inputReader.readLine(prompt).trim();
            if(!name.isEmpty()){
                return name;
            }
            System.out.println("Error: A blank string is not allowed, try again");
        }
    }


    }
