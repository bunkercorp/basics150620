package main;
import main.JiraIssue;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import org.apache.commons.codec.binary.Base64;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
 //post only hardcode data from JiraIssue
       new JiraIssue.Builder().withSummary("tttt").create();






    }
}