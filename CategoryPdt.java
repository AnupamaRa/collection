
public class CategoryPdt {
    private int id;
    private String name;
    private String[] cats = {"Transport", "Electronics", "Furnitures", "Entertainment", "Fitness", "Sports"};

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatByIndex(int index) {
        return cats[index];
    }
}