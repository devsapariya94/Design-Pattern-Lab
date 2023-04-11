public class shallowcopyprototype {
    public static void main(String[] args) {
        Address a = new Address("Ahmedabad", "abcd");
        Order o1 = new Order(101, 1000, a);
        Order o2 = o1.clone();
        System.out.println("Original Order : " + o1);
        System.out.println("cloned Order : " + o2);
        o2.setAmount(3000); // shallow copy
        o2.getAd().setsocietyName("abc");
        System.out.println("After changing the cloned order amount and society name");
        System.out.println("Original Order : " + o1);
        System.out.println("cloned Order : " + o2);
    }
}

class Address {
    private String city;
    private String societyName;

    public Address(String ct, String str) {
        city = ct;
        societyName = str;
    }

    public void setsocietyName(String s) {
        societyName = s;
    }

    public String getCity() {
        return city;
    }

    public String getsocietyName() {
        return societyName;
    }
}

class Order implements Cloneable {
    private int ordId;
    private long amount;
    private Address ad;

    public Order(int ord, long amount, Address a) {
        ordId = ord;
        this.amount = amount;
        setAd(a);
    }

    public Address getAd() {
        return ad;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }

    public void setAmount(long amt) {
        amount = amt;
    }

    public String toString() {
        return "Order Id : " + ordId + " and amount is : " + amount + " @ " + getAd().getCity() + " "
                + getAd().getsocietyName();
    }

    public Order clone() {
        Order o1 = null;
        try {
            o1 = (Order) super.clone();
            Address a1 = new Address(this.ad.getCity(), this.ad.getsocietyName()); // for deep copy
            o1.ad = a1;
        } catch (CloneNotSupportedException e) {
        }
        return o1;
    }
}