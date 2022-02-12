package controllers;

import models.Product;
import repositories.interfaces.IProductRepository;

import java.util.List;

public class ProductController {
    private final IProductRepository productRepo;

    public ProductController(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public String getAllByCategory(String category) {
        List<Product> products = productRepo.getByCategory(category);
        if (products.isEmpty())
            return "Products list is empty!";

        String response = "";

        for (Product product : products)
            response += product + "\n";

        return response;
    }
}
