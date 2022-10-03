package model;

public class Order {
    private int orderId;
    private int productId;
    private String orderName;
    private String userName;
    private String userSurname;
    private int userNumber;
    private String adress;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setName(String orderName) {
        this.orderName = orderName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "                 **** Orders **** " +"\n" +
                "  Order ID     : " + orderId +"\n"+
                "  Product ID   : " + productId +"\n"+
                "  Product name : " + orderName + "\n" +
                "  User name    : " + userName + "\n"+
                "  User surname : " + userSurname + "\n"+
                "  User number  : " + userNumber +"\n"+
                "  Adress       : " + adress + "\n";
    }
}
