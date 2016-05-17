package project.asd.rentalframework.login;

import org.json.JSONException;
import java.io.IOException;
import project.asd.rentalframework.dataaccess.DBHelper;

/**
 * Created by Audi on 5/17/2016.
 */
public class LoginController {
    private String username;
    private String password;

    public LoginController(String username,
                            String password) throws JSONException, IOException{
        this.username = username;
        this.password = password;
    }

    public IRole isValidUser(){
        IUser users = DBHelper.getUser(username);
        if(users.getPassword() == password) return users.getRole();
        return null;
    }
}
