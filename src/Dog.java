public class Dog {
    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;

    public Dog(String name, String breed, int age, int weight){
        this.name = name.trim().toUpperCase();
        this.breed = breed.trim().toUpperCase();
        this.age = age;
        this.weight = weight;
        this.tailLength = calculateTailLength(breed,age,weight);
    }

    private double calculateTailLength(String breed,int age, int weight){
        if (breed.equalsIgnoreCase("DACHSHUND") || breed.equalsIgnoreCase("TAX")){
            return 3.7;
        }
        else {
            return (double) age * ((double) weight / 10);
        }
    }

    public void updateAge(int years){
        // Prevent decreasing the age below 0 (no negative age allowed)
        if (years < 0) {
            return; // Simply return without updating the age if trying to decrease it
        }
        // If the resulting age exceeds Integer.MAX_VALUE, cap it at Integer.MAX_VALUE
        if (years == Integer.MAX_VALUE){
            return;
        }
        this.age += years;


        // Recalculate the tail length
        this.tailLength = calculateTailLength(this.breed, this.age, this.weight);
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public double getTailLength() {
        return tailLength;
    }

    @Override
    public String toString() {
        return String.format("Dog{name='%s', breed='%s', age=%d, weight=%d, tailLength=%.1f}",
                name, breed, age, weight, tailLength);
    }
}
