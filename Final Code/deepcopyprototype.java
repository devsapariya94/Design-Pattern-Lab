abstract class House implements Cloneable {
    private int houseid;
    private int housearea;
    private float price;

    House(int houseid, int housearea, float price) {
        this.housearea = housearea;
        this.houseid = houseid;
        this.price = price;
    }

    public void sethouseid(int houseid) {
        this.houseid = houseid;
    }

    public void sethouseara(int housearea) {
        this.housearea = housearea;
    }

    public void setprice(float price) {
        this.price = price;
    }

    public int gethouseid() {
        return houseid;
    }

    public int gethousearea() {
        return housearea;
    }

    public float getprice() {
        return price;
    }

    public String toString() {
        return "for the house id " + houseid + "having house area " +
                housearea + "price is " + price;
    }
}

class Twobhkhouse extends House {
    Twobhkhouse(int houseid, int housearea, float price) {
        super(houseid, housearea, price);
        // TODO Auto-generated constructor stub
    }

    private int parkingcharge;

    // super(houseid,housearea,price);
    public void setparkingcharge(int parkingcharge) {
        this.parkingcharge = parkingcharge;
    }

    public int getparkingcharge() {
        return parkingcharge;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = (Twobhkhouse) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "the house id is :" + gethouseid() + " the housearea is :" +
                gethousearea() + "the price is "
                + getprice() + " the parkingcharge is " + getparkingcharge();
    }
}

class Threebhkhouse extends House {
    Threebhkhouse(int houseid, int housearea, float price) {
        super(houseid, housearea, price);
    }

    private float privategarden;

    public void setprivategarden(float privategarden) {
        this.privategarden = privategarden;
    }

    public float getprivateparking() {
        return privategarden;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = (Threebhkhouse) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}

public class deepcopyprototype {
    public static void main(String[] args) {
        Twobhkhouse h1 = new Twobhkhouse(1, 200, 344);
        System.out.println(h1);
    }
}