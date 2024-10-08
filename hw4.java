class Order {
    private String productName;
    private int quantity;
    private double price;

    public Order(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class PriceCalculator {
    public double calculateTotalPrice(Order order) {
        return order.getQuantity() * order.getPrice() * 0.9;
    }
}

class PaymentProcessor {
    public void processPayment(String paymentDetails) {
        System.out.println("Payment processed using: " + paymentDetails);
    }
}

class EmailSender {
    public void sendConfirmationEmail(String email) {
        System.out.println("Confirmation email sent to: " + email);
    }
}

public class OrderProcessingApp {
    public static void main(String[] args) {
        Order order = new Order("Laptop", 2, 1500.00);

        PriceCalculator calculator = new PriceCalculator();
        double totalPrice = calculator.calculateTotalPrice(order);
        System.out.println("Total price: " + totalPrice);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment("Credit Card");

        EmailSender emailSender = new EmailSender();
        emailSender.sendConfirmationEmail("customer@example.com");
    }
}
