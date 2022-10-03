package model;

public class User {
    private int userId;
    private String name;
    private String surname;
    private int number;
    private String gmail;
    private String adress;
    private String password;

    private static int idGen = 0;

    public User() {
        userId = idGen++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }
    private String privatePassword(){
        String privatePas = "";
        for (int i = 0; i < password.length(); i++){
            privatePas += "*";
        }
        return privatePas;
    }

    @Override
    public String toString() {
        return " ***** Foydalanuvchi malumotlari ***** " + "\n" +
                " * Id       : " + userId + "\n" +
                " * Ism      : " + name + "\n" +
                " * Familiya : " + surname + "\n" +
                " * Raqam    : " + number + "\n" +
                " * Gmail    : " + gmail + "\n" +
                " * Adress   : " + adress + "\n" +
                " * Parol    : " + privatePassword() + "\n";
    }
}
