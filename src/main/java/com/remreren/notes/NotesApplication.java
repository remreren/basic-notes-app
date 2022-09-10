package com.remreren.notes;

import com.remreren.notes.handler.CommandlineInputHandler;
import com.remreren.notes.persistence.NotesPersistence;

import java.util.Scanner;

public class NotesApplication {

    private final CommandlineInputHandler inputHandler;
    private final NotesPersistence notesPersistence;
    private final Scanner scanner;

    public NotesApplication() {
        this.scanner = new Scanner(System.in);
        this.notesPersistence = new NotesPersistence();
        this.inputHandler = new CommandlineInputHandler(scanner, notesPersistence);
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
        mainApplicationLoop();
    }

    private void mainApplicationLoop() {

        while (true) {
            System.out.println("Devam etmek için seçim yapın.");
            System.out.println("1. Not ekle");
            System.out.println("2. Not düzenle");
            System.out.println("3. Not sil");
            System.out.println("4. Not listele");
            System.out.println("q. Çıkış");

            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1" -> inputHandler.createNote();
                case "2" -> inputHandler.updateNote();
                case "3" -> inputHandler.deleteNote();
                case "4" -> inputHandler.listNotes();
                case "q" -> System.exit(0);
            }
        }
    }
}
