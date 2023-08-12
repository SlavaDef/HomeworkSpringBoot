package com.homework.demo.myNote;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoteMapService {

    private final Map<Long, Note> noteMap;

    private final Scanner scanner = new Scanner(System.in);

    public NoteMapService() {
        noteMap = new HashMap<>();
    }


    Map<Long, Note> listAll() {
        return noteMap;

    }

    Note add(Note note) {
        note.setId(noteMap.size() + 1L);
        noteMap.put(note.getId(), note);
        return note;
    }

    void deleteById(long id) {
        Note note = noteMap.get(id);
        if (note == null) {
            throw new EmptyStackException();
        } else {
            noteMap.remove(id, note);
        }
    }

    void update(Note note) {
        if (noteMap.containsKey(note.getId())) {
            note.setTitle(scanner.next());
            note.setContent(scanner.next());
            scanner.close();
        } else throw new EmptyStackException();
    }

    Note getById(long id) {
        Note note = noteMap.get(id);

        if (note == null) {
            throw new EmptyStackException();
        }
        return note;
    }

}
