class Computer {
    private int hddStorage;
    private int ramSize;
    private String processorCompany;
    private String processorType;
    private double moniterSize;
    private String moniterType;
    private String OsConfig;
    private String DeviceDriver;

    Computer(int hddStorage, int ramSize, String processorCompany, String processorType, double moniterSize, String moniterType, String OsConfig, String DeviceDriver) {
        this.hddStorage = hddStorage;
        this.ramSize = ramSize;
        this.processorCompany = processorCompany;
        this.processorType = processorType;
        this.moniterSize = moniterSize;
        this.moniterType = moniterType;
        this.OsConfig = OsConfig;
        this.DeviceDriver = DeviceDriver;
    }

    public int getHddStorage() {
        return hddStorage;
    }

    public int getRamSize() {
        return ramSize;
    }

    public String getProcessorCompany() {
        return processorCompany;
    }

    public String getProcessorType() {
        return processorType;
    }

    public double getMoniterSize() {
        return moniterSize;
    }

    public String getMoniterType() {
        return moniterType;
    }

    public String getOsConfig() {
        return OsConfig;
    }

    public String getDeviceDriver() {
        return DeviceDriver;
    }
}

class ComputerBuilder {
    private int hddStorage;
    private int ramSize;
    private String processorCompany;
    private String processorType;
    private double moniterSize;
    private String moniterType;
    private String OsConfig;
    private String DeviceDriver;

    public ComputerBuilder setHddStorage(int hddStorage) {
        this.hddStorage = hddStorage;
        return this;
    }

    public ComputerBuilder setRamSize(int ramSize) {
        this.ramSize = ramSize;
        return this;
    }

    public ComputerBuilder setProcessorCompany(String processorCompany) {
        this.processorCompany = processorCompany;
        return this;
    }

    public ComputerBuilder setProcessorType(String processorType) {
        this.processorType = processorType;
        return this;
    }

    public ComputerBuilder setMoniterSize(double moniterSize) {
        this.moniterSize = moniterSize;
        return this;
    }

    public ComputerBuilder setMoniterType(String moniterType) {
        this.moniterType = moniterType;
        return this;
    }

    public ComputerBuilder setOsConfig(String OsConfig) {
        this.OsConfig = OsConfig;
        return this;
    }

    public ComputerBuilder setDeviceDriver(String DeviceDriver) {
        this.DeviceDriver = DeviceDriver;
        return this;
    }

    public Computer build() {
        return new Computer(hddStorage, ramSize, processorCompany, processorType, moniterSize, moniterType, OsConfig, DeviceDriver);
    }
}


public class Computer_builder {
    public static void main(String[] args) {
        
        ComputerBuilder builder = new ComputerBuilder();
        Computer computer = builder.setHddStorage(500).setRamSize(8).setProcessorCompany("Intel").setProcessorType("i5").setMoniterSize(15.6).setMoniterType("LED").setOsConfig("Windows 10").setDeviceDriver("Nvidia").build();
        System.out.println("HDD Storage: " + computer.getHddStorage());
        System.out.println("RAM Size: " + computer.getRamSize());
        System.out.println("Processor Company: " + computer.getProcessorCompany());
        System.out.println("Processor Type: " + computer.getProcessorType());
        System.out.println("Moniter Size: " + computer.getMoniterSize());
        System.out.println("Moniter Type: " + computer.getMoniterType());
        System.out.println("OS Config: " + computer.getOsConfig());
        System.out.println("Device Driver: " + computer.getDeviceDriver()); 
    }
}