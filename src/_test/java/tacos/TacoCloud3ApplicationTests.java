package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tacos.data.OrderRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TacoCloud3ApplicationTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void savesOrderWithTacosAndIngredients() {
        Taco taco = new Taco();
        taco.setName("tacosal");
        taco.getIngredients().add(new IngredientRef("FLTO"));
        taco.getIngredients().add(new IngredientRef("CARN"));
        taco.getIngredients().add(new IngredientRef("JACK"));
        taco.getIngredients().add(new IngredientRef("TMTO"));
        taco.getIngredients().add(new IngredientRef("SLSA"));

        TacoOrder order = new TacoOrder();
        order.setDeliveryName("heungmin");
        order.setDeliveryStreet("baker");
        order.setDeliveryCity("tottenham");
        order.setDeliveryState("UK");
        order.setDeliveryZip("12345");
        order.setCcNumber("12345");
        order.setCcExpiration("08/27");
        order.setCcCVV("223");
        order.addTaco(taco);

        TacoOrder saved = orderRepository.save(order);

        assertThat(saved.getId()).isNotNull();
    }

}
