package project.asd.rentalframework.login;

/**
 * Created by Audi on 5/17/2016.
 */
public abstract class AUser implements IUser {
    private String username;
    private String password;

    public AUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }
}
