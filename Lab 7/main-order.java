
class Order implements Cloneable{
    private int orderID;
    private int orderPrice;
    private Address ad;

    public Order(int orderID, int orderPrice, Address ad) {
        this.orderID = orderID;
        this.orderPrice = orderPrice;
        this.ad = ad;
    }

public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public Address getAd() {
        return ad;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderPrice=" + orderPrice + ", ad=" + ad + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address {
    private String houseNum;
    private String street;
    private String city;
    private String state;
    private String country;

    Address(String HouseNum, String street, String city, String state, String country){
        this.houseNum=houseNum;
        this
    }

}