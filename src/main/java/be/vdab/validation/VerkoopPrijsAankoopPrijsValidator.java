package be.vdab.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerkoopPrijsAankoopPrijsValidator
        implements ConstraintValidator<VerkoopPrijsAankoopPrijs, Product>
    {
    @Override
    public boolean isValid(Product product,
            ConstraintValidatorContext context) {
        if (product == null) {
            return true;
        }
        if (product.getVerkoopPrijs() == null || product.getAankoopPrijs() == null){
            return false;
        }
        return product.getVerkoopPrijs().compareTo(product.getAankoopPrijs())>=0;
    }
}
