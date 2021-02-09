package Pokemon_trainer__EXERCISE_tirth_try;

import java.util.ArrayList;
import java.util.HashMap;
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

    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }

    public int getBadges(){
        return this.badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElemntType(String element) {
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

       this.clearDeadPokemon();

    }

    private void clearDeadPokemon() {
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int getPokemonCount() {
        int size=0;
        for (List<Pokemon> value : pokemons.values()) {
            size+=value.size();
        }
        return size;
    }

    //@Override
    public String toSting() {
        return String.format("%s %d %d", this.name,this.badges, this.getPokemonCount());
    }
}
