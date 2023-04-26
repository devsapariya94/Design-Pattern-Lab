import java.util.*;

class SubjectEntity {
    private int numberState;
    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public void setnumberState(int n) {
        numberState = n;
        notifyAllObservers();
    }

    public int getnumberState() {
        return numberState;
    }

    public void subscribeObserver(ObserverEntity e) {
        lm.add(e);
    }

    public void unsubscribeObserver(ObserverEntity e) {
        lm.remove(e);
    }

    public void notifyAllObservers() {
        for (ObserverEntity e : lm) {
            e.update();
        }
    }
}

abstract class ObserverEntity {
    SubjectEntity se;

    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity {
    public BinaryObserverEntity(SubjectEntity e) {
        se = e;
    }

    @Override
    public void update() {
        int n = se.getnumberState();
        System.out.println("BinaryObserver represents number : " + se.getnumberState() + " to binary : "+ Integer.toBinaryString(n));
    }
}

class HexObserverEntity extends ObserverEntity {
    public HexObserverEntity(SubjectEntity e) {
        se = e;
    }

    @Override
    public void update() {
        int n = se.getnumberState();
        System.out.println("HexObserver represents number : " + se.getnumberState() + " to hex : "
                + Integer.toHexString(n));
    }
}

public class Observer {
    public static void main(String[] args) {
        SubjectEntity e = new SubjectEntity();
        ObserverEntity p = new BinaryObserverEntity(e);
        e.subscribeObserver(p);
        e.setnumberState(10);
        ObserverEntity p1 = new HexObserverEntity(e);
        e.subscribeObserver(p1);
        e.setnumberState(20);

    }

}
