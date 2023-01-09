package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/** This file was created by Raymond Morales **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionsDTOList {

    @JsonProperty("clues")
    private List<Clues> clues;

    public List<Clues> getClues() {
        return clues;
    }

    public void setClues(List<Clues> clues) {
        this.clues = clues;
    }

    @Override
    public String toString() {
        return "QuestionsDTOList{" +
                "clues=" + clues +
                '}';
    }
}
