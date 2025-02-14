import java.awt.*;

public class Scania extends TruckBase {

    private double flakAngle;
    private static final double length = 14;

    public Scania(Color color, int nrDoors, double enginePower, String modelName) {
        super(color, nrDoors, enginePower, modelName);
        this.flakAngle = 0.0;
    }


    public double getFlakAngle() {
        return this.flakAngle;
    }

    @Override
    public boolean canMove() {
        return flakAngle == 0; //
    }

    public void setFlakAngle(double angleAmount) { //Kanske inte behövs
        this.flakAngle = angleAmount;
    }

    public void increaseFlakAngle() {
        if (this.canAdjustPlatform()) {
            this.flakAngle = Math.min(70,this.flakAngle + 5);
        }

    }
    public void decreaseFlakAngle(){
        if (canAdjustPlatform()){
            this.flakAngle = Math.max(0,this.flakAngle - 5);
        }
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public double getLength(){
        return length;
    }


}
