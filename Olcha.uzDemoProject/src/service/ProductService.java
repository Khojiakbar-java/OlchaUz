package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static List<Product> products = new ArrayList<>();


    public boolean addProduct(Product product) {
        for (Product product1 : products) {
            if (product1 != null) {
                if (product1.getProductId() == product.getProductId()) {
                    return false;
                }
            }
        }
        System.out.println("\t\t **** Product added ****" + "\n");
        products.add(product);
        return true;
    }

    public boolean showProducts(){
        for (Product product:products) {
            if (product != null){
                System.out.println(product);
            }
        }
        return false;
    }

}
