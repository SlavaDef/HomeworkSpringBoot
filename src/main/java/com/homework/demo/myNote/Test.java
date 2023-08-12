package com.homework.demo.myNote;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.homework.demo");
        NoteService noteService = context.getBean(NoteService.class);
        noteService.add(new Note(2L, "Title1", "Some Text"));
        noteService.add(new Note(2L, "Title2", "Some Text"));
        noteService.add(new Note(2L, "Title3", "Some Text"));
        noteService.add(new Note(2L, "Title4", "Some Text"));
        noteService.add(new Note(2L, "Title5", "Some Text"));
        System.out.println(noteService.listAll());
        System.out.println(noteService.getById(2L));
        noteService.deleteById(2L);
        System.out.println(noteService.listAll());
           Note note23 = new Note(2L, "Title23", "Some Text");
           noteService.add(note23);
           noteService.update(note23);
        System.out.println(noteService.listAll());
    }







}
