package service;

import constants.Constants;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSerivice implements Constants {

    public static List<User> users = new ArrayList<>();
    int loginUserId = 0;
    public int loginUser(User user) {
        for (User user1 : users) {
            if (user1 != null) {
                if (user1.getNumber() == user.getNumber() && !user1.getPassword().equals(user.getPassword())) {
                    System.out.println(" Parolni noto`g`ri kiritdingiz !");
                    return -1;
                } else if (user1.getNumber() != user.getNumber() &&
                        user1.getPassword().equals(user.getPassword())) {
                    System.out.println(" Raqamni noto`g`ri kiritdingiz !");
                    return -1;
                }
                 else if (user1.getPassword().equals(user.getPassword()) &&
                user1.getNumber() == user.getNumber()){
                     loginUserId = 0;
                    loginUserId += user1.getUserId();
                    System.out.println(" Tizimga kirildi " + "\n");
                    return loginUserId;
                }
            }

        }
        return -1;
    }


    public boolean registerUser(User user) {
        for (User user1 : users) {
            if (user1 != null) {
                if (user.getNumber() == user1.getNumber()) {
                    return false;
                }
            }
        }
        users.add(user);

        return true;
    }

    public boolean editUser(User user){
        for (User user1:users){
            if (user1 != null){
                if (user1.getUserId() == user.getUserId()){
                      user1.setName(user.getName());
                      user1.setSurname(user.getSurname());
                      user1.setAdress(user.getAdress());
                      user1.setGmail(user.getGmail());
                      return true;
                }
            }
        }
        return false;
    }

    public boolean checUserbyNull(){
        for (User user1 : users){
            if (user1 != null){
                return true;
            }
        }
        System.out.println(" Iltimos oldin ro`yhatdan o`ting " + "\n");
        return false;
    }

    public boolean showUserInfo(int id){
        for (User user: users){
            if (user != null){
                if (user.getUserId() == id){
                    System.out.println(user);
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean showUsers(){
//        for (User user1:users){
//            if (user1 != null){
//                System.out.println(user1);
//            }
//
//        }
//        return true;
//    }

    public boolean checUserByNum(int number){
        for (User user1 : users) {
            if (user1 != null) {
                if (user1.getNumber() == number)
                    return false;
            }
        }
        return true;
    }

    public boolean changePassword(int id, String password){
        for (User user1: users){
            if (user1 != null){
                if (id == user1.getUserId()){
                    user1.setPassword(password);
                    System.out.println(" ** Parol o`zgartirildi ** "+"\n");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean passwordIsTrue(String oldPassword){
        for (User user:users){
            if (user != null){
                if (user.getPassword().equals(oldPassword)){
                    return true;
                }
            }
        }
        System.out.println(" *** Parol xato kiritildi *** " + "\n");
        return false;
    }

}
