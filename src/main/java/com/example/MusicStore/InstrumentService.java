package com.example.MusicStore;

import org.springframework.stereotype.Service;

@Service
public class InstrumentService {

    private final InstrumentRepo instrumentRepo;

    public InstrumentService(InstrumentRepo instrumentRepo) {
        this.instrumentRepo = instrumentRepo;
    }

    public Instrument createInstrument(String type, String subType, String brand, String model, int price) {
        Instrument instrument = new Instrument(type, subType, brand, model, price);
        return instrumentRepo.save(instrument);
    }

    public void printInstrument(Instrument instrument) {
        System.out.println(instrument);
    }
}
