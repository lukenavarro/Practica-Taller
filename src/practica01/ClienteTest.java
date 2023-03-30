package practica01;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

public class ClienteTest {
    public static void menu(){
        Scanner scan  = new Scanner(System.in);
        System.out.println("""
                ¿Que desea hacer?
                1.Gestionar los clientes
                2.Gestionar los vehiculos
                3.Gestionar las reparaciones
                0.Salir de la aplicación""");
        int option = scan.nextInt();
        scan.nextLine();
        while(option!=0){
            switch (option) {
                case 1 -> menuClientes(scan);
                case 2 -> System.out.println("""
                        Opciones de vehiculos
                        1.
                        2.
                        3.""");
                case 3 -> System.out.println("""
                        Opciones de reparaciones
                        1.
                        2.
                        3.""");
                default -> System.out.println("Opcion incorrecta");
            }
            System.out.println("""
                ¿Desea hacer algo mas?
                1.Gestionar los clientes
                2.Gestionar los vehiculos
                3.Gestionar las reparaciones
                0.Salir de la aplicación""");
            option = scan.nextInt();
            scan.nextLine();
            scan.nextLine();
        }

    }
    public static void menuClientes(Scanner scan){
        ArrayList<Cliente> arrayClientes = new ArrayList<>();
        System.out.println("""
                Opciones de Clientes:
                1.Insertar Cliente
                2.Buscar Cliente
                3.Modificar Cliente
                4.Borrar Cliente
                0.Para salir del submenu""");
        int option = scan.nextInt();
        scan.nextLine();
        while(option!=0){
            switch (option){
                case 1 ->insertarCliente(arrayClientes,scan);
                case 2 ->buscarCliente(arrayClientes,scan);
                case 3 ->modificarCliente(arrayClientes,scan);
                case 4 ->borrarCliente(arrayClientes,scan);
                case 5 -> mostrarClientes(arrayClientes);
                default -> System.out.println("Opcion invalida");
            }
            System.out.println("""
                Opciones de Clientes:
                1.Insertar Cliente
                2.Buscar Cliente
                3.Modificar Cliente
                4.Borrar Cliente
                5.Ver Clientes dados de alta
                0.Para salir del submenu""");
            option = scan.nextInt();
            scan.nextLine();
        }
        mostrarClientes(arrayClientes);
    }
    public static void buscarCliente(ArrayList<Cliente> aCliente,Scanner scan){
        System.out.println("""
                ¿Con que parametro desea buscar al Cliente?
                1.DNI
                2.Nombre y Apellidos
                0.Salir de la opcion
                """);
        int option = scan.nextInt();
        scan.nextLine();
        String tempDNI;
        String tempNombre;
        String tempApellidos;
        Predicate<Cliente> cDNI;
        Predicate<Cliente>cNombre;
        Predicate <Cliente>cApellidos;
        while (option != 0) {
            switch (option) {
                case 1 -> {
                    System.out.println("Introduce el DNI del cliente a buscar");
                    tempDNI = scan.nextLine();
                    String finalTempDNI = tempDNI;
                    cDNI = cliente -> cliente.getDni().equals(finalTempDNI);
                    if (aCliente.stream().anyMatch(cDNI)) {
                        System.out.println("Cliente encontrado con esos parametros.");
                    } else {
                        System.out.println("Cliente no encontrado con esos parametros.");
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el nombre del Cliente");
                    tempNombre = scan.nextLine();
                    String finalTempNombre = tempNombre;
                    cNombre = cliente -> cliente.getNombre().equals(finalTempNombre);
                    System.out.println("Introduce los apellidos del cliente a buscar");
                    tempApellidos = scan.nextLine();
                    String finalTempApellidos = tempApellidos;
                    cApellidos = cliente -> cliente.getApellidos().equals(finalTempApellidos);
                    if (aCliente.stream().anyMatch(cNombre) && aCliente.stream().anyMatch(cApellidos)) {
                        System.out.println("Cliente encotnrado mediante esos parametros");
                    } else {
                        System.out.println("Ese cliente no existe.");
                    }
                }
                default -> System.out.println("Opcion no valida");
            }
            System.out.println("""
                ¿Desea buscar otro cliente? de ser asi ¿Que parametro desea?
                1.DNI
                2.Nombre y Apellidos
                0.Salir de la opcion
                """);
            option = scan.nextInt();
            scan.nextLine();
        }
    }
    private static void borrarCliente(ArrayList<Cliente> arrayClientes, Scanner scan) {
        System.out.println("Selecciona la id del cliente que deseas borrar");
        mostrarClientes(arrayClientes);
        int id = scan.nextInt();
        scan.nextLine();
        arrayClientes.remove(id-1);
        System.out.println("Cliente con id "+id+" borrado");
    }

    public static void insertarCliente(ArrayList<Cliente> a1, Scanner scan){
        String tempDni;
        String tempNombre;
        String tempApellidos;
        int tempEdad;
        System.out.println("Introduce el DNI del cliente");
        tempDni= scan.nextLine();
        System.out.println("Introduce el nombre del cliente");
        tempNombre= scan.nextLine();
        System.out.println("Introduce los apellidos del cliente");
        tempApellidos = scan.nextLine();
        System.out.println("Introduce la edad del cliente");
        tempEdad=scan.nextInt();
        scan.nextLine();
        a1.add(new Cliente(tempDni,tempNombre,tempApellidos,tempEdad));

    }
    public static void modificarCliente(ArrayList<Cliente> aCliente,Scanner scan){
        mostrarClientes(aCliente);
        String tempText;
        int tempNumber;
        System.out.println("¿Que cliente desea modificar? Escoja su ID");
        int id = scan.nextInt();
        scan.nextLine();
        Cliente tempCliente = aCliente.get(id-1);
        System.out.println("¿Que desea modificar de este cliente?");
        System.out.println("""
                1.DNI
                2.Nombre
                3.Apellidos
                4.Edad
                0.Salir de la opcion
                """);
        int option = scan.nextInt();
        scan.nextLine();
        while(option!=0){
            //TO Do implementar el metodo, modificar segun param y repetir menu
            switch (option){
                case 1:
                    System.out.println("Introduzca el nuevo DNI del usuario:");
                    tempText = scan.nextLine();
                    tempCliente.setDni(tempText);
                    break;
                case 2:
                    System.out.println("Introduzca el nuevo Nombre del Cliente");
                    tempText = scan.nextLine();
                    tempCliente.setNombre(tempText);
                    break;
                case 3:
                    System.out.println("Introduzca los nuevos apellidos del cliente:");
                    tempText= scan.nextLine();
                    tempCliente.setApellidos(tempText);
                    break;
                case 4:
                    System.out.println("Introduzca la nueva edad del cliente:");
                    tempNumber = scan.nextInt();
                    scan.nextLine();
                    tempCliente.setEdad(tempNumber);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println("""
                ¿Desea hacer algo mas?
                1.DNI
                2.Nombre
                3.Apellidos
                4.Edad
                0.Salir de la opcion
                """);
            option = scan.nextInt();
        }
    }
    public static void mostrarClientes(ArrayList<Cliente> aCliente){
        for (int i = 0 ;i<aCliente.size();i++){
            System.out.println("ID : "+(i+1)+" "+aCliente.get(i).toString());
        }
    }
    public static void main(String [] args){
        Cliente c1 = new Cliente("77243850Y","Francisco", "Navarro De Juan",22);
        System.out.println(c1.toString());
        Vehiculo v1 = new Vehiculo("2191 YBH","Seat","Leon",2005,"Blanco");
        Reparacion r1 = new Reparacion(c1,v1,"Fallo en la bateria del coche",
                new Date(2005, Calendar.SEPTEMBER,25), 20,250);
        System.out.println(r1.toString());
        menu();
    }
}
