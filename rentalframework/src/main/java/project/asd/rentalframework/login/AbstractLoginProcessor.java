package project.asd.rentalframework.login;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lokex on 5/18/16.
 */
public abstract class AbstractLoginProcessor extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    public final void initiateLogin(){

        HashMap<String,String> credentials = getCredentials();
        String url = getLoginUrl();

        IHttpConnector connector = new HttpAdapter();
        JSONObject response = connector.getResponse(getRequestType(), url, credentials);
        onLoginResult(response);

    }

    public abstract HashMap<String,String> getCredentials();

    public abstract String getLoginUrl();

    public abstract String getRequestType();

    public abstract void onLoginResult(JSONObject response);

}
