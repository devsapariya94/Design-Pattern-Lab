interface Automobile {
    public void start();

    public void stop();

    public void accelerate(float acceleration);
}

class Car implements Automobile {
    @Override
    public void start() {
        System.out.println("Starting Car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Car");
    }

    @Override
    public void accelerate(float acceleration) {
        System.out.println("Accelerating Car by " + acceleration + " units");
    }
}

class AutomobileFacade {
    private Automobile car;

    public AutomobileFacade() {
        this.car = new Car();
    }

    public void startCar() {
        this.car.start();
    }

    public void stopCar() {
        this.car.stop();
    }

    public void accelerateCar(float acceleration) {
        this.car.accelerate(acceleration);
    }
}

public class FacadeDP {
    public static void main(String[] args) {
        AutomobileFacade carFacade = new AutomobileFacade();
        carFacade.startCar();

        carFacade.accelerateCar(10.0f);

        carFacade.stopCar();
    }
}
