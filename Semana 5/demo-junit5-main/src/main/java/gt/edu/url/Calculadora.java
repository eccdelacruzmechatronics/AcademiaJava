package gt.edu.url;

public class Calculadora {

    private CalculadoraOracleCloud calculadoraOracleCloud; //pasandola como dependencias
    
  //  public Calculadora(CalculadoraOracleCloud calculadoraOracleCloud) {
    //	this.calculadoraOracleCloud = calculadoraOracleCloud; //para la inyeccion similar a los frameworks sin mockito
   // }

    public double sumar(double a, double b){ return a+b; }

    public double restar(double a, double b){ return a-b; }

    public double multiplicar(double a, double b){ return a*b; }

    public double dividir(double a, double b){ return a/b; }

    public double sumarEnLaNube(double a, double b){
        //Dependencia calculadora en la nube depende de  calculadora
        return calculadoraOracleCloud.sumarEnOracleCloud(a, b);
    }

}
