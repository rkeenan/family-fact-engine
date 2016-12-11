package com.fact.engine.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fact.engine.model.Person;
import com.fact.engine.model.Request;
import com.fact.engine.model.Response;
import org.apache.sling.commons.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class QuestionEngine implements RequestHandler<Request, Response> {
    private static Map<String, Person> info;
    private static final String OBJECT_MAPPINGS = "object-mappings";
    private static final String PERSON_NAMES = "person-names";

    @Override
    public Response handleRequest(Request request, Context context) {
        String toReturn;
        try {
            setupMap();
            JSONObject result = new JSONObject(request.getResult());
            System.out.println(result);
            JSONObject params = new JSONObject((Map<String, Object>)result.get("parameters"));
            System.out.println(params);
            String speech = "";
            if (params.has(PERSON_NAMES)) {
                System.out.println("params has person names object");
                String currentName = params.getString(PERSON_NAMES);
                System.out.println("current name is " + currentName);
                String currentObject = params.getString(OBJECT_MAPPINGS);
                System.out.println("current object is " + currentObject);
                Person currentPerson = info.get(currentName);
                speech = currentName + "'s " + currentObject + " is " + currentPerson.get(currentObject);
                System.out.println("output = " + speech);
            }
            toReturn = speech;
        } catch (Exception e) {
            toReturn = "{\"status\":400,\"errorType\":\"webhook call failed\"}";
//            toReturn = e.toString() + " " + e.getStackTrace()[0].getFileName() + " " + e.getStackTrace()[0].getLineNumber();
        }
        return new Response(toReturn);
    }

    private void setupMap() {
        info = new HashMap<>();
        // Paste personal info here
    }
}
