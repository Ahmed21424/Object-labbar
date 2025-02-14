import java.awt.Color;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void reasonableSpeed(){
        Saab95 saab = new Saab95(Color.red, 2, 125, "Saab95");
        assertTrue(saab.getCurrentSpeed() < 200);
    }

    @Test
    void compass(){
        Saab95 saab = new Saab95(Color.red, 2, 125,"Saab95");

        for(int i = 0; i < 4; i++){
            saab.turnLeft();
        }
        for(int i = 0; i < 4; i++){
            saab.turnRight();
        }
        assertTrue(saab.getDirection() == Vehicle.Direction.North);
    }

    @Test
    void moveInRightDirection(){
        Saab95 saab = new Saab95(Color.red, 4, 135, "Saab95");
        saab.setCurrentSpeed(150);
        saab.move();
        assertEquals("(0.0, 150.0)", saab.getPositionString());
    }

    @Test
    void gasRange() {
        Vehicle saab = new Saab95(Color.RED, 2, 200, "Saab95");
        saab.gas(0.5);
        assertTrue(saab.getCurrentSpeed() > 0);
    }

    @Test
    void brakeSuitableRange(){
        var saab = new Saab95(Color.RED, 2, 200, "Saab95");
        double TempCurrentSpeed = saab.getCurrentSpeed();
        saab.brake(0.1);
        assertTrue(saab.getCurrentSpeed() <= TempCurrentSpeed);
    }

    @Test
    void rightColor() {
        var saab = new Saab95(Color.BLUE, 2, 200, "Saab95");
        saab.setColor(Color.RED);
        assertEquals(Color.RED, saab.getColor());
    }

    @Test
    void engineStartWorks(){
        var volvo = new Volvo240(Color.black,4,100,"Volvo240");
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() > 0);
    }

    @Test
    void canNotMoveWithFlakRaised(){
        Scania truck = new Scania(Color.BLUE, 2, 300, "Scania Truck");

        assertTrue(truck.canMove(), "Truck should now be able to move");
        truck.increaseFlakAngle();
        assertFalse(truck.canMove(), "Truck should NOT be able to move with flak raised");
    }

    @Test
    void flakAngleNotExceedingLimits(){
        var truck = new Scania(Color.BLACK, 2, 200, "Scania Truck");
        truck.setFlakAngle(10);
        for(int i = 0; i < 10; i++){
            truck.increaseFlakAngle();
        }
        assertTrue(truck.getFlakAngle() <= 70);
        for(int i = 0; i < 10; i++){
            truck.decreaseFlakAngle();
        }
        assertTrue(truck.getFlakAngle() >= 0);
    }
    @Test
    void loadingInRightOrder(){
        var carry = new CarCarrier(Color.DARK_GRAY, 2, 300,"Car Carrier");
        var truck = new Scania(Color.BLACK, 2, 200, "Scania Truck");
        var volvo = new Volvo240(Color.black,4,100,"Volvo240");
        var saab = new Saab95(Color.BLUE, 2, 200, "Saab95");

        carry.setRampDown();
        for(int i = 0; i < 2; i++){
            carry.loadVehicle(truck);
            carry.loadVehicle(volvo);
            carry.loadVehicle(saab);
            carry.unloadVehicle();
        }

        assertFalse(carry.getVehicleStack().contains(truck));
        assertEquals(2, carry.getVehicleStack().size());
    }
    @Test
    void vehiclesMoveWithCarry(){
        var carry = new CarCarrier(Color.DARK_GRAY, 2, 300,"Car Carrier");
        var volvo = new Volvo240(Color.black,4,100,"Volvo240");

        carry.setRampDown();
        carry.loadVehicle(volvo);
        carry.setRampUp();
        carry.setCurrentSpeed(10);
        carry.move();

        assertEquals(carry.getPositionString(), volvo.getPositionString());
    }

}
