package com.example.MusicStore;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class InstrumentService {

    private final InstrumentRepo instrumentRepo;

    public InstrumentService(InstrumentRepo instrumentRepo) {
        this.instrumentRepo = instrumentRepo;
    }

    public Instrument createInstrument(String instType, String subType, String brand, String model, int price) {
        Instrument instrument = new Instrument(instType, subType, brand, model, price);
        return instrumentRepo.save(instrument);
    }

    public void printInstrument(Instrument instrument) {
        System.out.println(instrument);
    }

    public Instrument findById (Long instId) {
        Optional<Instrument> byId = instrumentRepo.findById(instId);
        return byId.orElse(null);
    }

//    public Instrument updatePrice(Instrument instrument, Long instId, int newPrice) {
//        Optional<Instrument> oldInst = instrumentRepo.findById(instId);
//        instrument.setPrice(instrument.getPrice(newPrice));
//    }
}
