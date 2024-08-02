package be.vdab.validation;

import jakarta.validation.Validator;
import jakarta.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;

class ProductTest {
    private Validator validator;
    private Product product;
    @BeforeEach
    void beforeEach() {
        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        product = new Product();
    }
    @Test
    void correctProduct() {
        product.setAankoopPrijs(BigDecimal.ONE);
        product.setVerkoopPrijs(BigDecimal.TEN);
        assertThat(validator.validate(product)).isEmpty();
    }
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1.234", "12345678"})
    void verkeerdeAankoopPrijzen(String prijs) {
        product.setAankoopPrijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }
    @ParameterizedTest
    @ValueSource(strings = {"-10", "10.234", "12345678"})
     void verkeerdeVerkoopPrijzen(String prijs) {
        product.setVerkoopPrijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }

    @Test
    void aankoopPrijs10EnVerkoopPrijs1IsVerkeerd () {
        product.setAankoopPrijs(BigDecimal.TEN);
        product.setVerkoopPrijs(BigDecimal.ONE);
        assertThat(validator.validate(product)).isNotEmpty();
    }
}
