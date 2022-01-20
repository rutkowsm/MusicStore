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



//    public Instrument updatePrice(Long instId, int newPrice) {
//        Optional<Instrument> byId = instrumentRepo.findById(instId);
//        if(byId.isPresent()){
//            byId.get().setPrice(newPrice);
//
//        }
//        else {
//            throw new IllegalArgumentException("Instrument does not exist!");
//        }
//        return null;
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

    public String findByIdNew (Long instId) {
        boolean ifExists = ifInstrumentExists(instId);
        if (!ifExists) {
            return ("Instrument ID: " + instId + " does not exist!");
        }
        else {
            return ("Instrument ID: " + instId + " is: " + findById(instId).getBrand() + " " + findById(instId).getModel() + "; Price: " + findById(instId).getPrice() + " PLN.");
        }
    }

    public String deleteById(Long instId) {
        boolean ifExists = ifInstrumentExists(instId);
        if (!ifExists) {
            return ("Instrument ID: " + instId + " does not exist!");
        }
        else {
            instrumentRepo.deleteById(instId);
        }
        return ("Instrument: " + instId + " has been deleted!");
    }

    //    NIE DZIALA - ZWRACA PUSTA LISTE!!!!

//    public List<Instrument> getAllByType(String instType) {
//        List<Instrument> instruments = getAllInstruments();
//        List<Instrument> instByType = new ArrayList<>();
//        for (Instrument x : instruments){
//            if (x.getInstType().equalsIgnoreCase(instType)) {
//                instByType.add(x);
//            }
//        }
//        return instByType;
//    }

    public static void doublePriceGuitar(Instrument instrument) {
        int price = instrument.getPrice();
        String instType = instrument.getInstType();
        if(instType.equalsIgnoreCase("guitar")){
            instrument.setPrice(price * 2);
        }
        else {
            System.out.println("The instrument is not a guitar");
        }

    }

    public static void updateType(Instrument instrument){
        String instType = instrument.getInstType();
        if(instType.equalsIgnoreCase("null") || instType.equalsIgnoreCase("test") || instType.isEmpty() || instType.isBlank()){
            instType = "Unknown";
            instrument.setInstType(instType);
        }

        else {
            instrument.getInstType();
        }
    }

    public static void updateNullType(Instrument instrument) {
        String instType = instrument.getInstType();
        if (instType == null) {
            instType = "Unknown";
            instrument.setInstType(instType);
        }
        else {
            instrument.getInstType();
        }
    }


}
