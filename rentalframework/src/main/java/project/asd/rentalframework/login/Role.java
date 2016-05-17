package project.asd.rentalframework.login;

/**
 * Created by Audi on 5/17/2016.
 */
public enum Role implements IRole{
    STAFF(1), ADMIN(2), BOTH(3);

    private int value;

    private Role(int value) {
        this.value = value;
    }

    public int getRole() {
        return value;
    }
}
