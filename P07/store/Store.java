package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }

    public void Store(BufferedReader br) throws IOException{
        int customerSize = Integer.parseInt(br.readLine());
        for(int i = 0; i < customerSize; ++i){
            Customer c = new Customer(br);
            add(c);
        }

        int optionSize = Integer.parseInt(br.readLine());
        for(int i = 0; i < optionSize; ++i){
            Option o = new Option(br);
            add(o);
        }

        int computerSize = Integer.parseInt(br.readLine());
        for(int i = 0; i < computerSize; ++i){
            Computer c = new Computer(br);
            add(c);
        }

        int orderSize = Integer.parseInt(br.readLine());
        for(int i = 0; i < orderSize; ++i){
            Order ord = new Order(br);
            add(ord);
        }
    }
    
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + "\n");
        bw.write(customers.size() + "\n");
        for (Customer c : customers) {
            c.save(bw);
        }

        bw.write(options.size() + "\n");
        for (Option o : options) {
            o.save(bw);
        }

        bw.write(computers.size() + "\n");
        for (Computer compt : computers) {
            compt.save(bw);
        }
        
        bw.write(orders.size() + "\n");
        for (Order odr : orders) {
            odr.save(bw);    
        }
        
    }

    // ///////////////////////////////////////////////////////////
    // Fields
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
}
