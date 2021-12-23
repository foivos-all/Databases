package project_db;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Article {
    private String path, title, summary, chief_editor_email, comm, authors, state; //Declaration of variables
    private int paper, priority, start, end, category;
    DateFormat df = new SimpleDateFormat("yy/MM/dd"); //Making a new Date Object to get the Date typed from SQL
    java.util.Date date = new java.util.Date();
    
    //Making the constructor to initialize the variables
    public Article(String path, int paper, String title, String summary, String state, int priority, int start, int end, int category, String chief_editor_email, java.util.Date date, String commm, String authors){
        this.path = path;
        this.paper = paper;
        this.title = title;
        this.summary = summary;
        this.state = state;
        this.priority = priority;
        this.start = start;
        this.end = end;
        this.category = category;
        this.chief_editor_email = chief_editor_email;
        this.date = date;
        this.comm = comm;
        this.authors = authors;
    }
    
    //Making the getter methods
    public String getpath(){
        return path;
    }
    
    public int getpaper(){
        return paper;
    }
    
    public String gettitle(){
        return title;
    }
    
    public String getsummary(){
        return summary;
    }
    
    public String getstate(){
        return state;
    }
    
    public int getpriority(){
        return priority;
    }
    
    public int getstart(){
        return start;
    }
    
    public int getend(){
        return end;
    }
    
    public int getcategory(){
        return category;
    }
    
    public String getchiefeditoremail(){
        return chief_editor_email;
    }
    
    public java.util.Date getdate(){
        return date;
    }
    
    public String getcomments(){
        return comm;
    }
    
    public String getauthors(){
        return authors;
    }
}