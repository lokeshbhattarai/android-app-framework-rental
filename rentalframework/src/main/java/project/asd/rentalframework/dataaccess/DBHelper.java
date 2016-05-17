package project.asd.rentalframework.dataaccess;

import java.util.ArrayList;

import project.asd.rentalframework.login.*;

/**
 * Created by Audi on 5/17/2016.
 */
public class DBHelper {
    private static ArrayList<IUser> users = new ArrayList<IUser>();

    public static IUser getUser(String username){
        for(IUser user : users){
            if(user.getUsername() == username){
                return user;
            }
        }
        return null;
    }

    public ArrayList<IUser> getUsers(){
        return users;
    }

    public static void addUser(IUser user) {
        users.add(user);
    }

}
