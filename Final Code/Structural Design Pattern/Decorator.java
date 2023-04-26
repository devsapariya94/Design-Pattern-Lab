abstract class PizzaMaker{
    private int Price = 130;
    private String Name = "Normal Pizza";
    private String Toppins = "No Toppins";
    int getPrice(){
        return this.Price;
    }
    String getToppins(){
        return this.Toppins;
    }
    void setDetails(int price,String Toppins){
        this.Price += price;
        if(this.Toppins.equalsIgnoreCase("No Toppins")){            
            this.Toppins = Toppins;
        }else{
            this.Toppins += Toppins;
        }
    }
    public abstract void getPizza();
}
class Pizza extends PizzaMaker{
    @Override
    public void getPizza() {
        System.out.println("Pizza Order");
        System.out.println("Your pizza with Toppins: "+this.getToppins()+" is ready!!!");
        System.out.println("Total Amount");
        System.out.println("Amount is: "+this.getPrice());
    }
}
class PizzaDecorator extends PizzaMaker{
    public PizzaMaker pizza = null;
    PizzaDecorator(PizzaMaker pizza){
        this.pizza = pizza;
    }
    @Override
    public void getPizza() {
        System.out.println("Pizza Order");
        System.out.println("Your pizza with Toppins: "+this.getToppins()+" is ready!!!");
        System.out.println("Total Amount");
        System.out.println("Amount is: "+this.getPrice());
    }
}
class AddCheese extends PizzaDecorator{
    AddCheese(PizzaMaker pizza) {
        super(pizza);
        pizza.setDetails(150," Cheese Burst |");
        pizza.getPizza();
    }
}
class AddVagies extends PizzaDecorator{
    AddVagies(PizzaMaker pizza) {
        super(pizza);
        pizza.setDetails(80," Vagie | ");
        pizza.getPizza();
    }
}
public class test { 
    public static void main(String args[]){
        PizzaMaker pizza = new Pizza(); 
        PizzaMaker cheese = new AddCheese(pizza);
        PizzaMaker vagie = new AddVagies(pizza);
    }   
}
