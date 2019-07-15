package pro.nevercute.tut.patterns.algorythms.beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends CaffeinBeverage{

    @Override
    void brew() {
        System.out.println("Dropping coffere through filter");
    }

    @Override
    void addCondiment() {
        System.out.println("Adding sugar and milk");
    }

    public boolean customerWantsCondiments(){
        String answer = getUserInput();

        if(answer.toLowerCase().startsWith("y")){
            return true;
        }
        else
            return false;
    }

    public String getUserInput(){
        String answer = null;

        System.out.println("Add milk and sugar? (y/n)");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer == null)
            return "no";

        return answer;

    }
}
