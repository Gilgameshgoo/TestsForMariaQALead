package org.example.thirdTask.utils;

import org.example.thirdTask.exceptions.FighterException;
import org.example.thirdTask.fighters.Fighter;

import java.util.List;
import java.util.Map;

public  class FighterValidator {
    public  static boolean checkPunches(Map<String,Integer> punches){
        List<String> listOfPunches = punches.keySet().stream().toList();
        for(String punch:listOfPunches){
            if(punches.get(punch) <=  0){
                System.err.println("Punch: '" + punch + "' is useless, it's damage is " + punches.get(punch));
                return false;
            }
        }
        return true;
    }

    public  static void checkFighter(Fighter fighter) throws FighterException {
        if(fighter == null){
            throw new FighterException("Fighter does not exist");
        }
        else if(fighter.getName() == null){
            throw new FighterException("Fighter has no name");
        } else if (fighter.getHealth() <= 0) {
            throw new FighterException("Fighters health is: " + fighter.getHealth());
        }
        else if (fighter.getPunches()== null) {
            throw new FighterException("Has no punches: ");
        }
        else if (fighter.getOpponent() == null) {
            throw new FighterException("Fighter has no opponent");
        }
        else if (fighter.getPunches()== null) {
            if(!checkPunches(fighter.getPunches()) ) {
                throw new FighterException("Fighter has non positive value for damage " + fighter.getPunches());
            }
        }

       // return false;
    }
}


