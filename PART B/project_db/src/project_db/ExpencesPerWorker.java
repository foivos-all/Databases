package project_db;

public class ExpencesPerWorker { 
    private String newspaper_name, name, lastname; //Declaration of variables
    private float salary_per_month, total_salaries;
    
    //Making the constructor to initialize the variables
    public ExpencesPerWorker(String newspaper_name, String name, String lastname, float salary_per_month, float total_salaries){
        this.newspaper_name = newspaper_name;
        this.name = name;
        this.lastname = lastname;
        this.salary_per_month = salary_per_month;
        this.total_salaries = total_salaries;
    }
    
    //Making the getter methods
    public String getnewspaper_name(){
        return newspaper_name;
    }
    
    public String getname(){
        return name;
    }
    
    public String getlastname(){
        return lastname;
    }
    
    public float getsalarypermonth(){
        return salary_per_month;
    }
    
    public float gettotalsalaries(){
        return total_salaries;
    }
}
