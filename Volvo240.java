import java.awt.*;


public class Volvo240 extends Vehicle{

    public final static double length = 4.80;
    public final static double trimFactor = 1.25;

    public Volvo240(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
    }


    public double getLength(){
        return length;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
