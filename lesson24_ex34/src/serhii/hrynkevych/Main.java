package serhii.hrynkevych;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Product product1001 = new Product(1001, "Subway 2020", "book", 25);
        Product product1002 = new Product(1002, "Other book", "book", 111);
        Product product1003 = new Product(1003, "Ho-Ho", "book", 125);
        Product product2001 = new Product(2001, "Milk", "children", 40);
        Product product2002 = new Product(2002, "Sneakers", "children", 200);
        Product product3001 = new Product(3001, "Car", "toys", 135);
        Product product3002 = new Product(3002, "Mouse", "toys", 90);

        productList.add(product1001);
        productList.add(product1002);
        productList.add(product1003);
        productList.add(product2001);
        productList.add(product2002);
        productList.add(product3001);
        productList.add(product3002);

        List<Customer> customerList = new ArrayList<>();
        Customer customer101 = new Customer(101, "Vasya", 2);
        Customer customer102 = new Customer(102, "Petya", 1);
        Customer customer103 = new Customer(103, "Serhii", 3);
        Customer customer104 = new Customer(104, "Vanya", 2);
        Customer customer105 = new Customer(105, "Yaroslav", 2);
        Customer customer106 = new Customer(106, "Ivan", 2);

        customerList.add(customer101);
        customerList.add(customer102);
        customerList.add(customer103);
        customerList.add(customer104);
        customerList.add(customer105);
        customerList.add(customer106);

        System.out.println(productList);
        System.out.println(customerList);

        List<Product> orderCustomer101 = new ArrayList<>();
        orderCustomer101.add(product1001);
        orderCustomer101.add(product2001);
        List<Product> orderCustomer102 = new ArrayList<>();
        orderCustomer102.add(product1003);
        orderCustomer102.add(product3001);
        List<Product> orderCustomer103 = new ArrayList<>();
        orderCustomer103.add(product1002);
        //orderCustomer103.add(product2002);
        orderCustomer103.add(product3002);
        List<Product>orderCustomer104 = new ArrayList<>();
        orderCustomer104.add(product1003);
        orderCustomer104.add(product2001);
        orderCustomer104.add(product2002);
        orderCustomer104.add(product3001);
        List<Product>orderCustomer105 = new ArrayList<>();
        orderCustomer105.add(product1002);
        orderCustomer105.add(product2002);
        orderCustomer105.add(product3002);
        List<Product>orderCustomer106 = new ArrayList<>();
        orderCustomer106.add(product1003);
        orderCustomer106.add(product2001);
        orderCustomer106.add(product3002);

        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order(1, "new", LocalDate.of(2021, 11, 15),
                LocalDate.of(2021, 11, 15), orderCustomer101, customer101);
        Order order2 = new Order(2, "delivery", LocalDate.of(2021, 10, 5),
                LocalDate.of(2021, 10, 15), orderCustomer102, customer102);
        Order order3 = new Order(3, "delivery", LocalDate.of(2021, 12, 4),
                LocalDate.of(2021, 12, 5), orderCustomer103, customer103);
        Order order4 = new Order(4, "new", LocalDate.of(2021, 11, 15),
                LocalDate.of(2021, 12, 20), orderCustomer104, customer104);
        Order order5 = new Order(5, "new", LocalDate.of(2021, 10, 10),
                LocalDate.of(2021, 10, 20), orderCustomer105, customer105);
        Order order6 = new Order(6, "new", LocalDate.of(2021, 10, 20),
                LocalDate.of(2021, 10, 21), orderCustomer106, customer106);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);

        System.out.println("\n****\n");
        System.out.println(orderList + "\n****\n");

        System.out.println("---\nУпражнение 1. Получите список товаров (Product), относящихся к категории " +
                "\"Книги\" с ценой > 100.");
        System.out.println(exercise1(productList));

        System.out.println("---\nУпражнение 2. Получите список заказов с товарами (Order), относящимися к категории " +
                "\"Детские\".");
        System.out.println(exercise2(orderList));

        System.out.println("---\nУпражнение 3. Получите список товаров (Product) с категорией \"Игрушки\" и скидкой " +
                "10% для каждого товара.");
        System.out.println(exercise3(productList));

        System.out.println("---\nУпражнение 4. Получите список товаров (Product), заказанных клиентом уровня 2 " +
                "(поле tier класса Customer) в период с 01.10.2021. по 01.11.2021");
        System.out.println(exercise4(orderList));

        System.out.println("---\nУпражнение 5. Получите самый дешевый товар (Product) категории \"Книги\".");
        System.out.println(exercise5(productList));

        System.out.println("---\nУпражнение 6. Получите 3 последних размещенных заказа (Order).");
        System.out.println(exercise6(orderList));

        System.out.println("---\nУпражнение 7. Получите список заказов (Order), которые были заказаны 15.11.2021 года,\n" +
                " выведите заказы в консоль и затем верните список продуктов, заказанных в этот день.");
        System.out.println(exercise7(orderList));

        System.out.println("---\nУпражнение 8. Получите Map<Order, Double> с заказами и общей суммой стоимости продуктов.");
        System.out.println(exercise8(orderList));

    }


    private static List<Product> exercise1(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("book"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    private static List<Order> exercise2(List<Order> orders) {
        return orders.stream()
                .map(o -> List.of(new Order(o.getId(), o.getStatus(), o.getOrderDate(), o.getDeliveryDate(),
                                o.getProducts().stream()
                                        .filter(p -> p.getCategory().equals("children"))
                                        .collect(Collectors.toList()),
                                o.getCustomer())))
                .flatMap(List::stream)
                .filter(o -> !o.getProducts().isEmpty())
                .collect(Collectors.toList());
    }

    private static List<Product> exercise3(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("toys"))
                .collect(Collectors.toList())
                .stream().map(p -> new Product(p.getId(), p.getName(), p.getCategory(), (p.getPrice() - p.getPrice() * 0.1)))
                .collect(Collectors.toList());
    }

    private static List<Product> exercise4(List<Order> orderList) {
        LocalDate startDate = LocalDate.of(2021, 10, 1);
        LocalDate endDate = LocalDate.of(2021, 11, 1);

        return orderList.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .collect(Collectors.toList())
                .stream().filter(order -> order.getCustomer().getTier() == 2)
                .collect(Collectors.toList())
                .stream()
                .flatMap(order -> order.getProducts().stream().map(p -> new Product
                        (p.getId(), p.getName(), p.getCategory(), p.getPrice())))
                .collect(Collectors.toList())
                .stream().distinct()
                .collect(Collectors.toList());
    }

    private static Optional<Product> exercise5(List<Product> productList) {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        return productList.stream()
                .filter(product -> product.getCategory().equals("book"))
                .collect(Collectors.toList())
                .stream().min(comparator);
    }

    private static List<Order> exercise6(List<Order> orderList) {
        if (orderList.size() - 3 <= 0) {
            return null;
        }
        return orderList.stream()
                .skip(orderList.size() - 3)
                .collect(Collectors.toList());
    }

    private static List<Product> exercise7(List<Order> orderList) {
        orderList.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 11, 15)))
                .forEach(System.out::println);

        return orderList.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 11, 15)))
                .flatMap(order -> order.getProducts().stream().map(p -> new Product
                        (p.getId(), p.getName(), p.getCategory(), p.getPrice())))
                .collect(Collectors.toList())
                .stream().distinct()
                .collect(Collectors.toList());
    }

    private static Map<Order, Double> exercise8(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.toMap(order -> order,
                                order -> order.getProducts().stream()
                                        .mapToDouble(Product::getPrice)
                                        .sum()));
    }
}
