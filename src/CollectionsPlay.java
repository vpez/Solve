import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an example where objects can be mutated after being added to ShoppingCart and there is no privacy.
 * Ways to improve: Copying state when adding to ShoppingCart
 */
public class CollectionsPlay {
    public static void main(String[] args) {
        new CollectionsPlay().run();
    }

    void run() {
        Shop shop = new Shop();
        Product p1 = new Product("A", 100);
        Product p2 = new Product("B", 200);
        Product p3 = new Product("C", 300);
        shop.addProduct(p1);
        shop.addProduct(p2);
        shop.addProduct(p3);

        ShoppingCart cart = new ShoppingCart(shop);
        cart.addItem("A");
        cart.addItem("B");

        p1.setPrice(110);

        cart.checkout();
    }

    class Product {
        private final String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    class ShoppingCart {
        private final Shop shop;
        private final List<Product> items;

        public ShoppingCart(Shop shop) {
            this.shop = shop;
            items = new ArrayList<>();
        }

        void addItem(String name) {
            items.add(shop.getProduct(name));
        }

        double checkout() {
            double total = items.stream().mapToDouble(Product::getPrice).sum();
            System.out.println("Checkout success with total price = " + total);
            return total;
        }
    }

    class Shop {
        private final Map<String, Product> products = new HashMap<>();

        public Shop() {
        }

        void addProduct(Product item) {
            products.putIfAbsent(item.getName(), item);
        }

        Product getProduct(String name) {
            return products.get(name);
        }

        void removeProduct(String name) {
            products.keySet().removeIf(key -> key.equals(name));
        }
    }
}
