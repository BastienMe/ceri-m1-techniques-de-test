package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
	
	@Test
	public void test() {
		IPokemonMetadataProvider mockIPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"test",1,1,1);

		try {
			
			when(mockIPokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(input -> {
				int index = input.getArgument(0);
				if(index < 0 || index > 150) {
					throw new PokedexException("Index invalide"); 
				} else {
					return pokemonMetadata;
				}
			});
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			assertEquals(pokemonMetadata, mockIPokemonMetadataProvider.getPokemonMetadata(0));
			assertThrows(PokedexException.class,() -> mockIPokemonMetadataProvider.getPokemonMetadata(-1));
			assertThrows(PokedexException.class,() -> mockIPokemonMetadataProvider.getPokemonMetadata(151));
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}
	
}
