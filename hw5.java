import java.util.Scanner;

interface IVehicle {
    void drive();
    void refuel();
}

class Car implements IVehicle {
    private String brand;
    private String model;
    private String fuelType;

    public Car(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car: " + brand + " " + model);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a car with: " + fuelType);
    }
}

class Motorcycle implements IVehicle {
    private String type;
    private int engineCapacity;

    public Motorcycle(String type, int engineCapacity) {
        this.type = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Riding a " + type + " motorcycle with engine capacity: " + engineCapacity + "cc");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a motorcycle");
    }
}

class Truck implements IVehicle {
    private int loadCapacity;
    private int axles;

    public Truck(int loadCapacity, int axles) {
        this.loadCapacity = loadCapacity;
        this.axles = axles;
    }

    @Override
    public void drive() {
        System.out.println("Driving a truck with load capacity: " + loadCapacity + " tons and " + axles + " axles.");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a truck");
    }
}

class Bus implements IVehicle {
    private int seatingCapacity;

    public Bus(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Driving a bus with seating capacity: " + seatingCapacity + " passengers.");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a bus");
    }
}
abstract class VehicleFactory {
    public abstract IVehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    private String brand;
    private String model;
    private String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public IVehicle createVehicle() {
        return new Car(brand, model, fuelType);
    }
}

class MotorcycleFactory extends VehicleFactory {
    private String type;
    private int engineCapacity;

    public MotorcycleFactory(String type, int engineCapacity) {
        this.type = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public IVehicle createVehicle() {
        return new Motorcycle(type, engineCapacity);
    }
}

class TruckFactory extends VehicleFactory {
    private int loadCapacity;
    private int axles;

    public TruckFactory(int loadCapacity, int axles) {
        this.loadCapacity = loadCapacity;
        this.axles = axles;
    }

    @Override
    public IVehicle createVehicle() {
        return new Truck(loadCapacity, axles);
    }
}

class BusFactory extends VehicleFactory {
    private int seatingCapacity;

    public BusFactory(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public IVehicle createVehicle() {
        return new Bus(seatingCapacity);
    }
}

public class VehicleCreationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose vehicle type (car, motorcycle, truck, bus): ");
        String vehicleType = scanner.nextLine();

        VehicleFactory factory = null;
        IVehicle vehicle;

        switch (vehicleType.toLowerCase()) {
            case "car":
                System.out.println("Enter car brand, model, and fuel type: ");
                String carBrand = scanner.nextLine();
                String carModel = scanner.nextLine();
                String carFuelType = scanner.nextLine();
                factory = new CarFactory(carBrand, carModel, carFuelType);
                break;

            case "motorcycle":
                System.out.println("Enter motorcycle type and engine capacity: ");
                String motorcycleType = scanner.nextLine();
                int engineCapacity = scanner.nextInt();
                factory = new MotorcycleFactory(motorcycleType, engineCapacity);
                break;

            case "truck":
                System.out.println("Enter truck load capacity and number of axles: ");
                int loadCapacity = scanner.nextInt();
                int axles = scanner.nextInt();
                factory = new TruckFactory(loadCapacity, axles);
                break;

            case "bus":
                System.out.println("Enter bus seating capacity: ");
                int seatingCapacity = scanner.nextInt();
                factory = new BusFactory(seatingCapacity);
                break;

            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        vehicle = factory.createVehicle();
        vehicle.drive();
        vehicle.refuel();
    }
}
