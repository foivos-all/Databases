package project_db;

public class Paper {
    private String newspaper_name, publisher; //Declaration of variables
    private int number, copies;
    
    //Making the constructor to initialize the variables
    public Paper(int number, String newspaper_name, String publisher, int copies){
        this.number = number;
        this.newspaper_name = newspaper_name;
        this.publisher = publisher;
        this.copies = copies;
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
    
    public int getcopies(){
        return copies;
    }
}
