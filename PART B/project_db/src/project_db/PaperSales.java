package project_db;

public class PaperSales {
    private String newspaper_name, publisher; //Declaration of variables
    private int number, sales;
    
    //Making the constructor to initialize the variables
    public PaperSales(int number, String newspaper_name, String publisher, int sales){
        this.number = number;
        this.newspaper_name = newspaper_name;
        this.publisher = publisher;
        this.sales = sales;
    }
    
    //Making the getter methods
    public int getnumber(){
        return number;
    }
    
    public String getnewspaper_name(){
        return newspaper_name;
    }
    
    public String getpublisher(){
        return publisher;
    }
    
    public int getsales(){
        return sales;
    }
}
