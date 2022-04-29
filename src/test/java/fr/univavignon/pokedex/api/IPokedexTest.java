package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
	@Test
	public void testSize() {
		IPokedex mockIPokedex = Mockito.mock(IPokedex.class);

		when(mockIPokedex.size()).thenReturn(8);
		
	    assertEquals(8, mockIPokedex.size());
	}
	
	@Test
	public void testAddPokemon() {
		// utiliser IpokemonFactory
		IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
		
		Pokemon pokemon = new Pokemon(0,
				"test",
				1,
				1,
				1,
				1,
				1,
				1,
				1,
				0);
		when(mockIPokedex.addPokemon(pokemon)).thenReturn(0);
		
	    assertEquals(0, mockIPokedex.addPokemon(pokemon));
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
		
		Pokemon pokemon = new Pokemon(0,
				"test",
				1,
				1,
				1,
				1,
				1,
				1,
				1,
				0);
		when(mockIPokedex.getPokemon(anyInt())).thenAnswer(input ->{
			int index = input.getArgument(0);
			if(index < 0 || index > 150)
				throw new PokedexException("jblnl");
			return pokemon;
		});
		
	    assertEquals(pokemon, mockIPokedex.getPokemon(0));
	    assertThrows(PokedexException.class,() -> mockIPokedex.getPokemon(-1));
	    assertThrows(PokedexException.class,() -> mockIPokedex.getPokemon(151));
	}
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
	@Test
	public void testGetPokemons(){
		IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
		
		List<Pokemon> listPokemon = new ArrayList<Pokemon>();
		listPokemon.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		listPokemon.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		
		when(mockIPokedex.getPokemons()).thenReturn(listPokemon);
		
	    assertEquals(listPokemon, mockIPokedex.getPokemons());
	}
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <tt>order</tt>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
	
	@Test
	public void testGetPokemons1() {
		IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
		
		
		when(mockIPokedex.getPokemons(any())).thenAnswer(input -> {
			Comparator<Pokemon> order = input.getArgument(0);
			if(order == PokemonComparators.NAME) {
				List<Pokemon> sortedListPokemon = new ArrayList<Pokemon>();
				sortedListPokemon.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
				sortedListPokemon.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
				return sortedListPokemon;
			} else if(order == PokemonComparators.CP) {
				List<Pokemon> sortedListPokemon = new ArrayList<Pokemon>();
				sortedListPokemon.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
				sortedListPokemon.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
				return sortedListPokemon;
			} else {
				List<Pokemon> sortedListPokemon = new ArrayList<Pokemon>();
				sortedListPokemon.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
				sortedListPokemon.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
				return sortedListPokemon;
			}
		});
		
		List<Pokemon> sortedListPokemonName = new ArrayList<Pokemon>();
		sortedListPokemonName.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		sortedListPokemonName.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
	    assertEquals(sortedListPokemonName.get(0).getName(), mockIPokedex.getPokemons(PokemonComparators.NAME).get(0).getName());
	    
	    List<Pokemon> sortedListPokemonCP = new ArrayList<Pokemon>();
	    sortedListPokemonCP.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
	    sortedListPokemonCP.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
	    assertEquals(sortedListPokemonCP.get(0).getCp(), mockIPokedex.getPokemons(PokemonComparators.CP).get(0).getCp());
	    
	    List<Pokemon> sortedListPokemonIndex = new ArrayList<Pokemon>();
	    sortedListPokemonIndex.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
	    sortedListPokemonIndex.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
	    assertEquals(sortedListPokemonIndex.get(0).getIndex(), mockIPokedex.getPokemons(PokemonComparators.INDEX).get(0).getIndex());
	    
	}
}
