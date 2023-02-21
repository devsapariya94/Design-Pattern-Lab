import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Customer {
    private String id;
    private String name;
    private String email;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    Customer(String name, String city, String email, String id) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.id = id;
    }
}

interface CustomerDatabaseService {
    Customer getCustomerDetail(String custId) throws FileNotFoundException;
}

class CustomerService implements CustomerDatabaseService {

    @Override
    public Customer getCustomerDetail(String custId) throws FileNotFoundException {
        FileReader fr = new FileReader("CustomerDetail.txt");
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String city = parts[2];
            String email = parts[3];
            if (id.equals(custId)) {
                return new Customer(name, city, email, id);
            }
        }
        return null;
    }
}

class CustomerServiceProxy implements CustomerDatabaseService {

    CustomerService cs = new CustomerService();

    @Override
    public Customer getCustomerDetail(String custId) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String userId = sc.next();
        String userName = sc.next();
        Date date = new Date();
        FileWriter fw;
        try {
            fw = new FileWriter("logUserInfo.txt", true);
            fw.write(userId + "," + userName + "," + date + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userName.equals("Manager")) {
            return cs.getCustomerDetail(custId);
        } else {
            System.out.println("Access denied. Only Managers can access customer details.");
            return null;
        }
    }
}



class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CustomerDatabaseService customerService = new CustomerServiceProxy();
        Customer c = customerService.getCustomerDetail("CU103");
        if (c != null) {
            System.out.println("Customer name: " + c.getName());
            System.out.println("Customer city: " + c.getCity());
            System.out.println("Customer email: " + c.getEmail());
            System.out.println("Customer id: " + c.getId());
        }
    }
}
