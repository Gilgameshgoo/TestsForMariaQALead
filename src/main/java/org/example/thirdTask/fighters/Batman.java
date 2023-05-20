package org.example.thirdTask.fighters;

import java.util.Map;

public class Batman extends Fighter{
    private  int health = 900;
    private final String coolPhrase = " ;I'm not the hero Gotham needs, but the hero it deserves";
    private final String name = "Batman";

    public  int getHealth(){
        return  this.health;
    }
    public String getCoolPhrase(){
        return  this.coolPhrase;
    }

    public String getName(){
        return  this.name;
    }

    public  void setHealth(int health){
        this.health = health;
    }


}
