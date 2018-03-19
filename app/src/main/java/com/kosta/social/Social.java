package com.kosta.social;

/**
 * Created by Kostadin Kostadinov on 19/03/2018.
 */

public class Social {
    private String type;
    private String content;
    private String user;

    public Social(){

    }

    public Social(String user,String type, String content){
        this.user = user;
        this.type = type;
        this.content = content;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(user);
        sb.append(": ");
        sb.append(content);
        sb.append("\n\n\n");
        return sb.toString();
    }

    public String getType(){
        return type;
    }
    public String getUser(){
        return user;
    }
    public String getContent() {
        return content;
    }
}
