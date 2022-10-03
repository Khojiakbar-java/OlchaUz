import constants.Constants;
import model.Category;
import model.Product;
import model.User;
import service.AdminService;
import service.CategoryService;
import service.ProductService;
import service.UserSerivice;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main implements Constants {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerDouble = new Scanner(System.in);
    static UserSerivice userSerivice = new UserSerivice();
    static AdminService adminService = new AdminService();
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();


    static int thisUserId = 0;


    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter thisTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println();
        String formattedDate = localDateTime.format(thisTime);

        System.out.println("\n\n");

        System.out.println("             ********** Olcha.uz **********     " + "\t\tCurrent date : " + formattedDate);


        int num = 10;
        while (num != 0) {

            System.out.println("\n" + SIGN_IN + "\n" + SIGN_UP + "\n" + CATEGORY + "\n"
                    + PRODUCTS + "\n" + PROFILE + "\n" + ADMIN_PANEL + "\n");


            System.out.print(" * Input : ");
            num = scannerInt.nextInt();

            switch (num) {
                case 1 -> signIn();

                case 2 -> signUp();

                case 3 -> showCategory();

                case 4 ->productService.showProducts();

                case 5 -> profileMenu();

                case 6 -> adminPanel();
            }

        }

    }

    private static void showCategory() {
        if (categoryService.showCharCategory()) {
            int num = 10;
            while (num != 0){
                System.out.print(" * Select Category : ");
                num = scannerInt.nextInt();
              if (categoryService.charCategoryIdIsTrue(num)){

                }

            }
        }
        else System.out.println(" *** Kategoriya bo`sh *** ");
    }

    private static void adminPanel() {
        System.out.println();
        System.out.println(ADMIN_MENU);
        int num = 10;
        while (num != 0) {
            System.out.println(ADD_CATEGORY + " " + ADD_PRODUCT + " " + ORDER_LIST +" "+ SHOW_ALL);
            System.out.print(" * Input : ");
            num = scannerInt.nextInt();
            switch (num) {
                case 1 -> addCategory();

                case 2 -> addProduct();

                case 3-> orderList();

                case 4 -> {
                    categoryService.showAllCategory();
                    productService.showProducts();
                }
            }

        }
    }

    private static void orderList() {

    }

    private static void addProduct() {
        System.out.println("\t   *** ADD_PRODUCT *** ");

        System.out.print(" Input Category ID : ");
        int proCharId = scannerInt.nextInt();

        if (proCharId == 0){
            Product product = new Product();
            System.out.print(" Input product name  : ");
            product.setName(scannerStr.nextLine());
            System.out.print(" Input product price : ");
            product.setPrice(scannerDouble.nextDouble());
            System.out.print(" Input product year  : ");
            product.setYear(scannerStr.nextLine());
            product.setCharId(proCharId);
            productService.addProduct(product);

        }
        else {
            if (categoryService.checProductCharIdInCategory(proCharId)) {
                Product product = new Product();
                System.out.print(" Input product name  : ");
                product.setName(scannerStr.nextLine());
                System.out.print(" Input product price : ");
                product.setPrice(scannerDouble.nextDouble());
                System.out.print(" Input product year  : ");
                product.setYear(scannerStr.nextLine());
                product.setCharId(proCharId);
                productService.addProduct(product);
            }
        }
    }

    private static void signIn() {
        if (userSerivice.checUserbyNull()) {
            User user = new User();
            System.out.println("         *** Login user ***           ");
            System.out.print("Input number :");
            user.setNumber(scannerInt.nextInt());
            System.out.print("Input password :");
            user.setPassword(scannerStr.nextLine());
            int unknownRes = userSerivice.loginUser(user);
            if (unknownRes >= 0) {
                thisUserId = unknownRes;
            }
        }
    }

    private static void signUp() {

        System.out.println("             *** Register user *** ");
        System.out.print("Input number +998");
        int number = scannerInt.nextInt();
        if (number == 0) {
            return;
        }
        if (number >= 100000000 && number <= 999999999) {
            if (userSerivice.checUserByNum(number)) {
                User user = new User();
                user.setNumber(number);
                System.out.print("Input name :");
                user.setName(scannerStr.nextLine());
                System.out.print("Input surname :");
                user.setSurname(scannerStr.nextLine());
                System.out.print("Input new password :");
                //String pasw = scannerStr.nextLine();
                user.setPassword(scannerStr.nextLine());
                userSerivice.registerUser(user);
            } else System.out.println("Siz oldin ro`yhatdan o`tgansiz " + "\n");
        } else {
            System.out.println(" Raqamni to`g`ri kiriting !" + "\n");
        }
    }

    private static void profileMenu() {
        if (userSerivice.checUserbyNull()) {
            System.out.println("          *** Profile *** ");
            int num5 = 10;
            while (num5 != 0) {
                System.out.println(EDIT_PROFILE + " " + SHOW_USER_INFO + " " + CHANGE_PASSWORD);
                System.out.print(">>>");
                num5 = scannerInt.nextInt();
                switch (num5) {
                    case 1 -> {
                        User user = new User();

                        System.out.println(" *** EDIT PROFILE *** ");
                        System.out.print("Input  name :");
                        user.setName(scannerStr.nextLine());
                        System.out.print("Input surname :");
                        user.setSurname(scannerStr.nextLine());
                        System.out.print("Input gmail  :");
                        user.setGmail(scannerStr.nextLine());
                        System.out.print("Input adress :");
                        user.setAdress(scannerStr.nextLine());
                        user.setUserId(thisUserId);

                        System.out.println(userSerivice.editUser(user));
                    }
                    case 2 -> userSerivice.showUserInfo(thisUserId);

                    case 3 -> {
                        System.out.print("Esi parolni kiriting :");
                        String oldPas = scannerStr.nextLine();
                        System.out.println();
                        if (userSerivice.passwordIsTrue(oldPas)) {
                            System.out.print("Yangi parolni kiriting : ");
                            String newPas = scannerStr.nextLine();
                            System.out.print("Yangi parolni qayta kiriting :");
                            String newPas1 = scannerStr.nextLine();
                            if (newPas1.equals(newPas)) {
                                userSerivice.changePassword(thisUserId, newPas);
                            } else System.out.println("\n" + "* Yangi parol bir xil emas * ");
                        }
                    }
                }
            }
        }
    }

    private static void addCategory() {
        System.out.print(" Input category name : ");
        String categoryName = scannerStr.nextLine();
        System.out.print(" Input category charID : ");
        int charID = scannerInt.nextInt();

        if (charID == 0) {
            Category category = new Category();
            category.setName(categoryName);
            category.setCharId(charID);
            categoryService.addCategory1(category);
        }

        if (charID != 0 && categoryService.checCatByCatID(charID)) {
            Category category = new Category();
            category.setName(categoryName);
            category.setCharId(charID);
            categoryService.addCategory2(category);
        }
    }
}


