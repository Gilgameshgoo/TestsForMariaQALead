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
    static Scanner in = new Scanner(System.in);

    static Fighter chosenFighter =null;

    static Fighter autoFighter =null;


    public static void main(String[] args) throws FighterException {
        Joker joker = new Joker();
        Batman batman = new Batman();

        Map<String,Integer> punches = new HashMap<>();
        punches.put("BasePunch", 30);
        punches.put("CoolPunch", 60);
        punches.put("PowerPunch", 90);

        joker.learnPunches(punches);
        batman.learnPunches(punches);

        joker.setOpponent(batman);
        batman.setOpponent(joker);

        startBattle(joker,batman);
    }



    public static void startBattle(Fighter one, Fighter two) throws FighterException {
        checkFighter(one);
        checkFighter(two);
        choseFighters(one, two);


        while (chosenFighter.getHealth() > 0 || autoFighter.getHealth() > 0)
        {
            System.out.println("Your turn " + "\n");
            System.out.println( "List of punches" + chosenFighter.getListOfPunches());
            System.out.println("Chose a number of punch: " + "\n");
            int punch = in.nextInt();
            if(punch > chosenFighter.getListOfPunches().size() || punch<0){
                System.out.println("Choose proper value fo punch");
                continue;
            }


            else {
                chosenFighter.makeAPunch(punch);
            }

            if(chosenFighter.getHealth() < 0 || autoFighter.getHealth() < 0){break;}

            System.out.println("\n" + "Que of: " + autoFighter.getName());
            autoFighter.autoPunch();


        }
        if(one.getHealth() < 0)
        {
            System.out.println("The winner is: " + two.getName());

        }
        else {
            System.out.println("The winner is: " + one.getName());
        }

    }

    public static void choseFighters (Fighter one, Fighter two){
        System.out.println("Fighter one: " + one.getName() + "; Fighter two: " + two.getName());

        int fighter = in.nextInt();

        if(fighter-1 == 0){chosenFighter=one; autoFighter =two;
            System.out.println("You have chose: " + one.getName());}
        else if(fighter-1 == 1){chosenFighter=two; autoFighter = one;
            System.out.println("You have chose: " + two.getName());}
        else {
            System.err.println("Chose valid number of fighter");
        }

    }


}
