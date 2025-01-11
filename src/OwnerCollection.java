//Josef Lilja joli9146
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OwnerCollection {
  private Owner[] ownerArray;
  private int size;

  public OwnerCollection(){
     this.ownerArray = new Owner[20];
     this.size = 0;
  }
   private void ensureCapacity(int requiredCapicity){
       int count = 0;
       for (Owner o : ownerArray) {
           if (o != null) count++;
       }
       if (count >= ownerArray.length) {
           ownerArray = Arrays.copyOf(ownerArray, ownerArray.length+1);
       }
   }
   private void resize(int newCapicity){
     ownerArray = Arrays.copyOf(ownerArray, newCapicity);
   }

   private boolean containsOwnerWithName(String name){
      for (Owner o: ownerArray){
          if(o != null && o.getName().equals(name)){
              return true;
          }
      }
      return false;
   }
   public boolean addOwner(Owner owner){
      if(owner == null || containsOwnerWithName(owner.getName())){
          return false;
      }
     ensureCapacity(size+1);
     ownerArray[size++] = owner;
     return true;
   }

   private void removeIndex(int index){
     for(int i = index; i < size-1; i++){
        ownerArray[i] = ownerArray[i+1];
     }
     ownerArray[--size] = null;
     if (size <= ownerArray.length /4){
        resize(ownerArray.length / 2);
     }
   }
   public boolean removeOwner(Owner owner){
     if(size == 0){
        return false;
     }
     for (int i = 0; i< ownerArray.length; i++){
        if(ownerArray[i] != null && ownerArray[i].equals(owner) ){
           removeIndex(i);
           return true;
        }
     }
     return false;
   }

    public boolean removeOwner(String name){
        if(size == 0){
            return false;
        }
        if(name == null){
            return false;
        }
        for(int i = 0; i< ownerArray.length; i++){
            if (ownerArray[i] != null && ownerArray[i].getName().equals(name)){
                removeIndex(i);
                return true;
            }
        }
        return false;
    }

   public boolean containsOwner(String name){
     if(size == 0){
        return false;
     }
       for(int i = 0; i < size; i++){
           if(ownerArray[i] != null && ownerArray[i].getName().equals(name)){
               return true;
           }

       }
     return false;
   }
   public boolean containsOwner(Owner owner){
     if(size==0){
        return false;
     }
       for(int i = 0; i < size; i++){
           if(ownerArray[i] != null && ownerArray[i].equals(owner)){
               return true;
           }
     }
     return false;
   }

   public Owner getOwner(String name){
      if(name == null || ownerArray.length == 0){
          return null;
      }
      for(Owner owner: ownerArray){
          if(owner !=null && owner.getName().equals(name)){
              return owner;
          }
      }
      return null;
   }

   public ArrayList<Owner> getOwners(){
      ArrayList<Owner> owners = new ArrayList<>();
      for(int i = 0; i < size; i++){
          if (ownerArray[i] != null){
              owners.add(ownerArray[i]);
          }
      }
      owners.sort(Comparator.comparing(Owner::getName));
      return owners;
   }





}
