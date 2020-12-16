package com.revature;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class FlowControls {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

    	int[] arrCount = new int[5];

        for (int i = 0; i < arr.size(); i++) {
            int birdType = arr.get(i);
            arrCount[birdType - 1]++;
        }
        
        int totalBirds = 0;
        int count = 0;

        for (int i = 0; i < arrCount.length; i++) {
            if (arrCount[i] > count) { 
            	count = arrCount[i];
            	totalBirds = i + 1; 
            }
        }

        return totalBirds;
    	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}