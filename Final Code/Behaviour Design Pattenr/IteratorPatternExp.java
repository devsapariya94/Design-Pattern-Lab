import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 class ShoppingCart implements Iterable<Item> {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<Item> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public Item next() {
            return items.get(currentIndex++);
        }

        @Override
        public void remove() {
            items.remove(currentIndex - 1);
        }
    }
}

 class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class IteratorPatternExp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Shirt", 25.0));
        cart.addItem(new Item("Pants", 35.0));
        cart.addItem(new Item("Shoes", 50.0));

        for (Item item : cart) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }

        System.out.println("Total: $" + cart.calculateTotal());
    }
}
