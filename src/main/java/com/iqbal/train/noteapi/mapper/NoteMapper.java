package com.iqbal.train.noteapi.mapper;

import com.iqbal.train.noteapi.dto.NoteRequestDto;
import com.iqbal.train.noteapi.dto.NoteResponseDto;
import com.iqbal.train.noteapi.model.Note;

public class NoteMapper {

    public static NoteResponseDto toDto(Note note) {
        return new NoteResponseDto(note.getId(), note.getTitle(), note.getContent());
    }

    public static Note toEntity(NoteRequestDto dto) {
        return Note.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    public static void updateEntity(Note note, NoteRequestDto dto) {
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
    }
}
