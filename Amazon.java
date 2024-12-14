import java.util.*;

class Customer 
{
    private int id;
    private String name;

    public Customer(int id, String name) 
    {
        this.id=id;
        this.name=name;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String toString() 
    {
        return "Customer ID: "+id+", Name: "+name;
    }
}

class Product 
{
    private int id;
    private String name;
    private double price;

    public Product(int id,String name,double price) 
    {
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public String toString() 
    {
        return "Product ID: "+id+", Name: "+name+", Price: "+price;
    }
}

class Order 
{
    private int orderId;
    private Customer customer;
    private Set<Product> products;

    public Order(int orderId, Customer customer) 
    {
        this.orderId=orderId;
        this.customer=customer;
        this.products=new HashSet<>();
    }

    public int getOrderId() 
    {
        return orderId;
    }

    public Customer getCustomer() 
    {
        return customer;
    }

    public Set<Product> getProducts() 
    {
        return products;
    }

    public void addProduct(Product product) 
    {
        products.add(product);
    }

    public String toString() 
    {
        return "Order ID: "+orderId+",Customer: [" + customer + "],Products: "+products;
    }
}

class ProductComparator implements Comparator<Product> 
{
    public int compare(Product p1,Product p2) 
    {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

public class Amazon
{
    public static void main(String\u005B \u005D args) 
    {
        //Instantiate Scanner class
        Scanner scanner = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        while(true) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Place Order");
            System.out.println("4. Display Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) 
            {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    customers.add(new Customer(customerId, customerName));
                    System.out.println("Customer added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();
                    products.add(new Product(productId, productName, productPrice));
                    System.out.println("Product added successfully.");
                    break;

                case 3:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter Customer ID for the Order: ");
                    int orderCustomerId = scanner.nextInt();
                    Customer orderCustomer = null;
                    for (Customer c : customers) 
                    {
                        if (c.getId() == orderCustomerId) 
                        {
                            orderCustomer = c;
                            break;
                        }
                    }
                    if(orderCustomer == null) 
                    {
                        System.out.println("Customer not found.");
                        break;
                    }
                    Order order = new Order(orderId, orderCustomer);
                    while(true) 
                    {
                        System.out.print("Enter Product ID to add to the Order (0 to finish): ");
                        int orderProductId = scanner.nextInt();
                        if (orderProductId == 0) break;
                        Product orderProduct = null;
                        for (Product p : products) {
                            if (p.getId() == orderProductId) 
                            {
                                orderProduct = p;
                                break;
                            }
                        }
                        if (orderProduct!=null) 
                        {
                            order.addProduct(orderProduct);
                            System.out.println("Product added to the order.");
                        } 
                        else 
                        {
                            System.out.println("Product not found.");
                        }
                    }
                    orders.add(order);
                    System.out.println("Order placed successfully.");
                    break;

                case 4:
                    System.out.println("Order History:");
                    for (Order o:orders) 
                    {
                        System.out.println(o);
                    }
                    break;

                case 5:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
