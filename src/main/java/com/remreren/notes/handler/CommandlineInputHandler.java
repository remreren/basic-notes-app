package com.remreren.notes.handler;

import com.remreren.notes.model.Note;
import com.remreren.notes.persistence.NotesPersistence;

import java.util.Scanner;

public class CommandlineInputHandler {

    private final Scanner scanner;

    private final NotesPersistence persistence;

    public CommandlineInputHandler(Scanner scanner, NotesPersistence persistence) {
        this.scanner = scanner;
        this.persistence = persistence;
    }

    public Note createNote() {
        System.out.print("Not başlığını girin:");
        String title = scanner.nextLine();
        System.out.print("Not içeriğini girin:");
        String content = scanner.nextLine();
        Note newNote = new Note(title, content);
        persistence.saveNote(newNote);
        System.out.println("Not kaydedildi.");
        return newNote;
    }

    public Note updateNote() {
        System.out.print("Not numarasını girin:");
        int noteIdToUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("Yeni not başlığını girin:");
        String newTitle = scanner.nextLine();
        System.out.print("Yeni not içeriğini girin:");
        String newContent = scanner.nextLine();
        Note updated = persistence.updateNote(noteIdToUpdate, newTitle, newContent);
        System.out.println("Not güncellendi.");
        return updated;
    }

    public void deleteNote() {
        System.out.print("Not numarasını girin:");
        int noteIdToDelete = Integer.parseInt(scanner.nextLine());
        persistence.deleteNote(noteIdToDelete);
    }

    public void listNotes() {
        for (int i = 1; i <= persistence.getNotes().size(); i++) {
            System.out.println(i + "." + persistence.getNote(i).toString());
        }
    }
}
