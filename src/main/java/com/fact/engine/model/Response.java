package com.fact.engine.model;

import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ryan on 12/11/2016.
 */
public class Response {
    private String speech;
    private String displayText;
    private JSONObject data;
    private ArrayList<String> contextOut;
    private String source;

    public Response() {}

    public Response(String speech) {
        this.speech = speech;
        this.displayText = speech;
        this.data = new JSONObject();
        this.contextOut = new ArrayList<>();
        this.source = "Family Fact Engine";
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public ArrayList<String> getContextOut() {
        return contextOut;
    }

    public void setContextOut(ArrayList<String> contextOut) {
        this.contextOut = contextOut;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
