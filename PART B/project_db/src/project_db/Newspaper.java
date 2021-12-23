package project_db;

public class Newspaper {
    private String name, owner, frequency; //Declaration of variables
    
    //Making the constructor to initialize the variables
    public Newspaper(String name, String owner, String frequency){
        this.name = name;
        this.owner = owner;
        this.frequency = frequency;
    }
    
    //Making the getter methods
    public String getname(){
        return name;
    }
    
    public String getowner(){
        return owner;
    }
    
    public String getfrequency(){
        return frequency;
    }
}
