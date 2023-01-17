interface Table{
    void makeTable();
}

interface Chair{
    void makeChair();
}

interface AbstractFactory{
    Chair createChair();
    Table createTable();
}

class PlasticChair implements Chair{
    public void makeChair(){
        System.out.println("Plastic Chair");
    }
}


class PlasticTable implements Table{
    public void makeTable(){
        System.out.println("Plastic Table");
    }
}

class WoodenChair implements Chair{
    public void makeChair(){
        System.out.println("Wooden Chair");
    }
}

class WoodenTable implements Table{
    public void makeTable(){
        System.out.println("Wooden Table");
    }
}


class PlasticFactory implements AbstractFactory{
    public Chair createChair(){
        return new PlasticChair();
    }
    public Table createTable(){
        return new PlasticTable();
    }
}

class WoodenFactory implements AbstractFactory{
    public Chair createChair(){
        return new WoodenChair();
    }
    public Table createTable(){
        return new WoodenTable();
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Plastic")){
            return new PlasticFactory();
        }
        else if(choice.equalsIgnoreCase("Wooden")){
            return new WoodenFactory();
        }
        return null;
    }
}

public class ChairTable{
    public static void main(String[] args){
        
        FactoryProducer fp = new FactoryProducer();
        AbstractFactory af = fp.getFactory("Plastic");
        Chair c = af.createChair();
        Table t = af.createTable();
        c.makeChair();
        t.makeTable();


    }
}