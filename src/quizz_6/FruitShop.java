package quizz_6;

import java.util.ArrayList;
import java.util.Hashtable;

public class FruitShop {
    // Danh sách trái cây có trong cửa hàng
    private ArrayList<Fruit> fruits = new ArrayList<>();
    // Lưu đơn hàng theo tên khách hàng (customer name → danh sách trái cây họ đã mua)
    private Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    // Hàm chính điều khiển menu hệ thống
    public void run() {
        while (true) {
            System.out.println("\nFRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");           // Tạo trái cây mới
            System.out.println("2. View orders");            // Xem đơn hàng đã mua
            System.out.println("3. Shopping (for buyer)");   // Khách hàng mua trái cây
            System.out.println("4. Exit");                   // Thoát chương trình
            int choice = Validation.getInt("Choose (1-4): ", 1, 4);

            switch (choice) {
                case 1 -> createFruit();     // Tạo trái cây
                case 2 -> viewOrders();      // Xem đơn hàng
                case 3 -> shopping();        // Mua hàng
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }

    // Tạo trái cây mới và thêm vào danh sách
    private void createFruit() {
        while (true) {
            String id = Validation.getStringID("Enter fruit ID: ");
            String name = Validation.getString("Enter fruit name: ");
            double price = Validation.getDouble("Enter price: ", 0.1, 1000);
            int quantity = Validation.getInt("Enter quantity: ", 1, 1000);
            String origin = Validation.getString("Enter origin: ");

            fruits.add(new Fruit(id, name, price, quantity, origin));

            // Hỏi người dùng có muốn tạo thêm không
            String cont = Validation.getYesNo("Do you want to continue (Y/N)? ");
            if (cont.equals("N")) break;
        }
    }

    // Xem danh sách đơn hàng theo từng khách hàng
    private void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        // Duyệt từng khách hàng
        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer);
            double total = 0;
            System.out.println("Product | Quantity | Price | Amount");

            // Hiển thị từng sản phẩm trong đơn
            for (Fruit f : orders.get(customer)) {
                double amount = f.getQuantity() * f.getPrice();
                total += amount;
                System.out.printf("%s | %d | %.2f$ | %.2f$\n", f.getName(), f.getQuantity(), f.getPrice(), amount);
            }
            System.out.println("Total: " + total + "$\n");
        }
    }

    // Khách hàng chọn mua trái cây
    private void shopping() {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }

        ArrayList<Fruit> orderList = new ArrayList<>();

        while (true) {
            // Hiển thị danh sách trái cây còn hàng
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            int idx = 1;
            for (Fruit f : fruits) {
                if (f.getQuantity() > 0) {
                    System.out.printf("| %d | %s | %s | %.2f$ |\n", idx, f.getName(), f.getOrigin(), f.getPrice());
                    idx++;
                }
            }

            // Người dùng chọn theo số thứ tự
            int choice = Validation.getInt("Select fruit by number (1 to " + (idx - 1) + "): ", 1, idx - 1);

            Fruit selected = null;
            int count = 0;

            // Lấy ra trái cây tương ứng với chỉ số
            for (Fruit f : fruits) {
                if (f.getQuantity() > 0) {
                    count++;
                    if (count == choice) {
                        selected = f;
                        break;
                    }
                }
            }

            // Nếu không tìm thấy thì báo lỗi
            if (selected == null) {
                System.out.println("Invalid selection.");
                return;
            }

            System.out.println("You selected: " + selected.getName());

            // Nhập số lượng muốn mua, đảm bảo không vượt quá số lượng còn lại
            int qty = Validation.getInt("Please input quantity: ", 1, selected.getQuantity());

            // Trừ số lượng trong kho và thêm vào danh sách mua
            selected.setQuantity(selected.getQuantity() - qty);
            orderList.add(new Fruit(selected.getId(), selected.getName(), selected.getPrice(), qty, selected.getOrigin()));

            // Hỏi khách có muốn đặt hàng luôn không
            String cont = Validation.getYesNo("Do you want to order now (Y/N)? ");
            if (cont.equals("Y")) break;
        }

        // Hiển thị lại hóa đơn
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit f : orderList) {
            double amount = f.getQuantity() * f.getPrice();
            total += amount;
            System.out.printf("%s | %d | %.2f$ | %.2f$\n", f.getName(), f.getQuantity(), f.getPrice(), amount);
        }
        System.out.println("Total: " + total + "$\n");

        // Nhập tên khách hàng để lưu đơn hàng
        String customer = Validation.getString("Input your name: ");
        orders.put(customer, orderList);
    }
}
