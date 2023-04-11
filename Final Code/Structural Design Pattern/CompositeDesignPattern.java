import java.util.ArrayList;

abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;

    }

    public abstract void showName();

    public abstract int getPrice();
}

class Leaf extends Component {
    private int price;

    public Leaf(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public void showName() {
        System.out.print("Leaf: " + name + "\t");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class Composite extends Component {
    private int price = 0;
    private ArrayList<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    @Override
    public void showName() {
        System.out.println("Composite: " + name);
        for (Component component : components) {
            component.showName();
        }
    }

    @Override
    public int getPrice() {
        for (Component component : components) {
            price += component.getPrice();
        }
        return price;
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        Component hdd = new Leaf("HDD", 3000);
        Component cpu = new Leaf("CPU", 10000);
        Component ram = new Leaf("RAM", 5000);
        Component mouse = new Leaf("Mouse", 600);
        Component keyboard = new Leaf("Keyboard", 900);

        Composite computer = new Composite("Computer");
        Composite cabinet = new Composite("Cabinet");
        Composite peripheral = new Composite("Peripheral");
        Composite motherboard = new Composite("Motherboard");

        motherboard.addComponent(cpu);
        motherboard.addComponent(ram);

        peripheral.addComponent(mouse);
        peripheral.addComponent(keyboard);

        cabinet.addComponent(hdd);
        cabinet.addComponent(motherboard);

        computer.addComponent(peripheral);
        computer.addComponent(cabinet);

        hdd.showName();
        motherboard.showName();

        System.out.println();
        System.out.println("Peripheral price: " + peripheral.getPrice());
        System.out.println("Mouse price: " + mouse.getPrice());
    }
}
