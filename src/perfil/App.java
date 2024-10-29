package perfil;

import clinica.Paciente;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Paciente paciente = null;

        int opcion;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    paciente = nuevoPaciente();
                    break;
                case 2:
                    if (paciente != null) {
                        mostrarDatosPaciente(paciente);
                    } else {
                        System.out.println("No se encuentra un paciente registrado. Favor registrar - Opcion 1");
                    }
                    break;
                case 3:
                    if (paciente != null) {
                        mostrarMesMenor(paciente);
                    } else {
                        System.out.println("No se encuentra un paciente registrado. Favor registrar - Opcion 1");
                    }
                    break;
                case 4:
                    if (paciente != null) {
                        compararPeso(paciente);
                    } else {
                        System.out.println("No se encuentra un paciente registrado. Favor registrar - Opcion 1");
                    }
                    break;
                case 5:
                    if (paciente != null) {
                        mostrarCondicionDelPaciente(paciente);
                    } else {
                        System.out.println("No se encuentra un paciente registrado. Favor registrar - Opcion 1");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida. Por favor ingrese una opcion del menu");
            }
        } while (opcion != 6);
    }

    public static int menu() {
        System.out.println("---Clinica Contigo Aprendo---");
        System.out.println("----------------------------------");
        System.out.println("1.\tIngresar Datos del Paciente");
        System.out.println("2.\tMostrar Datos del Paciente");
        System.out.println("3.\tMes con Menor Peso del Paciente");
        System.out.println("4.\tComparar un Peso");
        System.out.println("5.\tCondicion del Paciente en el mes de Noviembre");
        System.out.println("6.\tSalir");
        System.out.println("----------------------------------");
        System.out.println("Favor ingrese una opcion para continuar...");
        return Leer.datoInt();
    }

    public static Paciente nuevoPaciente() {
        String nombrePaciente;
        int rut;
        String sexo;

        do {
            System.out.println("Ingresar el Nombre del Paciente");
            nombrePaciente = Leer.dato();

        } while (nombrePaciente.length() == 0);

        do {
            System.out.println("Ingresar el RUT del Paciente");
            rut = Leer.datoInt();

        } while (String.valueOf(rut).length() == 0);

        do {
            System.out.println("Ingresar el Sexo del Paciente");
            sexo = Leer.dato();

        } while (sexo.length() == 0);

        return new Paciente(rut, nombrePaciente, sexo);
    }

    public static void mostrarDatosPaciente(Paciente paciente) {
        System.out.println("---Datos del Paciente---");
        System.out.println("----------------------------------");
        System.out.println("Nombre del Paciente: " + paciente.getNombrePaciente());
        System.out.println("RUT: " + paciente.getRut());
        System.out.println("Sexo: " + paciente.getSexo());
        System.out.println("----------------------------------");
    }

    public static void mostrarMesMenor(Paciente paciente) {
        System.out.println("---Mes con menor peso del Paciente---");
        System.out.println("----------------------------------");
        System.out.println("Mes: " + paciente.menorPesoMensual());
        System.out.println("----------------------------------");
    }

    public static void compararPeso(Paciente paciente) {
        int peso;
        do {
            System.out.println("Ingresar el peso a comparar");
            peso = Leer.datoInt();

        } while (String.valueOf(peso).length() == 0);

        if (paciente.menosDeXKilos(peso) != null) {
            System.out.println("Meses en los que peso menos que " + peso + " kg:");
            System.out.println(Arrays.toString(paciente.menosDeXKilos(peso)));
        } else {
            System.out.println("No se encuentran meses en los que peso menos que: " + peso + " kg");
        }
    }

    public static void mostrarCondicionDelPaciente(Paciente paciente) {
        int mes = 11;
        float estatura;

        do {
            System.out.println("Ingresar la estatura del Paciente");
            estatura = Leer.datoFloat();

        } while (String.valueOf(estatura).length() == 0);

        String condicion = paciente.pesoMesX(mes, estatura);

        if (condicion != null) {
            System.out.println("La condicion del Paciente es: " + condicion + ". Peso: " + paciente.getPesoMensual(mes) + " kg");
        } else {
            System.out.println("La condicion del Paciente no puede ser evaluada.");
            System.out.println("Peso: " + paciente.getPesoMensual(mes) + "kg. IMC: " + paciente.indiceMasaCorporal(mes, estatura));
        }

    }

}