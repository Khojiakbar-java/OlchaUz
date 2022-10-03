package model;


public class Product {
    private int productId;
    private String name;
    private double price;
    private int charId;
    private String year;
    private static int idGen = 0;

    public Product() {
        productId = ++idGen;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\t\t***** Product *****" +"\n" +
                "ProductId  = " + productId +'\n'+
                "name       = " + name + '\n' +
                "price      = " + price +'\n'+
                "categoryId = " + charId +"\n"+
                "year       = " + year + "\n";
    }
}
