package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidtaion() { //이렇게 사용하는 구나 정도로만 알고 있어도 된다. -> spring이 알아서 해줌
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> validators = validator.validate(item);
        for (ConstraintViolation<Item> validation : validators) {
            System.out.println("validation = " + validation);
            System.out.println("validation = " + validation.getMessage());

        }
    }
}
