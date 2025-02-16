import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Saab95 saab = new Saab95(Color.red,2,200,"Saab95");
        Saab95 testsaab = new Saab95(Color.red,4,125,"Saab95");
        Volvo240 volvo = new Volvo240(Color.black,4,100,"Volvo240");
        Volvo240 testvolvo = new Volvo240(Color.black,4,100,"Volvo240");
        CarCarrier carcarry = new CarCarrier(Color.black,2,130,"Beast");
        Scania scania = new Scania(Color.blue, 4,190,"Scania2001");
        Workshop<Volvo240> volvoWork = new Workshop<>(3);
        Workshop<Vehicle> allWork = new Workshop<>(4);





        System.out.println("Initial speed: " + saab.getCurrentSpeed());

        saab.gas(0.5);
        System.out.println("After gas: " + saab.getCurrentSpeed());

        saab.brake(0.3);
        System.out.println("After brake: " + saab.getCurrentSpeed());

        saab.brake(1);
        System.out.println("After brake: " + saab.getCurrentSpeed());

        saab.setCurrentSpeed(198);
        saab.gas(1);
        saab.gas(1);
        saab.gas(1);
        System.out.println("After excessive gas: " + saab.getCurrentSpeed());
        saab.gas(1.6);

        System.out.println("Tester Under");


        carcarry.setRampDown();
        carcarry.loadVehicle(saab);
        carcarry.loadVehicle(volvo);
        carcarry.setCurrentSpeed(120);
        carcarry.move();
        carcarry.move();
        carcarry.turnRight();
        carcarry.incrementSpeed(1);
        carcarry.move();
        System.out.println(saab.getPositionString());
        System.out.println(volvo.getPositionString());
        System.out.println(carcarry.getPositionString());
        System.out.println(testsaab.getPositionString());
        carcarry.unloadVehicle();

        volvoWork.addVehicle(volvo) ;
        volvoWork.addVehicle(testvolvo);
        //volvoWork.addVehicle(saab);

        allWork.addVehicle(volvo);
        allWork.addVehicle(carcarry);
        allWork.addVehicle(scania);
        System.out.println(allWork.getInventory());


        System.out.println(volvoWork.getInventory());
        allWork.removeVehicle(scania);

        CarCarrier testloadCarry = new CarCarrier(Color.red,3,190,"LoadCarrytest");
        Volvo240 testlaodvolvo = new Volvo240(Color.black, 3,140,"LoadVolvotest");

        testloadCarry.setRampDown();
        testloadCarry.loadVehicle(testlaodvolvo);
        testlaodvolvo.move();
        testloadCarry.unloadVehicle();
        testlaodvolvo.move();












    }
}
