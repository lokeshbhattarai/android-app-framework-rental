package project.asd.rentalframework.login;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lokex on 5/18/16.
 */
public interface IHttpConnector {

    public String REQUEST_TYPE_GET = "get";
    public String REQUEST_TYPE_POST = "post";

    public JSONObject getResponse(String requestType,String url,HashMap<String,String> params);


}
