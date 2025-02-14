import java.util.ArrayList;

class Workshop <T extends Vehicle>{
    private final ArrayList<T> inventory;
    private final int capacity;
    private boolean isFixed;

    public Workshop(int capacity){
        this.capacity = capacity;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<T>getInventory(){
        return inventory;
    }

    public boolean addVehicle(T Vehicle){
        if (inventory.size() < capacity){
            inventory.add(Vehicle);
            return true;
        }
        return false;
    }

}
