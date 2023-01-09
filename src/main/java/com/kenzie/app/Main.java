package com.kenzie.app;

// import necessary libraries
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/** This file was created by Kenzie Academy **/
/** This file was modified by Raymond Morales **/

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */

    //main execution code implemented by Raymond Morales
    public static void main(String[] args) throws IOException {

        try {
            //Instantiate new CustomHttpClient object
            CustomHttpClient myCustomHttpClient = new CustomHttpClient();
            //json source
            String url = "https://jservice.kenzie.academy/api/clues";
            //Calling CustomHttpClient method and sending get request
            //assigning the response to a string variable
            String jsonString = myCustomHttpClient.sendGET(url);

            //instantiate new ObjectMapper object
            ObjectMapper objectMapper = new ObjectMapper();
            //use ObjectMapper to deserialize json format
            QuestionsDTOList allQuestionsList = objectMapper.readValue(jsonString, QuestionsDTOList.class);

            //declare variables for the game
            int answersCorrect = 0;
            int answersIncorrect = 0;
            int loopCount = 0;

            //loop through ten questions randomly
            while (loopCount < 10) {
                //random number generator to randomize questions
                Random rand = new Random();
                int randomInteger = rand.nextInt(100);

                //use random number generated to fetch category and question pair
                System.out.println("Category: " + allQuestionsList.getClues().get(randomInteger).getCategory().getTitle());
                System.out.println("Question: " + allQuestionsList.getClues().get(randomInteger).getQuestion());

                //create Scanner object for user interaction/input
                System.out.println();
                System.out.println("Enter your answer below:");
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();

                //determine if the userInput is correct or incorrect while tracking values
                if (userInput.equalsIgnoreCase(allQuestionsList.getClues().get(randomInteger).getAnswer())) {
                    System.out.println("Correct! You scored a point!");
                    answersCorrect++;
                    System.out.println("Your current score is " +answersCorrect+ ".");
                    System.out.println();
                    loopCount++;

                } else {
                    System.out.println("Incorrect.");
                    System.out.println("The correct answer was '" + allQuestionsList.getClues().get(randomInteger).getAnswer() + "'.");
                    answersIncorrect++;
                    System.out.println();
                    loopCount++;
                }
            }

            //Endgame messages
            System.out.println("You've reached the end.");
            System.out.println("You got " +answersCorrect+ " answers correct.");
            System.out.println("You got " +answersIncorrect+ " answers incorrect.");
            System.out.println();
            System.out.println("Your final score is: " +answersCorrect+ "!");

        } catch (Exception e) {
            System.out.println("Unexpected Exception: ");
            System.out.println(e.getMessage());;
        }
    }
}

