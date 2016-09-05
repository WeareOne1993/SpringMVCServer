package models;

public class ResponseStatus
{
    private int number;
    private String status;
    
    public ResponseStatus()
    {
        this.number = 222;
        this.status = "default";
    }
    
    public ResponseStatus(int number, String status)
    {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
