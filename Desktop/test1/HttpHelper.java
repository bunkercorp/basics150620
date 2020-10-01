//import javax.net.ssl.HttpsURLConnection;
//import java.io.IOException;
//import java.io.BufferedReader;
//
//
//public class HttpHelper {
//    enum  Verb{
//        GET,
//    POST;
//    }
//    static class Response{
//        private final Map<String, String> headers;
//        public final String body;
//        public final int resCode;
//
//        public Response(Map<String, String> hs, String b, String body)
//
//    }
//
//
//
//
//    public static void sendRequest(Verb verb, String url,
//                                   M ap<String,String> args,
//                                   Map<String,String> headers,
//                                   String content)throws IOException {
//        final HttpsURLConnection httpCon = (HttpsURLConnection) new URL(uri).openConnection();
//        httpCon.setDoOutput(true);
//        httpCon.setRequestMethod(verb.name());
//        headers.forEach(httpCon::setRequestProperty);
//
//        if (verb.acceptsPayLoad){
//            httpCon.setRequestProperty();
//        }
//
//    }
//}
