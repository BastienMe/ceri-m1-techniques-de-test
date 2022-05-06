package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonFactory implements IPokemonFactory{
	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		new Pokemon(index, Pokedex.listePokemons.get(index).getName(), Pokedex.listePokemons.get(index).getAttack(),Pokedex.listePokemons.get(index).getDefense(), Pokedex.listePokemons.get(index).getStamina(), cp,hp, dust, candy, Pokedex.listePokemons.get(index).getIv());
		return null;
	}

}
