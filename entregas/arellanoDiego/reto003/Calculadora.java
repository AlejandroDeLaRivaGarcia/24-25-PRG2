package entregas.arellanoDiego.reto003;

public class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public Calculadora(int capacidad) {
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public Calculadora() {
        this(CAPACIDAD_POR_DEFECTO);
    }

    public Calculadora(double valorInicial){
        this();
        ingresarNumero(valorInicial);
    }

    public Calculadora(double[] valoresIniciales){
        this(Math.max(valoresIniciales.length, CAPACIDAD_POR_DEFECTO));
        for (double valor : valoresIniciales) {
            ingresarNumero(valor);
        }
    }

    public void calcularPorcentaje(){
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0] / 100);
        }
    }

    public void calcularFactorial(){
        if (verificarOperandos(1)) {
            double[] operandos = extraerOperandos(1);
            int n = (int) operandos[0];
            
            if (n < 0) {
                error = true;
                mensajeError = "No se puede calcular el factorial de un número negativo";
                return;
            }
            
            double resultado = 1;
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            ingresarNumero(resultado);
        }
    }

    public void calcularMaximo(){
        if (posicionActual > 0) {
            double max = numeros[0];
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] > max) {
                    max = numeros[i];
                }
            }
            limpiar();
            ingresarNumero(max);
        } else {
            error = true;
            mensajeError = "No hay números para calcular el máximo";
        }
    }


    public void calcularMinimo(){
        if (posicionActual > 0) {
            double min = numeros[0];
            for (int i = 1; i < posicionActual; i++) {
                if (numeros[i] < min) {
                    min = numeros[i];
                }
            }
            limpiar();
            ingresarNumero(min);
        } else {
            error = true;
            mensajeError = "No hay números para calcular el mínimo";
        }

    }

    public void sumar(double valor){

    }

    public void restar(double valor){

    }

    public void multiplicar(double valor){

    }

    public void dividir(double valor){

    }

    public void calcularPorcentaje(double valor){

    }

    public void intercambiar(){

    }

    public void duplicarNumero(){

    }

    public void calcularRaizCuadrada(){

    }

    public void calcularPotencia(){

    }

    public void calcularPotencia(double exponente){

    }
    


    public void ingresarNumero(double valor) {
        if (posicionActual < numeros.length) {
            numeros[posicionActual] = valor;
            posicionActual++;
        } else {
            error = true;
            mensajeError = "MEMORIA LLENA!!!";
        }
    }

    public String mostrar() {
        if (error) {
            return mensajeError;
        } else if (posicionActual > 0) {
            return "" + numeros[posicionActual - 1];
        } else {
            return "-";
        }
    }

    public String mostrarTodo() {
        String resultado = "";
        for (int i = 0; i < posicionActual; i = i + 1) {
            resultado = resultado + "[" + i + "] " + numeros[i] + "\n";
        }
        resultado = resultado + "-".repeat(10);
        return error ? mensajeError : resultado;
    }

    public void limpiar() {
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public void sumar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[0] + operandos[1]);
        }
    }

    private double[] extraerOperandos(int numeroOperandos) {
        double[] operandos = new double[numeroOperandos];
        for (int i = 0; i < numeroOperandos; i++) {
            operandos[i] = extraerOperando();
        }
        return operandos;
    }

    private double extraerOperando(){
        posicionActual--;
        return numeros[posicionActual];        
    }

    private boolean verificarOperandos(int numeroOperandos) {
        if (posicionActual >= numeroOperandos) {
            return true;
        } else {
            error = true;
            mensajeError = "Faltan operandos!";
            return false;
        }
    }

    public void invertir() {
        if (verificarOperandos(1)) {
            double[] operadores = extraerOperandos(1);
            ingresarNumero(-operadores[0]);
        }
    }

    public void restar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] - operandos[0]);
        }
    }

    public void dividir() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] / operandos[0]);
        }
    }

    public void multiplicar() {
        if (verificarOperandos(2)) {
            double[] operandos = extraerOperandos(2);
            ingresarNumero(operandos[1] * operandos[0]);
        }
    }

    public void calcularMedia() {
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        ingresarNumero(numeroDeOperandos);
        dividir();
    }

    public void calcularSumatoria() {
        int numeroDeOperandos = posicionActual;
        for (int i = 0; i < numeroDeOperandos - 1; i++) {
            sumar();
        }
    }
}