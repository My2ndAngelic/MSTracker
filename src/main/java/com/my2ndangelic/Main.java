package com.my2ndangelic;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        CSVJobReader csvJobReader = new CSVJobReader("Hero");
        String importedData;
        try {
            importedData = new BufferedReader(new FileReader("exampleJSON.json")).lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(importedData);
        JSONArray leServer = jsonObject.getJSONArray("server");
        JSONArray leChar = leServer.getJSONObject(0).getJSONArray("char");
        System.out.println(leChar);
    }
}