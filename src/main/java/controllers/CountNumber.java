package controllers;

public class CountNumber
{
    private static int count = 0;
    
    public static int printCount()
    {
        
        count = count + 1;
        return count;
    }
}
