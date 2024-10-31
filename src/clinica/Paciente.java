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


    public int getPesoMensual(int mes) {
        return pesoMensual[mes - 1];
    }

    //Metodo Peso mensual
    public void mostrarPesosMensuales() {
        System.out.println("Pesos por mes: ");
        for (int i = 0; i < pesoMensual.length; i++) {
            System.out.println("Mes: " + (i + 1) + " Peso: " + pesoMensual[i] + " Kg");
        }
    }

    //Menor peso mensual:
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

    // Menos de X kilos:
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

    //Indice de masa corporal:
    public float indiceMasaCorporal(int mes, float estatura) {
        float indice = pesoMensual[mes - 1] / (estatura * estatura);
        return indice;
    }

    // Peso X Mes:
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
