package org.example.thirdTask.fighters;

import java.util.Map;

public class Joker extends  Fighter{
    private  int health = 1200;
    private final String coolPhrase = " ;I thought my life is a tragedy, but it is a comedy";
    private final String name = "Joker";


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
