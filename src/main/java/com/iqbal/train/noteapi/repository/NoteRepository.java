package com.iqbal.train.noteapi.repository;

import com.iqbal.train.noteapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
