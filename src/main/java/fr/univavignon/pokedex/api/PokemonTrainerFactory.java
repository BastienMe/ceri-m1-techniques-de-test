package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		IPokemonMetadataProvider iPokemonMetadataProvider = null;
		IPokemonFactory iPokemonFactory = null;
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory));
	}

}
