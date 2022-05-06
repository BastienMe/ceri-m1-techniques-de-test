package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
	
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	public static List<Pokemon> listePokemons = new ArrayList<Pokemon>();

	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
		listePokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		listePokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return metadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		
		return listePokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		listePokemons.add(pokemon);
		return pokemon.getIndex();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		
		return listePokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		
		return listePokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		Collections.sort(listePokemons, order);
		return listePokemons;
	}

}
