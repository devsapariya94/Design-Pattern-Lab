interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

class WoodenFactory implements FurnitureFactory {
    public Chair createChair() {
        return new WoodenChair();
    }
    public Table createTable() {
        return new WoodenTable();
    }
}

class PlasticFactory implements FurnitureFactory {
    public Chair createChair() {
        return new PlasticChair();
    }
    public Table createTable() {
        return new PlasticTable();
    }
}

interface Chair {
    void sit();
}

interface Table {
    void use();
}

class WoodenChair implements Chair {
    public void sit() {
        System.out.println("wooden chair.");
    }
}

class PlasticChair implements Chair {
    public void sit() {
        System.out.println("plastic chair.");
    }
}

class WoodenTable implements Table {
    public void use() {
        System.out.println(" wooden table.");
    }
}

class PlasticTable implements Table {
    public void use() {
        System.out.println("plastic table.");
    }
}

public class furnitureAbstarctFactory {
    public static void main(String[] args) {
        FurnitureFactory woodenFactory = new WoodenFactory();
        Chair woodenChair = woodenFactory.createChair();
        woodenChair.sit(); // Output: Sitting on a wooden chair.

        FurnitureFactory plasticFactory = new PlasticFactory();
        Table plasticTable = plasticFactory.createTable();
        plasticTable.use(); // Output: Using a plastic table.
    }
}
