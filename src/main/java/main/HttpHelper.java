package main;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class HttpHelper {
    enum Verb {
        GET(false),
        POST (true);
        public final boolean acceptsPayLoad;

        Verb(boolean ap){
            acceptsPayLoad=ap;
        }
    }
    static class Response{
        private final Map<String, List<String>> headers;
        public final String body;
        public final int resCode;
        public final boolean isError;

        public Response(Map<String, List<String>> hs, String b, int c, boolean e){
            headers=hs ;//!= null ? new Hashtable<>(hs): new Hashtable<>();
            body=b;
            resCode=c;
            isError=e;
        }

        @Override
        public String toString(){
            return String.format("Code:%d\nis error: %s\n content:\n%s", resCode, isError, body );
        }
    }

    public static Response sendRequest(Verb verb, String uri, Map<String, String> headers, JSONObject payload)
            throws IOException{
        final HttpURLConnection httpCon=(HttpURLConnection) new URL(uri).openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod(verb.name());
        httpCon.setRequestProperty("Content-Type", "application/json");
        if (headers !=null) {
            headers.forEach (httpCon::setRequestProperty);
        }

        if(verb.acceptsPayLoad){
            httpCon.setRequestProperty("Content-Length","" + (payload==null ? 0: payload.length()));
            final OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(payload==null? "" : payload.toString());
            out.close();

        }

        List<String> result = new ArrayList<String>();

        BufferedReader rd;
        boolean isError = false;
        try{
            rd = new BufferedReader (new InputStreamReader(httpCon.getInputStream()));
        } catch (Exception e) {
            rd=new BufferedReader(new InputStreamReader(httpCon.getInputStream()) );
            isError=true;
        }
        String line;
        while (null !=(line=rd.readLine())){
                result.add(line);


        }
        return new Response (httpCon.getHeaderFields(),String.join("",result), httpCon.getResponseCode(), isError);
    }
}
