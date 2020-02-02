package sample;

import java.util.ArrayList;

public class GameModel {

    private ArrayList<Integer> generatedList = new ArrayList<>();
    private ArrayList<Integer> inputList = new ArrayList<>();

    public GameModel() {
        generatedList = generateList();
    }

    public ArrayList<Integer> generateList() {
        return null;
    }

    public ArrayList<Integer> getGeneratedList() {
        return generatedList;
    }

    public void setGeneratedList(ArrayList<Integer> generatedList) {
        this.generatedList = generatedList;
    }

    public ArrayList<Integer> getInputList() {
        return inputList;
    }

    public void setInputList(ArrayList<Integer> inputList) {
        this.inputList = inputList;
    }

}
