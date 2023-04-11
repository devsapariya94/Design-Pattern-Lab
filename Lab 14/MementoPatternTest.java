import java.util.ArrayList;
import java.util.List;

interface Originator {
    void setTemperature(int temperature);
    void setVolume(int volume);
    int getTemperature();
    int getVolume();
    Memento saveStateToMemento();
    void restoreStateFromMemento(Memento memento);
}

class OriginatorObject implements Originator {
    private int temperature;
    private int volume;

    OriginatorObject(int temperature, int volume) {
        this.temperature = temperature;
        this.volume = volume;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature + " and Volume: " + volume;
    }

    public Memento saveStateToMemento() {
        return new MementoObject(temperature, volume);
    }

    public void restoreStateFromMemento(Memento memento) {
        temperature = memento.getTemperature();
        volume = memento.getVolume();
    }
}

interface Memento {
    int getTemperature();
    int getVolume();
}

class MementoObject implements Memento {
    private int temperature;
    private int volume;

    MementoObject(int temperature, int volume) {
        this.temperature = temperature;
        this.volume = volume;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }
}

class CareTakerObject {
    List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}

public class MementoPatternTest {
    public static void main(String[] args) {
        Originator originator = new OriginatorObject(15, 20);
        System.out.println(originator);
        CareTakerObject careTaker = new CareTakerObject();
        Memento memento = originator.saveStateToMemento();
        careTaker.addMemento(memento);
        originator.setTemperature(20);
        originator.setVolume(10);
        System.out.println(originator);
        memento = originator.saveStateToMemento();
        careTaker.addMemento(memento);
        originator.setVolume(5);
        originator.setTemperature(10);
        memento = originator.saveStateToMemento();
        careTaker.addMemento(memento);
        System.out.println("Restoring to the initial state");
        originator.restoreStateFromMemento(careTaker.getMemento(0));
        System.out.println(originator);
    }
}
