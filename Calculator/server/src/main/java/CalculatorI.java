import MathCalc.*;
import com.zeroc.Ice.Current;

public class CalculatorI implements Calculator {
	
	@Override
	public double add(double x, double y, Current current){
		double z = x + y;
			
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return z;
	}
	
	@Override
	public double subtract(double x, double y, Current current){
		double z = x - y;		
		
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return z;
	}
	
	@Override
	public double multiply(double x, double y, Current current){
		double z = x * y;
		
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return z;
	}
	
	@Override
	public double divide(double x, double y, Current current){
		double z = x / y;
		
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return z;
	}
}