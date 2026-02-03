package abstaraction;
interface Vehicle{
    double maxSpeed();
    void wheelCount();
}
class Bike implements Vehicle {
    int wheel =2;
    public double maxSpeed() {
        return 150;
    }
    public void wheelCount() {
        System.out.println("Number of wheels: "+wheel);
    }
}
class Car implements Vehicle {
    int wheel = 4;

    @java.lang.Override
    public double maxSpeed() {
        return 280;
    }
}
