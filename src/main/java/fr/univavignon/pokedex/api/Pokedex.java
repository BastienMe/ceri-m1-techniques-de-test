package fr.univavignon.pokedex.api;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
	List<Pokemon> listPokemon;
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	
	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		Pokemon pokemon = listPokemon.get(index);
	
		PokemonMetadata pokemonMetadata = new PokemonMetadata(pokemon.getIndex(), pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());
		return pokemonMetadata;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		Pokemon pokemon = new Pokemon(index, listPokemon.get(index).getName(), listPokemon.get(index).getAttack(),
				listPokemon.get(index).getDefense(), listPokemon.get(index).getStamina(),
				cp, hp, dust, candy, listPokemon.get(index).getIv());
		return pokemon;
	}

	@Override
	public int size() {
		
		return listPokemon.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		
		for(int i = 0; i < size(); i++) {
			if(listPokemon.get(i) == pokemon) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		
		return listPokemon.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		
		return listPokemon;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		Collections.sort(listPokemon, order);
		return listPokemon;
	}

}
