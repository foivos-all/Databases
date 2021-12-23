package project_db;

public class Journalist {
    private String email, name, lastname, date_hired, newspaper_name; //Declaration of variables
    private char post;
    
    //Making the constructor to initialize the variables
    public Journalist(String email, String name, String lastname, String date_hired, String newspaper_name, char post){
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.date_hired = date_hired;
        this.newspaper_name = newspaper_name;
        this.post = post;
    }
    
    //Making the getter methods
    public String getemail(){
        return email;
    }
    
    public String getname(){
        return name;
    }
    
    public String getlastname(){
        return lastname;
    }
    
    public String getdate_hired(){
        return date_hired;
    }
    
    public String getnewspaper_name(){
        return newspaper_name;
    }
    
    public char getpost(){
        return post;
    }
}
