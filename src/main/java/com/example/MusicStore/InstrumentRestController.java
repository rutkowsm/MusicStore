package com.example.MusicStore;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/present")
    public ResponseEntity<Instrument> printInstrument() {
        return ResponseEntity.ok(instrumentService.createInstrument("Woodwind", "Saxophone", "Selmer",
                "Mark VI", 25900));
    }

    @GetMapping("/create")
    public ResponseEntity<Instrument> getInstrument(){
        return ResponseEntity.ok(instrumentService.createInstrument("Guitar", "Acoustic", "Guild", "ACJE350", 4999));
    }

    @GetMapping("/create/{instType}/{subType}/{brand}/{model}/{price}")
    public ResponseEntity<Instrument> getInstrument(@PathVariable String instType, @PathVariable String subType,
                                                    @PathVariable String brand, @PathVariable String model, @PathVariable int price){
        return ResponseEntity.ok(instrumentService.createInstrument(instType, subType, brand, model, price));
    }

    @GetMapping("/find")
    public ResponseEntity<Instrument> findInstrument(){
        return ResponseEntity.ok(instrumentService.findById(1L));
    }

    @GetMapping("/find/{instId}")
    public ResponseEntity<Instrument> findInstrument(@PathVariable Long instId) {
        return ResponseEntity.ok(instrumentService.findById(instId));
    }

//    @GetMapping("/changeprice/{instId}/{newPrice}")
//    public void changePrice(@PathVariable Long instId, @PathVariable int newPrice) {
//        changePrice(instId, newPrice);
//    }

    @GetMapping("/updateprice/{instId}/{newPrice}")
    public ResponseEntity<Instrument> updatePrice(@PathVariable Long instId, @PathVariable int newPrice) {
        return ResponseEntity.ok(instrumentService.updatePrice(instId, newPrice));
    }

    //    NIE DZIALA - ZWRACA PUSTA LISTE!!!!

//    @GetMapping("/all/{instType}")
//    public ResponseEntity<List<Long>> getAllByType(@PathVariable String instType) {
//        return (ResponseEntity<List<Long>>) instrumentService.getAllByType(instType);
//    }

    @GetMapping("/all")
    public List<Instrument> getAllInstruments() {return instrumentService.getAllInstruments();
    }

    @GetMapping("/brands")
    public ResponseEntity<List<String>> findAllBrands() {
        return ResponseEntity.ok(instrumentService.findAllBrands());
    }

    @GetMapping("/delete/{instId}")
    public String deleteById(@PathVariable Long instId) {
        return instrumentService.deleteById(instId);
    }
}
