package com.example.MusicStore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

//    public void changePrice(Instrument instrument, Long instId, int newPrice) {
//        if(instrument.getInstId() == instId) {
//            instrument.setPrice(newPrice);
//        }
//        else {
//            throw new IllegalArgumentException("No such instrument exists!");
//        }
//    }

    public Instrument updatePrice(Long instId, int newPrice) {
        Optional<Instrument> byId = instrumentRepo.findById(instId);
        if(byId.isPresent()){
            byId.get().setPrice(newPrice);

        }
        else {
            throw new IllegalArgumentException("Instrument does not exist!");
        }
        return null;
    }

//    NIE DZIALA - ZWRACA PUSTA LISTE!!!!

//    public List<Long> getAllByType(String instType) {
//        List<Instrument> instruments = instrumentRepo.findAll();
//        List<Long> instByType = new ArrayList<>();
//        for (Instrument x : instruments){
//            if (x.getInstType().equalsIgnoreCase(instType)) {
//                instByType.add(x.getInstId());
//            }
//        }
//        return instByType;
//    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepo.findAll();
    }

    public boolean ifInstrumentExists (Long instId) {
        return instrumentRepo.existsById(instId);
    }

    public List<String> findAllBrands() {
        List<Instrument> allInst = instrumentRepo.findAll();
        List<String> brands = new ArrayList<>();
        for (Instrument x: allInst) {
            brands.add(x.getBrand());
        }
        return brands;
    }

        public String deleteById(Long instId) {
        boolean ifExists = ifInstrumentExists(instId);
        if (!ifExists) {
            throw new IllegalArgumentException("Instrument does not exist!");
        }
        else {
            instrumentRepo.deleteById(instId);
        }
        return ("Instrument: " + instId + " has been deleted!");
    }
}
