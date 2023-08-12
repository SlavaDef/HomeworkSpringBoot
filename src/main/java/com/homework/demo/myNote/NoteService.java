package com.homework.demo.myNote;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

@Service
public class NoteService {

    private final Scanner scanner = new Scanner(System.in);

    private final List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId(notes.size() + 1L);
        notes.add(note);
        return note;
    }

    void deleteById(long id) {
        Note note = notes.get((int) id);
        if (note == null) {
            throw new EmptyStackException();
        } else
            notes.remove(Math.toIntExact(id));
    }

    void update(Note note) {
        if (note != null) {
            note.setTitle(scanner.next());
            note.setContent(scanner.next());
            scanner.close();
        } else throw new EmptyStackException();
    }

    Note getById(long id) {
        Note note = notes.get(Math.toIntExact(id));
        if (note == null) {
            throw new EmptyStackException();
        }
        return note;
    }
}
