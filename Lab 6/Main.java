class Computer{
    private int HDD;
    private int RAM_size;
    private String processor_make;
    private String processor_type;
    private float monitorSize;
    private String monitorType;
    private  String OsConfig;
    private String deviceDriver;

    private int ComputerID;

    public void setComputerID(int computerID) {
        this.ComputerID = computerID;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public void setRAM_size(int RAM_size) {
        this.RAM_size = RAM_size;
    }

    public void setProcessor_type(String processor_type) {
        this.processor_type = processor_type;
    }

    public void setProcessor_make(String processor_make) {
        this.processor_make = processor_make;
    }

    public void setOsConfig(String osConfig) {
        OsConfig = osConfig;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public void setMonitorSize(float monitorSize) {
        this.monitorSize = monitorSize;
    }

    public void setDeviceDriver(String deviceDriver) {
        this.deviceDriver = deviceDriver;
    }



    Computer(int Id){
        this.ComputerID=Id;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD=" + HDD +"GB"+
                ", RAM_size=" + RAM_size + "GB"+
                ", processor_make='" + processor_make + '\'' +
                ", processor_type='" + processor_type + '\'' +
                ", monitorSize=" + monitorSize +
                ", monitorType='" + monitorType + '\'' +
                ", OsConfig='" + OsConfig + '\'' +
                ", deviceDriver='" + deviceDriver + '\'' +
                ", ComputerID=" + ComputerID +
                '}';
    }

}


abstract class ComputerBuilder{
    Computer c;

    abstract public void buildHDD();
    abstract public void buildRAM_size();
    abstract public void buildprocessor_make();
    abstract public void buildprocessor_type();
    abstract public void buildmonitor_size();
    abstract public void buildmonitor_type();
    abstract public void buildOsConfig();
    abstract public void builddeviceDriver();

    abstract Computer returnProduct();

    public void createnewComputer(){
        c=new Computer(101);
    }

}

class ServerComputer extends ComputerBuilder{

    @Override
    public void buildHDD() {

        c.setHDD(100000);
    }

    @Override
    public void buildRAM_size() {
        c.setRAM_size(120);
    }

    @Override
    public void buildprocessor_make() {
        c.setProcessor_make("intel");
    }

    @Override
    public void buildprocessor_type() {
        c.setProcessor_type("octa-core");
    }

    @Override
    public void buildmonitor_size() {
        c.setMonitorSize(21);
    }

    @Override
    public void buildmonitor_type() {
        c.setMonitorType("LED");
    }

    @Override
    public void buildOsConfig() {
        c.setOsConfig("unique");
    }

    @Override
    public void builddeviceDriver() {
    }

    @Override
    Computer returnProduct() {
        return c;
    }


}

class PersonalComputer extends ComputerBuilder{

    @Override
    public void buildHDD() {
        c.setHDD(512);
    }

    @Override
    public void buildRAM_size() {
        c.setRAM_size(8);
    }

    @Override
    public void buildprocessor_make() {
        c.setProcessor_make("AMD");
    }

    @Override
    public void buildprocessor_type() {
        c.setProcessor_type("quad-core");
    }

    @Override
    public void buildmonitor_size() {
        c.setMonitorSize(14);
    }

    @Override
    public void buildmonitor_type() {
        c.setMonitorType("Touch-Screen");
    }

    @Override
    public void buildOsConfig() {
        c.setOsConfig("Windows");
    }

    @Override
    public void builddeviceDriver() {
    }

    @Override
    Computer returnProduct() {
        return c;
    }


}

class HardwareEngineer{
    ComputerBuilder cb;
    Computer xyz;

    public void setComputer(ComputerBuilder cbs){
        this.cb=cbs;
    }

    public void configComputer(){
        cb.buildHDD();
        cb.buildRAM_size();
        cb.buildprocessor_type();
        cb.buildprocessor_make();
        cb.buildmonitor_type();
        cb.buildmonitor_size();
        cb.buildOsConfig();
        cb.builddeviceDriver();
    }

    public Computer getComputer(){
        xyz=cb.returnProduct();
        return xyz;
    }



}


public class Main{
    public static void main(String[] args) {

        HardwareEngineer he =new HardwareEngineer();

        ComputerBuilder sc = new ServerComputer();
        sc.createnewComputer();
        he.setComputer(sc);
        he.configComputer();

        Computer c=he.getComputer();
        System.out.println(c);





    }
}

