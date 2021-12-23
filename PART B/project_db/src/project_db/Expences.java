package project_db;

public class Expences {
    private String newspaper_name; //Declaration of variables
    private float total_expences;
    
    //Making the constructor to initialize the variables
    public Expences(String newspaper_name, float total_expences){
        this.newspaper_name = newspaper_name;
        this.total_expences= total_expences;
    }
    
    //Making the getter methods
    public String getnewspaper_name(){
        return newspaper_name;
    }
    
    public float gettotal_expences(){
        return total_expences;
    }
}
