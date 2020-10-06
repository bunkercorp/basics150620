package main;/*
*Создать класс JiraIssue, реализуя паттерн Builder или производный.
Класс должен предоставлять методы
inProject(String projectKey)
ofType(String issueTypeDisplayName)
withPriority(String priorityDisplayName)
withLabels(Collection<String> labels)
withDescription(String content)
withSummary(String summary)
create()
, где метод create() отправляет запрос на Jira REST API согласно данным ,собранным остальными методами и
* что-то делает с Jira key свежесозданного тикета. Класс JiraIssue должен иметь вменяемый toString.
Обратите внимание: inProject, ofType, withPriority оперируют именами, не идентификаторами, в то время как API
* эндпоинт джиры для создания тикета хочет как раз айди. Соответственно, нужно на основании заданного
*  имени из REST API вытянуть идентификаторы.
Стоит ли говорить, что для всех полей создаваемого тикета нужно разработать защиту от дурака? (например,
* имя несуществующего проекта вызывает некий эксепшен; не заданный\несуществующий
* priority подразумевает значение по
* умолчанию; не заданные labels не включаются в запрос;
* никаких нулловых или пустых строк и т.д. и т.п.) Если до отправки
* запроса на создание обнаруживается, что с какими-то полями есть
* неразрешимые проблемы, все эти проблемы одним списком должен
* отрепортить один-единственный эксепшен.
Сдавать веткой.
* */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

import org.apache.commons.codec.binary.Base64;

public class JiraIssue  {
    private String projectKey;
    private String issueType;
    private String priority;
    private List<String> labels;
    private String description;
    private String summary;
   // private List<String> errors = new ArrayList<>();

    @Override
    public String toString() {
        if (this.projectKey == null) {
          // такая ситуация должна быть невозможной
            this.projectKey = "";
        }
        if (this.issueType == null) {
            // такая ситуация должна быть невозможной
            this.issueType = "";
        }
        if (this.priority == null) {
            // такая ситуация должна быть невозможной
            this.priority = "";
        }
        String sbLabels="";
        if (this.labels.size() == 0) {
            this.labels = Collections.singletonList("");
            if (this.labels.size() >1) {
                for (int i = 1; i <= labels.size(); i++) {
                    sbLabels = sbLabels + "\",\""+ labels.get(i) ;
                }
            }
        }
        if (this.description == null) {
            this.description = "";
        }
        if (this.summary == null) {
            this.summary = "";
        }
        //{"fields":{"project":{"key": "AQ"},"summary":"Oksana2","description":"deck3","issuetype":{"name": "Test"},"priority":{"name": "Lowest"},"labels":["label0","label10"]}}
        // зачем джсон??
        return "{\"fields\":{\"project\":{\"key\": \"" + projectKey+"\"},\"summary\":\""+summary+"\",\"description\":\""+description+"\",\"issuetype\":{\"name\": \"" +issueType
                +"\"},\"priority\":{\"name\": \""+priority+"\"},\"labels\":[\""+labels.get(0)+sbLabels+"\"]}}"
                ;
    }

    static public class Builder {
            private JiraIssue ji;
            public Builder() {
                ji = new JiraIssue();
            }
            public JiraIssue create() throws IOException {

                /*//список проэктов
     /*   HttpHelper.Response responsePrj=HttpHelper.sendRequest( HttpHelper.Verb.GET,"https://jira.ithillel.com/rest/api/2/project", new Hashtable<String, String>(){{
            put ("Authorization", String.format("Basic %s", Base64.encodeBase64String(("oku.prebeta:51424651".getBytes()))));
        }}, null);
        JSONArray resultPrjArray=new JSONArray (responsePrj.body);
        int length = resultPrjArray.length();
        for (int i = 0; i<length; i++){
            JSONObject jo=resultPrjArray.getJSONObject(i);
            System.out.println(jo.getString("name")+"  "+jo.getString("id") +"  "+jo.getString("key"));
        }*/

                /*//список типов ишью к проекту
        String uriProjectId="https://jira.ithillel.com/rest/api/2/project/" + "10101" +"/";  //это по умолчанию проект
        HttpHelper.Response responseProjectById=HttpHelper.sendRequest( HttpHelper.Verb.GET,uriProjectId, new Hashtable<String, String>(){{
            put ("Authorization", String.format("Basic %s", Base64.encodeBase64String(("oku.prebeta:51424651".getBytes()))));
        }}, null);
        JSONObject  resultProjectData = new JSONObject(responseProjectById.body);
        JSONArray resultIssueTypeArray=resultProjectData.getJSONArray("issueTypes");
        length = resultIssueTypeArray.length();
        for (int i = 0; i<length; i++){
            JSONObject it=resultIssueTypeArray.getJSONObject(i);
            if (!it.getBoolean("subtask")){
                System.out.println(it.getString("name") );
            }
        }*/
                /*// список приоритета, по умочанию Medium
        HttpHelper.Response responsePrior=HttpHelper.sendRequest( HttpHelper.Verb.GET,"https://jira.ithillel.com/rest/api/2/priority", new Hashtable<String, String>(){{
            put ("Authorization", String.format("Basic %s", Base64.encodeBase64String(("oku.prebeta:51424651".getBytes()))));
        }}, null);
        JSONArray resultPriorArray=new JSONArray (responsePrior.body);
        length = resultPriorArray.length();
        for (int i = 0; i<length; i++){
            JSONObject jo=resultPriorArray.getJSONObject(i);
            System.out.println(jo.getString("name"));
        }*/

                // хардкод не годится
                JSONObject payload1 = new JSONObject();
                JSONObject fields = new JSONObject();
                fields.put("project", new JSONObject().put("key", "AQ"));
                fields.put("summary", ji.summary);
                fields.put("description", "text31");
                fields.put("issuetype", new JSONObject().put("name", "Test"));
                fields.put("priority", new JSONObject().put("name", "Lowest" ));
                fields.put("labels", new JSONArray().put("labels113"));
                payload1.put("fields", fields);


                HttpHelper.Response postTry=HttpHelper.sendRequest( HttpHelper.Verb.POST,"https://jira.ithillel.com/rest/api/2/issue/", new Hashtable<String, String>(){{
                    // креды в гите? ну-ну =)
                    put ("Authorization", String.format("Basic %s", Base64.encodeBase64String(("oku.prebeta:51424651".getBytes()))));
                }}, payload1);
                System.out.println(postTry); //use
                return ji;
               }


        public  Builder inProject(String projectKey){
            ji.projectKey="AQ";
            return this;
        }



        public Builder ofType(String issueType){
            ji.issueType="Epic";
            return this;
        }

        public Builder withPriority(String priority){
            ji.priority="Medium";
            return this;
        }

        public Builder withLabels(Collection<String> labels){
            ji.labels= Collections.singletonList("");
            return this;
        }

        public Builder withDescription(String description){
            ji.description="";
            return this;
        }
        public Builder withSummary(String summary){
            //must be set
            ji.summary=summary;
            return this;
        }


    }





}
