import db.DB;
import db.postgres.Postgres;
import models.User;
import repositories.EntityRepository;
import repositories.user.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB db = new Postgres();
        EntityRepository<User> userRepo = new UserRepository(db);

        List<User> users = userRepo.getAll();

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("++++++++++++++++++++");
        System.out.println("Please, enter id: ");
        int id = sc.nextInt();
        User user = userRepo.get(id);

        if (user == null) {
            System.out.println("The user with id " + id + " does not exist.");
        } else {
            System.out.println(user);
        }

        db.close();
    }
}
