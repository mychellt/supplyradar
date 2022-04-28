package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.persistence.model.assinatura.OfertaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {OfertaEntityMapperImpl.class})
class OfertaEntityMapperTest extends AbstractMapperTest {

    @DisplayName(value = "Deve realizar o map de Domain para Entity.")
    @Test
    void fromDomain() {
        final Oferta oferta = Fixture.from(Oferta.class).gimme("valido");
    }

    @DisplayName(value = "Deve realizar o map de Entity para Domain.")
    @Test
    void fromEntity() {
        final OfertaEntity ofertaEntity = Fixture.from(OfertaEntity.class).gimme("valido");
    }
}
