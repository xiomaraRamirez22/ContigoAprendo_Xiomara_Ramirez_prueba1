package perfil;

import clinica.Paciente;

import java.util.Arrays;

public class App_tests {

    public static void main(String[] args) {
        int pesoComparar = 100;
        int mes = 3;
        float estatura = 1.70f;

        //Opcion 1 Crear paciente
        Paciente paciente = new Paciente("987698987654", "Luis Perez", 'M');

        // Opcion 2 Mostrar datos del paciente
        System.out.println("----------------------------------");
        System.out.println("Datos del Paciente");

        System.out.println("Nombre del Paciente: " + paciente.getNombrePaciente());
        System.out.println("Nro de RUT: " + paciente.getRut());
        System.out.println("Sexo: " + paciente.getSexo());
        System.out.println("----------------------------------");
        paciente.mostrarPesosMensuales();
        System.out.println("----------------------------------");

        //Opcion 3 Mostrar menor peso mensual
        System.out.println("---Mes con menor peso del Paciente---");
        System.out.println("----------------------------------");
        System.out.println("Mes: " + paciente.menorPesoMensual());
        System.out.println("----------------------------------");

        //Opcion 4 Comparar pesos
        System.out.println("Meses en los que peso menos que " + pesoComparar + " kg:");
        System.out.println(Arrays.toString(paciente.menosDeXKilos(pesoComparar)));
        System.out.println("----------------------------------");

        //Opcion 5 Condicion del Paciente
        System.out.println("La condicion del Paciente es: " + paciente.pesoMesX(mes, estatura) + ". Peso: " + paciente.getPesoMensual(mes) + " kg. IMC: " + paciente.indiceMasaCorporal(mes, estatura));
        System.out.println("----------------------------------");

        //Opcion 6 Salir del Sistema
        System.out.println("Saliendo del sistema...");
        System.out.println("----------------------------------");
    }
}




