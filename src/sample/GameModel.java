package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class GameModel {

    private int[] generatedList = new int[4];
    private int[] inputList = new int[4];

    public GameModel() {
        generatedList = generateList();
    }

    public int[] generateList() {
        int[] result = new int[4];
        int min = 1, max = 6;
        for (int i=0; i<4; i++) {
            result[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        return result;
    }

    public int[] getGeneratedList() {
        return generatedList;
    }

    public void setGeneratedList(int[] generatedList) {
        this.generatedList = generatedList;
    }

    public int[] getInputList() {
        return inputList;
    }

    public void setInputList(int[] inputList) {
        this.inputList = inputList;
    }

    public HashMap<String, Integer> validateInput() {
        HashMap<String, Integer> result = new HashMap<>();

        int[] copyOfGeneratedList = new int[4];
        for (int i=0; i<4; i++) {
            copyOfGeneratedList[i] = generatedList[i];
        }

        int fullHitsCounter = 0;
        // full hits loop
        for (int i=0; i<4; i++) {
            if (inputList[i] == copyOfGeneratedList[i]) {
                fullHitsCounter++;
                inputList[i] = -1;
                copyOfGeneratedList[i] = -1;
            }
        }

        int halfHitsCounter = 0;
        //half hits loop
        for(int i=0; i<4; i++) {
            if (inputList[i] != -1) {
                for( int j=0; j<4; j++) {
                    if(inputList[i] == copyOfGeneratedList[j]) {
                        copyOfGeneratedList[j] = -1;
                        halfHitsCounter++;
                    }
                }
            }
        }

        result.put("fullHits", fullHitsCounter);
        result.put("halfHits", halfHitsCounter);

        return result;
    }

}
