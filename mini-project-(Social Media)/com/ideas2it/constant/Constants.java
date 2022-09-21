package com.ideas2it.constant;

/**
 * Contain the Format of the email and password 
 *
 * @version 1.0 
 * @author Venkaetsh Tm
 */
public class Constants {
    public final static String emailFormat = "^[a-zA-Z0-9][a-zA-Z0-9.]{3,30}@[a-zA-Z0-9]+\\.[a-zA-Z0-9.]{3,}$";
    public final static String passwordFormat = "^(?=.*[0-9])" 
                                                 + "(?=.*[a-z])(?=.*[A-Z])"
                                                 + "(?=.*[@#$%^&+=])" 
                                                 + "(?=\\S+$).{8,20}$";
    public final static int CREATE_ACCOUNT = 1;
    public final static int LOGIN = 2;
    public final static int EXIT_HOMEPAGE = 3;

    public final static int UPDATE_NAME = 1;
    public final static int UPDATE_USERNAME = 2;
    public final static int UPDATE_BIO = 3;
    public final static int EXIT_UPDATEPAGE = 4;
    
    public final static int UPDATE_PROFILE = 1;
    public final static int DELETE_POST =2;
    public final static int SHOW_PERSONAL_INFO = 3;
    public final static int EDIT_PERSONAL_INFO = 4;
    public final static int EXIT_PROFILEPAGE = 5;

    public final static int ADDPOST = 1;
    public final static int LIKE = 2;
    public final static int COMMENT = 3;
    public final static int EXIT_POSTPAGE = 4;
   
    public final static int SHOW_POST = 1;
    public final static int SHOW_PROFILE = 2;
    public final static int LOGUT = 3;
    
}