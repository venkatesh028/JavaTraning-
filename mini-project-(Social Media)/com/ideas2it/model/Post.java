package com.ideas2it.model;

import java.util.List;
import java.util.ArrayList;

public class Post {
    String quotes;
    int like = 0;
    int postNumber;
    
    List<String> comments = new ArrayList<>();
   
    public Post (int postNumber, String quotes)  {
        this.postNumber = postNumber;
        this.quotes = quotes;
    }

    public String getQuotes() {
        return quotes;
    }
   
    public int getLike() {
        return like;
    }
    
    public List<String> getComments() {
        return comments;
    }
    
    public int getPostNumber() {
        return postNumber;
    }
 
    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }
    
    public void setLike() {
        like++;
    }
    
    public void setComment(String comment) {
        comments.add(comment);
    }
    
    public void setPostNumber() {
        postNumber++;
    }
    
    public String toString() {
        return  "\n"+postNumber +" ) " + quotes
               +"\n Likes : " + like 
               +"\n Comments:  " + comments;
    }
}