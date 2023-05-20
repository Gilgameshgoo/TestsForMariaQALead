package org.example.thirdTask;

import org.example.thirdTask.exceptions.FighterException;
import org.example.thirdTask.fighters.Batman;
import org.example.thirdTask.fighters.Fighter;
import org.example.thirdTask.fighters.Joker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");



        while (one.getHealth() > 0 && two.getHealth()> 0)
        {
            currentActor =  choseActor(one,two);
            System.out.println("Punches: " + currentActor.getListOfPunches() + "Choose a number of punch for:" + currentActor.getName()+ "\n");
            int i = in.nextInt();
            currentActor.makeAPunch(i);
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
