package org.example.thirdTask;

import org.example.thirdTask.exceptions.FighterException;
import org.example.thirdTask.fighters.Batman;
import org.example.thirdTask.fighters.Fighter;
import org.example.thirdTask.fighters.Joker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.example.thirdTask.utils.FighterValidator.checkFighter;

public class Arena {
    static Fighter currentActor =null;
    static Random rand = new Random();

    public static void main(String[] args) throws FighterException {
        Joker joker = new Joker();
        Batman batman = new Batman();

        Map<String,Integer> onePunches = new HashMap<>();
        onePunches.put("BasePunch", 30);
        onePunches.put("CoolPunch", 60);
        onePunches.put("PowerPunch", 90);

        joker.learnPunches(onePunches);
        batman.learnPunches(onePunches);

        joker.setOpponent(batman);
        batman.setOpponent(joker);

        startBattle(joker,batman);
    }

    public static void startBattle(Fighter one, Fighter two) throws FighterException {
        checkFighter(one);
        checkFighter(two);

        while (one.getHealth() > 0 && two.getHealth()> 0){
            currentActor =  choseActor(one,two);
            currentActor.makeAPunch();
        }
        if(one.getHealth() < 0)
        {
            System.out.println("The winner is: " + two.getName());

        }
        else {
            System.out.println("The winner is: " + one.getName());
        }
    }
    public static Fighter choseActor(Fighter one, Fighter two){
        if(rand.nextInt(2) > 0){
            return one;
        }
        else {return two;}
    }
}
