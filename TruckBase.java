import java.awt.*;

public abstract class TruckBase extends Vehicle{


    public TruckBase(Color color, int nrDoors, double enginePower, String modelName) {
        super(color, nrDoors, enginePower, modelName);
    }

    public boolean canMove(){
        return true;
    }

    public boolean canAdjustPlatform() {
        return this.getCurrentSpeed() == 0;
    }

    @Override
    public void gas(double amount) {
        if (this.canMove()) {
            super.gas(amount);
        }
    }

}
