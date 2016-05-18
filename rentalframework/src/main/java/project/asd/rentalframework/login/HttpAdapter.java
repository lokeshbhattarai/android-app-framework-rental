package project.asd.rentalframework.login;

import com.lokex.apiconnector.HttpTaskListener;
import com.lokex.apiconnector.ParserFamily;
import com.lokex.apiconnector.ServerConnectorDTO;
import com.lokex.apiconnector.ServerTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by lokex on 5/18/16.
 */
public class HttpAdapter implements IHttpConnector {
    JSONObject result=null;
    @Override
    public JSONObject getResponse(final String requestType, final String url, final HashMap<String, String> params) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                ServerConnectorDTO connectorDTO = new ServerConnectorDTO();
                connectorDTO.setDataListNameValuePair(params);
                connectorDTO.setUrlToConnect(url);

                ServerTask serverTask = new ServerTask(new ParserFamily() {
                    @Override
                    public void setTaskId(int taskId) {

                    }

                    @Override
                    public int getTaskId() {
                        return 0;
                    }

                    @Override
                    public void setParserCallBack(HttpTaskListener httpTaskListener) {

                    }

                    @Override
                    public HttpTaskListener getParserCallBack() {
                        return null;
                    }

                    @Override
                    protected void handleServerResponse(String response) {
                        try {
                            result = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, connectorDTO);


                if (requestType.equals(REQUEST_TYPE_GET)){
                    serverTask.execute(ServerTask.RequestMethod.GET);
                }else {
                    serverTask.execute(ServerTask.RequestMethod.POST);
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }


}
