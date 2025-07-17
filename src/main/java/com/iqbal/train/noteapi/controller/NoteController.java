package com.iqbal.train.noteapi.controller;

import com.iqbal.train.noteapi.dto.NoteRequestDto;
import com.iqbal.train.noteapi.dto.NoteResponseDto;
import com.iqbal.train.noteapi.mapper.NoteMapper;
import com.iqbal.train.noteapi.model.Note;
import com.iqbal.train.noteapi.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteResponseDto> getAllNotes() {
        return noteService.getAllNotes().stream()
                .map(NoteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NoteResponseDto getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(NoteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @PostMapping
    public NoteResponseDto createNote(@RequestBody NoteRequestDto requestDto) {
        return NoteMapper.toDto(noteService.createNote(NoteMapper.toEntity(requestDto)));
    }

    @PutMapping("/{id}")
    public NoteResponseDto updateNote(@PathVariable Long id, @RequestBody NoteRequestDto note) {
        return NoteMapper.toDto(noteService.updateNote(id, NoteMapper.toEntity(note)));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
