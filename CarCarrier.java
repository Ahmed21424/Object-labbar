import java.awt.*;
import java.util.Stack;

public class CarCarrier extends TruckBase{

    public final static double length = 24.90;
    private boolean rampUp;
    private Stack<Vehicle> vehicleStack = new Stack<>();

    CarCarrier(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.rampUp = true;
    }

    public void setRampUp(){
        rampUp = true;
    }
    public void setRampDown(){
        if (this.getCurrentSpeed() == 0){
            rampUp = false;
        }
    }

    public boolean carInRange(Vehicle carToLoad){
        double deltaX = (carToLoad.x - this.x);
        double deltaY = (carToLoad.y - this.y);

        return  (deltaX * deltaX + deltaY * deltaY) < 100;// Ska vara innom 10 units

    }

    public boolean loadVehicle(Vehicle carToLoad){
        if (carToLoad.getLength() < 6 && !rampUp && vehicleStack.size() < 6 && carInRange(carToLoad)){
            carToLoad.setCurrentSpeed(0);
            carToLoad.setLoaded();
            vehicleStack.push(carToLoad);
            return true;
        }
        System.out.println("Vehicle cant be loaded");
        return false;
    }// Skall max kunna hÃ¥lla 6 bilar i taget

    public Vehicle unloadVehicle(){
        if (!rampUp) {
            vehicleStack.peek().setNotLoaded();
            return vehicleStack.pop();
        }
        System.out.println("Could not unload, Ramp needs to be down");
        return null;
    }

    public Stack<Vehicle> getVehicleStack() {
        return vehicleStack;
    }
    public double getLength(){
        return length;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void move(){
        if(!getIsLoaded()){
            if (rampUp) {
                super.move();
                for (Vehicle car : vehicleStack) {
                    car.x = this.x;
                    car.y = this.y;
                }
            }
            System.out.println("Must have ramp up to drive!");
        }else{
            loadedMsg();
        }
    }
}
