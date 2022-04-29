package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
	
	@Test
	public void testCreateTrainer() {
		IPokemonTrainerFactory mockIPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
	

		IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
		IPokedex iPokedex = iPokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
		PokemonTrainer pokemonTrainer = new PokemonTrainer("Test",Team.INSTINCT, iPokedex);
		
		when(mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory)).thenReturn(pokemonTrainer);
		
		assertEquals(pokemonTrainer, mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory));
		
	}
	
}
