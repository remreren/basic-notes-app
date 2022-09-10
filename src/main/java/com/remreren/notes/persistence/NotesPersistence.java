package com.remreren.notes.persistence;

import com.remreren.notes.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesPersistence {

    private final List<Note> notesMemory = new ArrayList<>();

    public void saveNote(Note note) {
        notesMemory.add(note);
    }

    public Note getNote(Integer id) {
        return notesMemory.get(id - 1);
    }

    public void deleteNote(Integer id) {
        notesMemory.remove(id - 1);
    }

    public Note updateNote(Integer id, String title, String content) {
        Note note = notesMemory.get(id - 1).update(title, content);
        notesMemory.set(id - 1, note);
        return note;
    }

    public List<Note> getNotes() {
        return notesMemory;
    }
}
