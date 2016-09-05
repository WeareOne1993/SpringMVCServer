package models;

public class StorageSearch
{
    private String name;
    private int number;

    public StorageSearch()
    {
        this.name = "default";
        this.number = 0;
    }
    
    public StorageSearch(String name, int number)
    {
        this.name = name;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
