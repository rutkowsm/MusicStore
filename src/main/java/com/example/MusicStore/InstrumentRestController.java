package com.example.MusicStore;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")

public class InstrumentRestController {

    private final InstrumentService instrumentService;


    public InstrumentRestController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public ResponseEntity<String> printWelcome() {
        return ResponseEntity.ok("Welcome to the Music Store!");
    }

    @GetMapping("/create")
    public ResponseEntity<Instrument> getInstrument(){
        return ResponseEntity.ok(instrumentService.createInstrument("Guitar", "Acoustic", "Guild", "ACJE350", 4999));
    }

    @GetMapping("/find")
    public ResponseEntity<Instrument> findInstrument(){
        return ResponseEntity.ok(instrumentService.findById(1L));
    }
}
