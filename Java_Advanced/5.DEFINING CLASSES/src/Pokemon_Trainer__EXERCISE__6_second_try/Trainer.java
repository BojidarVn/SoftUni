package Pokemon_Trainer__EXERCISE__6_second_try;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int badges;
    private Map<String, List<Pokemon>> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.setPokemons();
        //   this.pokemons=
    }

    private void setPokemons() {
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElementType(String element) {
        return !this.pokemons.get(element).isEmpty();
    }

    public void incrementBadges(int increment) {
        this.badges += increment;
    }

    public void damagePokemons(int damage) {
        for (List<Pokemon> value : pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.takeDamage(damage);
            }
        }
        clearDeadPokemons();
    }

    private void clearDeadPokemons() {
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <= 0);
        }
    }
}
