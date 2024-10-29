package clinica;

import java.util.ArrayList;

public class Paciente {
    //Atributos

    private int rut;
    private String nombrePaciente;
    private String sexo;
    private int[] pesoMensual;

    public Paciente(int rut, String nombrePaciente, String sexo) {
        this.rut = rut;
        this.nombrePaciente = nombrePaciente;
        this.sexo = sexo;
        this.pesoMensual = new int[12];

        for (int i = 0; i < pesoMensual.length; i++) {
            pesoMensual[i] = (int) (Math.random() * (251 - 70) + 1);
        }
    }

    public Paciente() {
    }

    public int getRut() {

        return rut;
    }

    public void setRut(int rut) {

        this.rut = rut;
    }

    public String getNombrePaciente() {

        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {

        this.nombrePaciente = nombrePaciente;
    }

    public String getSexo() {

        return sexo;
    }

    public void setSexo(String sexo) {

        this.sexo = sexo;
    }

    public int getPesoMensual(int mes) {

        return pesoMensual[mes - 1];
    }

    //Menor peso mensual

    public int menorPesoMensual() {

        int menor = 250;
        int mes = 1;

        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < menor) {
                menor = pesoMensual[i];
                mes = i + 1;
            }
        }
        return mes;
    }

    //Indice de masa corporal

    public float indiceMasaCorporal(int mes, float estatura) {
        float indice = pesoMensual[mes - 1] / (estatura * estatura);
        return indice;
    }

    // Menos de X kilos

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

    // Peso X Mes

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
