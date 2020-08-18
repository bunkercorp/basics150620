import java.security.InvalidParameterException;
import java.util.*;

public class URL {
    private String protocol;
    private int port;
    private String path;
    private String param;
    private String authority;
    private String fragment;
    private String domain;

    public String toString() {
        return (protocol + authority + domain + ":" + port + "/" + path + "?" + param + fragment);
    }

    public static class Composer {
        private URL newURL;

        public Composer(String domain) {
            newURL = new URL();
            newURL.domain = domain;
        }


        public Composer isSecure(boolean flag) {
            if (flag == true)
                newURL.protocol = "https://";
            else
                newURL.protocol = "http://";
            return this;
        }

        public Composer port(int i) {
            if ((i <= 0) || (i > 65535)) {
                System.out.println("Port number is not valid");
            } else
                newURL.port = i;
            return this;
        }

        public Composer path(String str) throws InvalidParameterException {
            if ((str == null) || (str == "")) {
                throw new InvalidParameterException("The path is not valid");
            } else if (newURL.path == null) {
                newURL.path = str;
            }
            return this;
        }

        public Composer path(String str, String str1) throws InvalidParameterException {
            if (((str == null) || (str == "")) && ((str1 == null) || (str1 == ""))) {
                throw new InvalidParameterException("The path is not valid");
            } else if (newURL.path == null) {
                newURL.path = str + "/" + str1;
            }
            return this;
        }

        public Composer path(Collection<String> word) throws InvalidParameterException {
            if (word.isEmpty()) {
                throw new InvalidParameterException("The path is not valid");
            } else if (newURL.path == null) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> iter = word.iterator();
                while (iter.hasNext()) {
                    String str = iter.next();
                    if (iter.hasNext()) {
                        newURL.path = sb.append(str).append("/").toString();
                    } else {
                        newURL.path = sb.append(str).toString();
                    }
                }
            }
            return this;
        }

        public Composer param(String param) throws InvalidParameterException {
            if ((param == null) || (param == "")) {
                throw new InvalidParameterException("The parameter is not valid");
            } else if (newURL.param == null) {
                newURL.param = param + "=" + param;
            }
            return this;
        }

        public Composer param(String arg, String value) throws InvalidParameterException {
            if (((arg == null) || (arg == "")) || ((value == null) || (value == ""))) {
                throw new InvalidParameterException("The parameter is not valid");
            } else if (newURL.param == null) {
                newURL.param = arg + "=" + value;
            }
            return this;
        }

        public Composer params(Map<String, String> param) throws InvalidParameterException {
            if (param == null) {
                throw new InvalidParameterException("The parameter is not valid");
            } else if (newURL.param == null) {
                StringBuilder sb = new StringBuilder();
                for (String key : param.keySet()) {
                    String value = key + "=" + param.get(key);
                    newURL.param = sb.append(value).append("&").toString();
                }
            }
            return this;
        }

        public Composer authority(String login) throws InvalidParameterException {
            if ((login == null) || (login == "")) {
                throw new InvalidParameterException("The path is empty");
            } else if (newURL.authority == null) {
                newURL.authority = login + "@";
            }
            return this;
        }

        public Composer authority(String login, String password) throws InvalidParameterException {
            if (((login == null) || (login == "")) || ((password == null) || (password == ""))) {
                throw new InvalidParameterException("The login/password are empty");
            } else if (newURL.authority == null) {
                newURL.authority = login + ":" + password + "@";
            }
            return this;
        }

        public Composer fragment(String fragm) throws InvalidParameterException {
            if ((fragm == null) || (fragm == "")) {
                throw new InvalidParameterException("The fragment is empty");
            } else {
                newURL.fragment = "#" + fragm;
            }
            return this;
        }

        public URL compose() {
            return newURL;
        }
    }

    public static void main(String[] args) {

        Collection<String> word = new ArrayList();
        word.add("lorem");
        word.add("ipsum");
        word.add("sit");
        word.add("amet");

        Map<String, String> param = new Hashtable<>();
        param.put("arg1", "40");
        param.put("arg2", "50");
        param.put("arg3", "60");

        try {
            URL myURL = new URL.Composer("www.example.com")
                    .isSecure(true)
                    .port(8080)
                    .path("ert","tyr")
                    .params(param)
                    .authority("name", "password")
                    .fragment("wertyu")
                    .compose();
            System.out.println(myURL.toString());
        }
        catch (InvalidParameterException e) {
            System.out.println("Значения параметров не могут быть пустыми");
        }

    }
}