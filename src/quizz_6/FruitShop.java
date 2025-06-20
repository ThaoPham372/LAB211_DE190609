package quizz_6;

import java.util.ArrayList;
import java.util.Hashtable;

public class FruitShop {
        private ArrayList<Fruit> fruits = new ArrayList<>();
        private Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

        public void run() {
            while (true) {
                System.out.println("\nFRUIT SHOP SYSTEM");
                System.out.println("1. Create Fruit");
                System.out.println("2. View orders");
                System.out.println("3. Shopping (for buyer)");
                System.out.println("4. Exit");
                int choice = Validation.getInt("Choose (1-4): ", 1, 4);

                switch (choice) {
                    case 1 -> createFruit();
                    case 2 -> viewOrders();
                    case 3 -> shopping();
                    case 4 -> {
                        System.out.println("Bye!");
                        return;
                    }
                }
            }
        }

        private void createFruit() {
            while (true) {
                String id = Validation.getStringID("Enter fruit ID: ");
                String name = Validation.getString("Enter fruit name: ");
                double price = Validation.getDouble("Enter price: ", 0.1, 1000);
                int quantity = Validation.getInt("Enter quantity: ", 1, 1000);
                String origin = Validation.getString("Enter origin: ");

                fruits.add(new Fruit(id, name, price, quantity, origin));
                String cont = Validation.getYesNo("Do you want to continue (Y/N)? ");
                if (cont.equals("N")) break;
            }
        }

        private void viewOrders() {
            if (orders.isEmpty()) {
                System.out.println("No orders available.");
                return;
            }
            for (String customer : orders.keySet()) {
                System.out.println("Customer: " + customer);
                double total = 0;
                System.out.println("Product | Quantity | Price | Amount");
                for (Fruit f : orders.get(customer)) {
                    double amount = f.getQuantity() * f.getPrice();
                    total += amount;
                    System.out.printf("%s | %d | %.2f$ | %.2f$\n", f.getName(), f.getQuantity(), f.getPrice(), amount);
                }
                System.out.println("Total: " + total + "$\n");
            }
        }

        private void shopping() {
            if (fruits.isEmpty()) {
                System.out.println("No fruits available.");
                return;
            }
            ArrayList<Fruit> orderList = new ArrayList<>();
            while (true) {
                System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
                int idx = 1;
                for (Fruit f : fruits) {
                    if (f.getQuantity() > 0) {
                        System.out.printf("| %d | %s | %s | %.2f$ |\n", idx, f.getName(), f.getOrigin(), f.getPrice());
                        idx++;
                    }
                }
                int choice = Validation.getInt("Select fruit by number (1 to " + (idx - 1) + "): ", 1, idx - 1);
                Fruit selected = null;
                int count = 0;
                for (Fruit f : fruits) {
                    if (f.getQuantity() > 0) {
                        count++;
                        if (count == choice) {
                            selected = f;
                            break;
                        }
                    }
                }
                if (selected == null) {
                    System.out.println("Invalid selection.");
                    return;
                }
                System.out.println("You selected: " + selected.getName());
                int qty = Validation.getInt("Please input quantity: ", 1, selected.getQuantity());
                selected.setQuantity(selected.getQuantity() - qty);
                orderList.add(new Fruit(selected.getId(), selected.getName(), selected.getPrice(), qty, selected.getOrigin()));
                String cont = Validation.getYesNo("Do you want to order now (Y/N)? ");
                if (cont.equals("Y")) break;
            }
            double total = 0;
            System.out.println("Product | Quantity | Price | Amount");
            for (Fruit f : orderList) {
                double amount = f.getQuantity() * f.getPrice();
                total += amount;
                System.out.printf("%s | %d | %.2f$ | %.2f$\n", f.getName(), f.getQuantity(), f.getPrice(), amount);
            }
            System.out.println("Total: " + total + "$\n");
            String customer = Validation.getString("Input your name: ");
            orders.put(customer, orderList);
        }
}
