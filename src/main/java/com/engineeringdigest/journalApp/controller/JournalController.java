package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.JournalEntry;
import com.engineeringdigest.journalApp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){

        return journalService.saveEntry(entry);
    }

    @GetMapping("/{username}")
    public List<JournalEntry> getEntries(@PathVariable String username){

        return journalService.getUserEntries(username);
    }
}