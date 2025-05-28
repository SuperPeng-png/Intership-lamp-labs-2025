package com.example.demo9.controllers;

import com.example.demo9.exceptions.ResourceNotFoundException;
import com.example.demo9.models.Note;
import com.example.demo9.repository.NoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping("/note")
    public ResponseEntity<Note> makeNote(@RequestBody Note note) {
        note.setCreatedAt(LocalDateTime.now());
        Note savedNote = noteRepository.save(note);
        return ResponseEntity.ok(savedNote);
    }
    @GetMapping("/note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note with id " + id + " not found"));
        return ResponseEntity.ok(note);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return ResponseEntity.ok(notes);
    }

}
