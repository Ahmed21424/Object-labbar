import java.awt.*;

public class Saab95 extends Vehicle{

    public final static double length = 5.60;
    private boolean turboOn;

    public Saab95(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.turboOn = false;
    }


    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double getLength(){
        return length;
    }


    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
