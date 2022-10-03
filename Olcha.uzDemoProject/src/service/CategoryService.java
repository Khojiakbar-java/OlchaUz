package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public static List<Category> categories = new ArrayList<>();

    public boolean addCategory1(Category category) {
        for (Category category1 : categories) {
            if (category1 != null) {
                if (category.getCharId() != 0) {
                    return false;
                }
            }
        }
        categories.add(category);
        System.out.println(" Kategoriya qo`shildi");
        return true;
    }

    public boolean addCategory2(Category category) {
        for (Category category2 : categories) {
            if (category2 != null) {
                if (category2.getCategoryId() >= category.getCharId()) {
                    if (category.getCharId() == category2.getCategoryId()) {
                        categories.add(category);
                        System.out.println("\t  * Ichki kategoriya qo`shildi *" + "\n");
                        return true;
                    }
                }
            }
        }
        System.out.println("Qo`shilmadi");
        return false;

    }


    public boolean showCharCategory() {
        for (Category category1 : categories) {
            if (category1 != null) {
                if (category1.getCharId() != 0) {
                    System.out.println(" kategoriya yo`q ");
                    return false;
                }

            }
            System.out.println("\t" + category1.getCategoryId() + "." + category1.getName());
            return true;
        }
        return false;
    }

    public boolean charCategoryIdIsTrue(int categoryId) {
        for (Category category1 : categories) {
            if (category1 != null) {
                if (category1.getCategoryId() != categoryId) {
                    System.out.println(" * Bunday kategoriya yo`q ");
                    return false;
                } else if (category1.getCategoryId() == categoryId) {
                    for (Category categ:categories) {
                        if (categ != null){
                            if (categ.getCharId() != categoryId) {
                                return false;
                            }
                            else
                                System.out.println(categ.getCategoryId()+"."+categ);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean checCatByCatID(int id) {
        int count = 0;
        for (Category category1 : categories) {
            if (category1 != null) {
                if (category1.getCategoryId() >= id) {
                    count++;
                }
            }
        }
        if (count > 0) {
            return true;
        } else return false;
    }


    public boolean checProductCharIdInCategory(int proCharId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getCategoryId() == proCharId) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean showAllCategory() {
        for (Category category1 : categories) {
            if (category1 != null) {
                System.out.println(category1);
            }
        }
        return false;
    }


}
