 public class OrderService
{
private void ProcessOrder(string productName, int quantity, double price, string action)
{
double totalPrice = quantity * price;
Console.WriteLine($"Order for {productName} {action}. Total: {totalPrice}");
}

public void CreateOrder(string productName, int quantity, double price)
{
ProcessOrder(productName, quantity, price, "created");
}

public void UpdateOrder(string productName, int quantity, double price)
{
ProcessOrder(productName, quantity, price, "updated");
}
}

public class Vehicle
{
public void Start()
{
Console.WriteLine($"{GetType().Name} is starting");
}

public void Stop()
{
Console.WriteLine($"{GetType().Name} is stopping");
}
}
public class Car : Vehicle
{}

public class Truck : Vehicle
{}

public class Calculator
{
    public void Add(int a, int b)
    {
        Console.WriteLine(a + b);
    }
}
Calculator calculator = new Calculator();
calculator.Add(3, 5);
