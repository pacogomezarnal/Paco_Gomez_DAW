import java.util.Scanner;


public class EjemploMetodos {
	private int numero1=0;
	private int numero2=0;
	private int ultimoNumero=0;
	private int resultado=0;

	//Este metodo solo recibe parámetros
	public void almacenarNumero(int numero,int donde){
		if(donde==1)numero1=numero;
		else numero2=numero;
		
		
		ultimoNumero=numero;
	}
	
	//Este método solo devuelve parámetros
	public int devolverUltimoNumeroIntroducido(){
		return ultimoNumero;
	}
	
	//Este método recibe y devuelve parámetros
	public int realizarOperacion(String operacion){
		switch(operacion)
		{
			case "SUMA":
			{
				resultado=numero1+numero2;
			}
			case "RESTA":
			{
				resultado=numero1-numero2;
			}
		}
		return resultado;
	}
	public static void main(String[] args) {		// TODO Auto-generated method stub
		int numero=0;
		int donde=1;
		String operacion="";
		EjemploMetodos e=new EjemploMetodos();
		
		// crea objeto Scanner para obtener la entrada de la ventana de comandos
		Scanner entrada = new Scanner( System.in );
		
		//REalizamos la operacion de forma infonita
		while (numero!=-1)
		{
			System.out.print("Escriba el primer entero: ");
			numero = entrada.nextInt();
			e.almacenarNumero(numero,donde);
			donde++;
			System.out.print("Escriba el segundo entero: ");
			numero = entrada.nextInt();
			e.almacenarNumero(numero,donde);
			donde=1;
			System.out.print("Escriba tipo de operacion (SUMA,RESTA): ");
			operacion = entrada.next();
			System.out.println(e.realizarOperacion(operacion));
			System.out.print("Desea realizar otra operacion(0) o salir (-1): ");
			numero = entrada.nextInt();
		}
	}

}
