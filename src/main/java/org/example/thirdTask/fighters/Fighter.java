package org.example.thirdTask.fighters;

import org.example.thirdTask.exceptions.FighterException;
import org.example.thirdTask.utils.FighterValidator;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.example.thirdTask.utils.FighterValidator.checkPunches;

public abstract class Fighter {
    private  int health = 1000;
    private final String coolPhrase = "";
    private Map<String,Integer> punches = null;
    List<String> listOfPunches = null;
    Random rand = new Random();
    private Fighter opponent = null;
    private final String name = null;
    public void setOpponent(Fighter opponent){
        if(opponent!= null){
            this.opponent = opponent;
            System.out.println(this.getName() + ": So, let it be you " + opponent.getName() + this.coolPhrase);
        }
        else {
            System.err.println(this.getName() + ": I got no one to fight! " + coolPhrase);
            assert opponent!=null;
        }
    }


    public void makeAPunch(int i ){
        opponent.missPunch(getPunches().get(getListOfPunches().get(i-1)));
    }

    public void missPunch(int damage){
        System.out.println(this.getName() + ": I was hit; Damage is: "+ damage + this.getCoolPhrase());
        this.setHealth(getHealth() - damage);
        System.out.println(this.getName() + ": Remaining health: "+ getHealth() + this.getCoolPhrase());
    }


    public void learnPunches(Map<String,Integer> punches) throws FighterException {
        if (punches==null  || !checkPunches(punches)){
            throw new FighterException("I am not able to fight");
        };
        this.punches = punches;
        this.listOfPunches = punches.keySet().stream().toList();
        System.out.println("punches I learned: " + listOfPunches);
    }

    public Fighter getOpponent(){
        return opponent;
    }

    public abstract int getHealth();
    public abstract String getCoolPhrase();

    public abstract String getName();
    public  Map<String,Integer> getPunches(){
        return punches;
    };

    public  List<String> getListOfPunches(){
        return listOfPunches;
    };

    public abstract void setHealth(int health);




}
