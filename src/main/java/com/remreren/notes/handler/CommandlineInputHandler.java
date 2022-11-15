package com.remreren.notes.handler;

import com.remreren.notes.model.Note;
import com.remreren.notes.persistence.NotesMemoryPersistence;

import java.util.Scanner;

public class CommandlineInputHandler {

    private final Scanner scanner;

    private final NotesMemoryPersistence persistence;

    public CommandlineInputHandler(Scanner scanner, NotesMemoryPersistence persistence) {
        this.scanner = scanner;
        this.persistence = persistence;
    }

    public void menu() {
        System.out.println("Devam etmek için seçim yapın.");
        System.out.println("1. Not ekle");
        System.out.println("2. Not düzenle");
        System.out.println("3. Not sil");
        System.out.println("4. Not listele");
        System.out.println("q. Çıkış");

        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "1" -> this.createNote();
            case "2" -> this.updateNote();
            case "3" -> this.deleteNote();
            case "4" -> this.listNotes();
            case "q" -> System.exit(0);
            default -> menu();
        }
    }

    public void createNote() {
        System.out.print("Not başlığını girin:");
        String title = scanner.nextLine();
        System.out.print("Not içeriğini girin:");
        String content = scanner.nextLine();
        Note newNote = new Note(title, content);
        persistence.saveNote(newNote);
        System.out.println("Not kaydedildi.");
        this.menu();
    }

    public void updateNote() {
        System.out.print("Not numarasını girin:");
        int noteIdToUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("Yeni not başlığını girin:");
        String newTitle = scanner.nextLine();
        System.out.print("Yeni not içeriğini girin:");
        String newContent = scanner.nextLine();
        persistence.updateNote(noteIdToUpdate, newTitle, newContent);
        System.out.println("Not güncellendi.");
        this.menu();
    }

    public void deleteNote() {
        System.out.print("Not numarasını girin:");
        int noteIdToDelete = Integer.parseInt(scanner.nextLine());
        persistence.deleteNote(noteIdToDelete);
        this.menu();
    }

    public void listNotes() {
        for (int i = 1; i <= persistence.getNotes().size(); i++) {
            System.out.println(i + "." + persistence.getNote(i).toString());
        }
        this.menu();
    }
}
