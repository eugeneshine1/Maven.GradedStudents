package io.zipcoder;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student (String firstName, String lastName, ArrayList<Double>testScores){
        this.firstName=firstName;
        this.lastName=lastName;
        this.examScores=testScores;

    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Integer getNumberOfExamTaken() {return examScores.size();}

    public String getExamScores() {
        String theScore ="";
        for (int x =0;x<this.examScores.size();x++){
            theScore+= x + this.examScores.get(x);
        }
        return theScore;}
    public static void addExamScore(Double examScore){Student.addExamScore(examScore); }

    public void setExamScores(int examNumber, Double newScore) {
        this.examScores.set(examNumber,newScore);
    }
    public Double getAverageExamScore (){
        double theScores =0.0;
        for (int x =0;x<this.examScores.size();x++) {
            theScores += this.examScores.get(x);
        }
        return theScores/this.examScores.size();
    }
    @Override
    public String toString(){
        return firstName + lastName +getAverageExamScore() + getExamScores();

    }
}
