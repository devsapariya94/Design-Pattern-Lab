import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;
    protected double price;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void showName();
    public abstract double getPrice();
}

class Leaf extends Component {
    public Leaf(String name, double price) {
        super(name, price);
    }

    public void showName() {
        System.out.println(name);
    }

    public double getPrice() {
        return price;
    }
}

class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name, double price) {
        super(name, price);
    }

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    public void showName() {
        System.out.println(name);
        for (Component c : children) {
            c.showName();
        }
    }

    public double getPrice() {
        double sum = price;
        for (Component c : children) {
            sum += c.getPrice();
        }
        return sum;
    }
}


public class Main {
    public static void main(String[] args) {
        Composite root = new Composite("root", 0);
        Composite branch1 = new Composite("branch1", 0);
        Composite branch2 = new Composite("branch2", 0);
        Leaf leaf1 = new Leaf("leaf1", 1);
        Leaf leaf2 = new Leaf("leaf2", 2);
        Leaf leaf3 = new Leaf("leaf3", 3);
        Leaf leaf4 = new Leaf("leaf4", 4);
        root.add(branch1);
        root.add(branch2);
        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);
        branch2.add(leaf4);
        root.showName();
        System.out.println(root.getPrice());
    }
}
