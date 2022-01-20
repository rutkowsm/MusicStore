package com.example.MusicStore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class InstrumentServiceTest {

    @Mock
    private InstrumentRepo instrumentRepo;

    @InjectMocks
    private InstrumentService instrumentService;

    @Test
    void shouldDoublePriceGuitar() {
        Instrument instrument = new Instrument("guitar", "bass", "fender", "precision", 5000);
        InstrumentService.doublePriceGuitar(instrument);
        assertThat(instrument.getPrice()).isEqualTo(10000);
    }

    @Test
    void shouldDoublePriceGuitar2() {
        Instrument instrument = new Instrument("woodwind", "saxophone", "yamaha", "yas250", 3000);
        InstrumentService.doublePriceGuitar(instrument);
        assertThat(instrument.getPrice()).isEqualTo(3000);
    }

    @Test
    void isPricePositive() {
        Instrument instrument = new Instrument("test", "test", "test", "test", 1);
        assertThat(instrument.getPrice()).isNotNegative().isNotZero();
    }

    @Test
    void shouldChangeType(){
        Instrument instrument = new Instrument("test", "test", "test", "test", 1);
        InstrumentService.updateType(instrument);
        assertThat(instrument.getInstType()).isEqualTo("Unknown");

        Instrument instrument1 = new Instrument("TEST", "test", "test", "test", 1);
        InstrumentService.updateType(instrument1);
        assertThat(instrument1.getInstType()).isEqualTo("Unknown");

        Instrument instrument2 = new Instrument("null", "test", "test", "test", 1);
        InstrumentService.updateType(instrument2);
        assertThat(instrument2.getInstType()).isEqualTo("Unknown");

        Instrument instrument3 = new Instrument("NULL", "test", "test", "test", 1);
        InstrumentService.updateType(instrument3);
        assertThat(instrument3.getInstType()).isEqualTo("Unknown");
    }

    @Test
    void shouldChangeType2(){
        Instrument instrument4 = new Instrument("", "test", "test", "test", 1);
        InstrumentService.updateType(instrument4);
        assertThat(instrument4.getInstType()).isEqualTo("Unknown");
    }

    @Test
    void shouldChangeNullType() {
        Instrument instrument = new Instrument("", "test", "test", "test", 1);
        InstrumentService.updateNullType(instrument);
        assertThat(instrument.getInstType()).isEqualTo("Unknown");
    }


}
