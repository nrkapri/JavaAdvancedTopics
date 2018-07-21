package junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathCalculatorTester {

	@InjectMocks 
	MathCalculator mcalc = new MathCalculator();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void testAdd()
	{
		when(calcService.add(10, 20)).thenReturn(30);
		assertEquals(mcalc.add(10, 20),30);
		//verify call to calcService is made or not with same arguments.
		verify(calcService).add(10, 21);
		
		//check if add function is called three times
	      verify(calcService, times(3)).add(10, 20);
	      
	      //verify that method was never called on a mock
	      verify(calcService, never()).multiply(10,20);
		
	}
}
