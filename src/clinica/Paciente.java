package clinica;

import java.util.ArrayList;

public class Paciente {

    //Atributos
    private String rut;
    private String nombrePaciente;
    private char sexo;
    private int[] pesoMensual;

    //Constructor
    public Paciente(String rut, String nombrePaciente, char sexo) {
        this.rut = rut; //Recibe un rut y se lo asigna al objeto
        this.nombrePaciente = nombrePaciente; //Recibe un nombre y se lo asigna al objeto
        this.sexo = sexo; //Recibe un sexo y se lo asigna al objeto
        this.pesoMensual = new int[12]; //Se Asigna el tamaño del array

        //Se rellena el array pesos con valores aleatorios
        for (int i = 0; i < pesoMensual.length; i++) { //Recorremos con for desde 0 hasta la ultima posicion del array
            pesoMensual[i] = (int) (Math.random() * (250 - 70 + 1)) + 70;
        }
    }

    public Paciente() {
    }

    public String getRut() {

        return rut;
    }

    public void setRut(String rut) {

        this.rut = rut;
    }

    public String getNombrePaciente() {

        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {

        this.nombrePaciente = nombrePaciente;
    }

    public char getSexo() {

        return sexo;
    }

    public void setSexo(char sexo) {

        this.sexo = sexo;
    }

    //Metodo para obtener un peso para un mes especifico (Pesos generados en el array)
    public int getPesoMensual(int mes) {
        return pesoMensual[mes - 1];
    }

    //Metodo creado para mostrar por consola cada mes y cada peso que se genero de manera aleatoria
    public void mostrarPesosMensuales() {
        System.out.println("Pesos por mes: ");
        for (int i = 0; i < pesoMensual.length; i++) {
            System.out.println("Mes: " + (i + 1) + " Peso: " + pesoMensual[i] + " Kg");
        }
    }

    //Menor peso mensual: metodo para determinar cual es el menor peso entre todos. Comparamos el primero con el segundo y vamos tomando el menor hasta llegar al ultimo elemento
    public int menorPesoMensual() {

        int menor = pesoMensual[0];
        int mes = 1;

        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < menor) {
                menor = pesoMensual[i];
                mes = i + 1;
            }
        }
        return mes;
    }

    // Menos de X kilos: metodo que recibe una cantidad de kilos y lo comparamos entre todos los pesos y mostramos cuales son esos meses donde el peso fue menor
    public int[] menosDeXKilos(int kilos) {
        int cantidadMeses = 0;
        int posicion = 0;

        //Calculo de cuantos meses
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < kilos) {
                cantidadMeses++;
            }
        }

        // Guarda los meses en el Array
        int[] meses = new int[cantidadMeses];
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < kilos) {
                meses[posicion] = i + 1;
                posicion++;
            }
        }

        if (meses.length != 0) {
            return meses;
        } else return null;
    }

    //Indice de masa corporal: metodo que recibe un mes y una estatura y calculamos el indice de masa corporal con la formula especifica
    public float indiceMasaCorporal(int mes, float estatura) {
        float indice = pesoMensual[mes - 1] / (estatura * estatura);
        return indice;
    }

    // Peso X Mes: tomamos el indice corporal y en base a unos rangos devolvemos si es normal, sobrepeso u obeso
    public String pesoMesX(int mes, float estatura) {
        float indice = indiceMasaCorporal(mes, estatura);

        if (15 <= indice && indice < 20) {
            return "Normal";
        } else if (20 <= indice && indice < 28) {
            return "Sobrepeso";
        } else if (indice >= 28) {
            return "Obeso";
        } else return null;
    }
}
