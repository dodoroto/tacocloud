package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloud3Application {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloud3Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            saveIngredientIfNotExists(repo, "FLTO", "Flour Tortilla", Type.WRAP);
            saveIngredientIfNotExists(repo, "COTO", "Corn Tortilla", Type.WRAP);
            saveIngredientIfNotExists(repo, "GRBF", "Ground Beef", Type.PROTEIN);
            saveIngredientIfNotExists(repo, "CARN", "Carnitas", Type.PROTEIN);
            saveIngredientIfNotExists(repo, "TMTO", "Diced Tomatoes", Type.VEGGIES);
            saveIngredientIfNotExists(repo, "LETC", "Lettuce", Type.VEGGIES);
            saveIngredientIfNotExists(repo, "CHED", "Cheddar", Type.CHEESE);
            saveIngredientIfNotExists(repo, "JACK", "Monterey Jack", Type.CHEESE);
            saveIngredientIfNotExists(repo, "SLSA", "Salsa", Type.SAUCE);
            saveIngredientIfNotExists(repo, "SRCR", "Sour Cream", Type.SAUCE);
        };
    }

    private void saveIngredientIfNotExists(
            IngredientRepository repo,
            String id,
            String name,
            Type type
    ) {
        if (!repo.existsById(id)) {
            repo.save(new Ingredient(id, name, type));
        }
    }
}