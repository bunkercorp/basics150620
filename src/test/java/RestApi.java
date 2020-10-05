import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

public class RestApi {
    enum Verb{
        GET(true),
        POST(false);

        private Verb(boolean b) {
            
        }

    };


    static class Response{
        private final Map<String,String> headers;
        public final String body;
        public final int resCode;
        public boolean isError = false;

        public   Response(Map<String,String> hs,String b,int c,boolean e ) {

            headers = new Hashtable<>(hs);
            body = b;
            resCode = c;
            isError = e;

        }
    }
    public static Response sendRequest(Verb verb, String uri, Map<String,String> arg, Map<String,String> headers, String content) throws IOException{

            final HttpsURLConnection httpCon = (HttpsURLConnection) new URL(uri).openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod(verb.name());
            if(headers != null)
               headers.forEach(httpCon :: setRequestProperty);

            if(verb.){
                httpCon.setRequestMethod();
            }


            return new Response();

        }
    }

