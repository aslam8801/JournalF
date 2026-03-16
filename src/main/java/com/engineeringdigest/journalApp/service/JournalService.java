package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.entity.JournalEntry;
import com.engineeringdigest.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public JournalEntry saveEntry(JournalEntry entry, String username){
        entry.setDate(LocalDateTime.now());
        return journalRepository.save(entry);
    }

    public List<JournalEntry> getUserEntries(String username){
        return journalRepository.findByUsername(username);
    }
}