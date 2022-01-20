package com.example.MusicStore;

import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    public List<Instrument> getAllByType(String instType) {
        List<Instrument> instruments = new ArrayList<>();
        for (Instrument instrument : instruments){
            if (instrument.getInstType().equalsIgnoreCase(instType)) {
                instruments.add(instrument);
            }
        }
        return instruments;
    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepo.findAll();
    }


}
