import controllers.ProductController;
import controllers.UserController;
import db.DB;
import db.postgres.Postgres;
import repositories.interfaces.IProductRepository;
import repositories.products.ProductRepository;
import repositories.interfaces.IUserRepository;
import repositories.user.UserRepository;

public class Main {
    public static void main(String[] args) {
        DB db = Postgres.getInstance();
        IUserRepository userRepo = new UserRepository(db);
        IProductRepository productRepo = new ProductRepository(db);

        UserController userCtrl = new UserController(userRepo);
        ProductController productCtrl = new ProductController(productRepo);

        MyApplication app = new MyApplication(userCtrl, productCtrl);

        app.start();

        db.close();
    }
}
