package repositories.interfaces;

import models.Product;

import java.util.List;

public interface IProductRepository extends EntityRepository<Product> {
    List<Product> getByCategory(String category);
}
