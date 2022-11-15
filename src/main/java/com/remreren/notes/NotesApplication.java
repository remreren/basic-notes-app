package com.remreren.notes;

import com.remreren.notes.handler.CommandlineInputHandler;
import com.remreren.notes.persistence.NotesMemoryPersistence;

import java.util.Scanner;

public class NotesApplication {

    private final CommandlineInputHandler inputHandler;
    private final NotesMemoryPersistence notesMemoryPersistence;
    private final Scanner scanner;

    public NotesApplication() {
        this.scanner = new Scanner(System.in);
        this.notesMemoryPersistence = new NotesMemoryPersistence();
        this.inputHandler = new CommandlineInputHandler(scanner, notesMemoryPersistence);
    }

    public static void main(String[] args) {
        NotesApplication.startApplication();
    }

    public static void startApplication() {
        NotesApplication notes = new NotesApplication();
        notes.start();
    }

    private void start() {
        System.out.println("BasicNotes uygulamasına hoş geldiniz");
        inputHandler.menu();
    }
}
