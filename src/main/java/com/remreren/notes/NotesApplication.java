package com.remreren.notes;

import com.remreren.notes.model.Note;

import java.util.ArrayList;
import java.util.Scanner;

public class NotesApplication {

    private final ArrayList<Note> notesMemory = new ArrayList<>();

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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Devam etmek için seçim yapın.");
            System.out.println("1. Not ekle");
            System.out.println("2. Not düzenle");
            System.out.println("3. Not sil");
            System.out.println("4. Not listele");
            System.out.println("q. Çıkış");

            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "1" -> createNewNote(scanner);
                case "2" -> updateNote(scanner);
                case "3" -> deleteNote(scanner);
                case "4" -> listNotes();
                case "q" -> System.exit(0);
            }
        }
    }

    private void createNewNote(Scanner scanner) {
        System.out.print("Not başlığını girin:");
        String title = scanner.nextLine();
        System.out.print("Not içeriğini girin:");
        String content = scanner.nextLine();
        Note newNote = new Note(title, content);
        notesMemory.add(newNote);
        System.out.println("Not kaydedildi.");
    }

    private void updateNote(Scanner scanner) {
        System.out.print("Not numarasını girin:");
        int noteIdToUpdate = Integer.parseInt(scanner.nextLine());
        System.out.println(noteIdToUpdate + "." + notesMemory.get(noteIdToUpdate - 1).toString());
        System.out.print("Yeni not başlığını girin:");
        String newTitle = scanner.nextLine();
        System.out.print("Yeni not içeriğini girin:");
        String newContent = scanner.nextLine();
        Note updatedNote = notesMemory.get(noteIdToUpdate - 1).update(newTitle, newContent);
        notesMemory.set(noteIdToUpdate - 1, updatedNote);
        System.out.println("Not güncellendi.");
    }

    private void deleteNote(Scanner scanner) {
        System.out.print("Not numarasını girin:");
        int noteIdToDelete = Integer.parseInt(scanner.nextLine());
        notesMemory.remove(noteIdToDelete - 1);
    }

    private void listNotes() {
        for (int i = 0; i < notesMemory.size(); i++) {
            System.out.println((i + 1) + "." + notesMemory.get(i).toString());
        }
    }
}
