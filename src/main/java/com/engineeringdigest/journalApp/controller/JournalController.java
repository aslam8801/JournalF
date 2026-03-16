package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.JournalEntry;
import com.engineeringdigest.journalApp.service.JournalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public JournalEntry createEntry(
            @RequestBody JournalEntry entry,
            Authentication authentication
    ) {

        String username = authentication.getName();

        return journalService.saveEntry(entry, username);
    }

    @GetMapping
    public List<JournalEntry> getEntries(Authentication authentication) {

        String username = authentication.getName();

        return journalService.getUserEntries(username);
    }
}