package com.example.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service

public class GenderIdenteficatorService {
    private List<String> maleTokens;
    private List<String> femaleTokens;


    @Autowired
    public GenderIdenteficatorService(JdbcTemplate jdbcTemplate) {
        this.maleTokens = readTokens("male_tokens.txt");
        this.femaleTokens = readTokens("female_tokens.txt");
    }



    private List<String> readTokens(String fileName) {
        List<String> tokens = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
            while(sc.hasNextLine()) {
                tokens.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        return tokens;
    }

    public String identificatorGenderFirstTokens(String name) {
        String[] tokens = name.split(" ");
        if(tokens.length > 0) {
            String firstToken = tokens[0];
            if(femaleTokens.contains(firstToken)) {
                return "Female";
            }
            else if(maleTokens.contains(firstToken)) {
                return "Male";
            }
        }
        return "Default";
    }

    public String identificatorGenderAllTokens(String name) {
        String[] tokens = name.split(" ");
        int countFemaleTokens = 0;
        int countMaleTokens = 0;
        if(tokens.length > 0) {
            for(String token : tokens) {
                if(femaleTokens.contains(token)) {
                    countFemaleTokens++;
                }
                if(maleTokens.contains(token)) {
                    countMaleTokens++;
                }
            }
        }
        if(countFemaleTokens > countMaleTokens) {
            return "Female";
        }
        else if(countMaleTokens > countFemaleTokens) {
            return "Male";
        }
        else {
            return "Default";
        }
    }

    public boolean isMaleName(String name) {
        return !isFemaleName(name);
    }

    public boolean isFemaleName(String name) {
        return name.endsWith("a");
    }

    public void writeName(String name, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(name + System.lineSeparator());
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean removeNameFromFile(String name) {
        String fileToRemoveFrom = "";
        if(isMaleName(name)) {
            fileToRemoveFrom = "male_tokens";
        }
        else if(isFemaleName(name)) {
            fileToRemoveFrom = "female_tokens";
        }
        else {
            System.out.println("Error name");
            return false;
        }
        try {
            List<String> updateNames = new ArrayList<>();
            File file = new File(fileToRemoveFrom);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.equalsIgnoreCase(name)) {
                    updateNames.add(line);
                }
            }
            scanner.close();

            FileWriter fileWriter = new FileWriter(file);
            for(String el : updateNames) {
                fileWriter.write(el + System.lineSeparator());
            }
            fileWriter.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void addNameToFile(String name) {
        if(isMaleName(name)) {
            writeName(name, "male_tokens");
            System.out.println("Name: " + name + " is add to file male_tokens");
        }
        else if(isFemaleName(name)) {
            writeName(name, "female_tokens");
            System.out.println("Name: " + name + " is add to file female_tokens");
        }
        else {
            System.out.println("Error name");
        }
    }
}
