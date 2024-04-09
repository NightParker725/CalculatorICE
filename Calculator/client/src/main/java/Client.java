import java.util.Scanner;
public class Client
{
 public static void main(String[] args)
 {
 try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
 {
 com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimpleCalculator:tcp -h localhost -p 10000");
 MathCalc.CalculatorPrx calculator = MathCalc.CalculatorPrx.checkedCast(base);
 if(calculator == null)
 {
 throw new Error("Invalid proxy");
 }
 boolean exe = true;
 Scanner sc = new Scanner(System.in);
 while (exe){
	System.out.println("Bienvenido a la calculadora, seleccione la operacion a realizar: ");
	System.out.println("1: Suma ");
	System.out.println("2: Resta ");
	System.out.println("3: Multiplicacion ");;
	System.out.println("4: Division ");
	System.out.println("5: Salir ");
	int op = sc.nextInt();
	sc.nextLine();
	if (op == 5){
		System.out.println("Hasta pronto!");
		exe = false;
	}
	else{
		System.out.println("Por favor ingrese el primer digito a operar: ");
		int num1 = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor ingrese el segundo digito a operar: ");
		int num2 = sc.nextInt();
		sc.nextLine();
		double result = 0;
		switch (op){
			case 1:
				result = calculator.add(num1,num2);
				System.out.println("El resultado es: " + result);
				break;
			case 2:
				result = calculator.subtract(num1,num2);
				System.out.println("El resultado es: " + result);
				break;
			case 3:
				result = calculator.multiply(num1,num2);
				System.out.println("El resultado es: " + result);
				break;
			case 4:
				result = calculator.divide(num1,num2);
				System.out.println("El resultado es: " + result);
				break;
			default:
				System.out.println("Error");
				break;
		}
	}
 }
 }
}
}