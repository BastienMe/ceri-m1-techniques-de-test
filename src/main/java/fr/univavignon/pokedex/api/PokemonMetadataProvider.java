package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

	public PokemonMetadataProvider() {
		
	}
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return new PokemonMetadata(index,Pokedex.listePokemons.get(index).getName() ,Pokedex.listePokemons.get(index).getAttack(),  Pokedex.listePokemons.get(index).getDefense(), Pokedex.listePokemons.get(index).getStamina());

	}

}
