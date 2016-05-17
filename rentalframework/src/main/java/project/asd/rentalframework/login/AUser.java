package project.asd.rentalframework.login;

/**
 * Created by Audi on 5/17/2016.
 */
public abstract class AUser implements IUser {
    private String username;
    private String password;
    private IRole role;

    public AUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setRole(IRole role){
        this.role = role;
    }

    @Override
    public IRole getRole(){
        return role;
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
