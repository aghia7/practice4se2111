import controllers.ProductController;
import controllers.UserController;

import java.util.Scanner;

public class MyApplication {
    private final UserController userCtrl;
    private final ProductController productCtrl;
    private final Scanner sc;

    public MyApplication(UserController userCtrl, ProductController productCtrl) {
        this.userCtrl = userCtrl;
        this.productCtrl = productCtrl;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("Please, select option:");
            System.out.println("1. Create user");
            System.out.println("2. Get user by id");
            System.out.println("3. Get all users");
            System.out.println("4. Remove user by id");
            System.out.println("5. Get all products by cetegory");
            System.out.println("0. Exit");

            int option = sc.nextInt();

            if (option == 1)
                createUser();
            else if (option == 2)
                getUserById();
            else if (option == 3)
                getAllUsers();
            else if (option == 4)
                removeUserById();
            else if (option == 5)
                getAllProductsByCategory();
            else
                break;
        }
    }

    private void getAllProductsByCategory() {
        System.out.println("Enter category: ");
        String category = sc.next();
        String resp = productCtrl.getAllByCategory(category);
        System.out.println(resp);

        System.out.println("0. Exit");
        sc.next();
    }

    private void removeUserById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = userCtrl.removeById(id);
        System.out.println(resp);

        System.out.println("0. Exit");
        sc.next();
    }

    private void getAllUsers() {
        String resp = userCtrl.getAll();
        System.out.println(resp);

        System.out.println("0. Exit");
        sc.next();
    }

    private void getUserById() {
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        String resp = userCtrl.getById(id);
        System.out.println(resp);

        System.out.println("0. Exit");
        sc.next();
    }

    private void createUser() {
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter surname:");
        String surname = sc.next();
        String resp = userCtrl.create(name, surname);
        System.out.println(resp);


        System.out.println("0. Exit");
        sc.next();
    }
}
