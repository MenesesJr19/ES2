package com.es2.memento;

import java.util.ArrayList;

public class Server {
    ArrayList<String> studentNames;


    public Server() {
        studentNames = new ArrayList<>();
    }

    public void addStudent(String studentName)  throws ExistingStudentException{
        if (studentNames.contains(studentName)) {
            throw new ExistingStudentException();
        } else {
            this.studentNames.add(studentName);
        }
    }

    public Memento backup() {
        ArrayList<String> studentNamesCopy = new ArrayList<>(this.studentNames);
        return new Memento(studentNamesCopy);
    }

    public void restore(Memento state) {
        this.studentNames = state.getState();
    }

    public ArrayList<String> getStudentNames() {
        return this.studentNames;
    }
    //ez frag

}
