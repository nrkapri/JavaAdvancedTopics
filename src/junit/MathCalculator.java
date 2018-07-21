package junit;

public class MathCalculator {

	CalculatorService calculatorService; 
	
	public void setCalculatorService(CalculatorService calculatorService)
	{
		this.calculatorService=calculatorService;
	}
	
	 public int  add(int  a, int  b) 
	 {
		 return calculatorService.add(a, b);
	 }
	 public int  subtract(int  a, int  b)
	 {
		 return calculatorService.subtract(a, b);
	 }
	 public int  multiply(int  a, int  b) {
		return  calculatorService.multiply(a, b);
	 }
		 
	 public int  divide(int  a, int  b)
	 {
		return calculatorService.divide(a, b);
	 }
	
}
