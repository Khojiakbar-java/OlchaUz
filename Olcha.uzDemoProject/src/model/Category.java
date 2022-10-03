package model;

public class Category {
    private int categoryId;
    private String name;
    private int charId;

    private static int idGen = 0;

    public Category(){
        this.categoryId = ++idGen;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId1) {
        categoryId = categoryId1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharId() {
        return charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    @Override
    public String toString() {
        return "                         ****** Categories ****** " +"\n"+
                " * Category Id      : " + categoryId +"\n"+
                " * Category Name    : " + name +"\n"+
                " * ParentCategoryId : " + charId +"\n";
    }
}
