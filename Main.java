import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Bicicleta> listaBicicletas = new ArrayList<>();
    static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();
    static ArrayList<Servicio> listaServicios = new ArrayList<>();
    static boolean servicios = false;

    public static void main(String[] args) {
        String nombreMecanico = "";
        Scanner sc = new Scanner(System.in);

        Mecanico mecanicoUno = new Mecanico("1", "Jose", "Frenos", "#2025123");
        listaMecanicos.add(mecanicoUno);
        Mecanico mecanicoDos = new Mecanico("2", "Stiven", "Suspension", "#2017234");
        listaMecanicos.add(mecanicoDos);
        Mecanico mecanicoTres = new Mecanico("3", "William", "Bicicletas electricas", "#1102553");
        listaMecanicos.add(mecanicoTres);

        while (true) {
            LocalDate fechaBusqueda = null;
            LocalTime horaBusqueda = null;
            LocalDate fecha = null;

            System.out.println("\n****************************************************************");
            System.out.println("*   Que desea hacer: ");
            System.out.println("*");
            System.out.println("*   1. Registrar cliente.");
            System.out.println("*   2. Listar clientes.");
            System.out.println("*   3. Registrar bicicleta.");
            System.out.println("*   4. Listar bicicletas.");
            System.out.println("*   5. Crear orden de servicio.");
            System.out.println("*   6. Listar servicios.");
            System.out.println("*   7. Consultar ordernes programadas por fecha.");
            System.out.println("*   8. Ver historial de servicios por serial.");
            System.out.println("****************************************************************");
            
            System.out.print("\nOpcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nNombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cedula: ");
                    String cedula = sc.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();

                    Cliente cliente = new Cliente(nombre, cedula, telefono, direccion);
                    listaClientes.add(cliente);
                    System.out.println("\n* Cliente registrado con exito");
                    break;

                case 2:
                    if (listaClientes.isEmpty()) {
                        System.out.println("\n* No hay ningun cliente registrado.");
                    } else {
                        System.out.println("\n* Los clientes registrados son: \n");
                        for (Cliente c : listaClientes) {
                            System.out.print(c.mostrarInfo());
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nMarca: ");
                    String marca = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Color: ");
                    String color = sc.nextLine();

                    System.out.print("Serial: ");
                    String serial = sc.nextLine();

                    System.out.print("Año: ");
                    String año = sc.nextLine();

                    System.out.print("Cedula del cliente asociado: ");
                    String cedulaCliente = sc.nextLine();

                    if (existeCliente(cedulaCliente)) {
                        Bicicleta bici = new Bicicleta(marca, tipo, color, serial, año, cedulaCliente);
                        listaBicicletas.add(bici);
                        System.out.println("\n* Bicicleta registrada con exito");
                    } else {
                        System.out.println("\n* Error: no existe cliente con esa cédula.");
                    }
                    break;

                case 4:
                    if (listaBicicletas.isEmpty()) {
                        System.out.println("\n* No hay ninguna bicicleta registrada.");
                    } else {
                        System.out.println("\n* Las bicicletas registradas son: \n");
                        for (Bicicleta b : listaBicicletas) {
                            System.out.print(b.mostrarInfo());
                        }
                    }
                    break;

                case 5:
                    while (fechaBusqueda == null || fechaBusqueda == null) {
                        System.out.print("\nIngrese fecha del servicio (YYYY-MM-DD): ");
                        String fechaTexto = sc.nextLine();

                        System.out.print("Ingrese hora del servicio (HH:mm): ");
                        String horaTexto = sc.nextLine();

                        try {
                            fechaBusqueda = LocalDate.parse(fechaTexto);
                            horaBusqueda = LocalTime.parse(horaTexto);
                        } catch (DateTimeParseException e) {
                            System.out.println("\n* Formato de fecha u hora invalido. Intentalo nuevamente.");
                        }
                    }
                    
                    System.out.print("Ingrese el serial de la bicicleta: ");
                    String serialServicio = sc.nextLine();

                    if (!existeBicicleta(serialServicio)) {
                        System.out.println("\n* Error: no hay bicicleta registrada con ese serial.");
                        break;
                    }

                    System.out.print("\n* Mecanicos Disponibles: \n");
                    for(Mecanico m : listaMecanicos){
                        System.out.println(m.mostrarInfo());
                    }

                    System.out.print("Ingrese el id del mecanico a usar: ");
                    String idMecanico = sc.nextLine();

                    if (existeMecanico(idMecanico)) {
                        nombreMecanico = buscarMecanico(idMecanico);
                    } else {
                        System.out.println("\n* No existe el mecanico ingresado.");
                        break;
                    }

                    System.out.print("Ingrese el motivo del servicio: ");
                    String motivo = sc.nextLine();

                    System.out.print("Ingrese el diagnostico del servicio: ");
                    String diagnostico = sc.nextLine();

                    System.out.print("Ingrese los trabajos realizados a la bicicleta: ");
                    String trabajosRea = sc.nextLine();

                    System.out.print("Ingrese el costo del servicio: ");
                    double costoServicio = sc.nextDouble();

                    Servicio servicio = new Servicio(fechaBusqueda, horaBusqueda, serialServicio, nombreMecanico, motivo, diagnostico, trabajosRea, costoServicio);
                    listaServicios.add(servicio);
                    System.out.println("\n* Servicio registrado con exito.");
                    break;

                case 6:
                    if (listaServicios.isEmpty()) {
                        System.out.println("\n* No hay ningun servicio registrado.");
                    } else {
                        System.out.println("\n* Los servicios registrados son: \n");
                        for(Servicio s : listaServicios){
                            System.out.print(s.mostrarInfo());
                        }
                    }
                    break;

                case 7:
                    while (fecha == null) {
                        System.out.print("\nIngrese la fecha del servicio a buscar (YYYY-MM-DD): ");
                        String buscarFecha = sc.nextLine();

                        try {
                            fecha = LocalDate.parse(buscarFecha);
                        } catch (DateTimeParseException e) {
                            System.out.println("\n* Formato de fecha incorrecto: intentelo nuevamente.\n");
                        }
                    }
                    
                    System.out.println("\n* Los servicios que hay para esta fecha son: \n");
                    buscarServicio(fecha);
                    servicios = false;
                    break;

                case 8:
                    System.out.print("\nIngrese el serial de la bicicleta a buscar: ");
                    String serialBuscar = sc.nextLine();

                    System.out.println("\n* Los servicios que hay para este serial de bicicleta son: \n");
                    buscarPorSerial(serialBuscar);
                    servicios = false;
                    break;

                default:
                    System.out.println("\n* Opción inválida.\n");
                    break;
            }
        }
    }

    public static boolean existeCliente(String cedula) {
        for (Cliente c : listaClientes) {
            if (c.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeBicicleta(String serial){
        for (Bicicleta b : listaBicicletas){
            if (b.getSerial().equals(serial)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeMecanico(String id){
        for (Mecanico m : listaMecanicos){
            if (m.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static String buscarMecanico(String id){
        for (Mecanico m : listaMecanicos){
            if (m.getId().equals(id)) {
                return m.getNombre();
            }
        }
        return "\n* No existe el mecanico ingresado\n";
    }

    public static void buscarServicio(LocalDate fecha){
        for (Servicio s : listaServicios) {
            if (s.getFecha().equals(fecha)) {
                servicios = true;
                System.out.print(s.mostrarInfo());
            }
        }

        if (!servicios) {
            System.out.println("\n* No hay ningun servicio para esta fecha.\n");
        }
    }

    public static void buscarPorSerial(String serial){
        for (Servicio s : listaServicios) {
            if (s.getBiciSerial().equals(serial)) {
                servicios = true;
                System.out.print(s.mostrarInfo());
            }
        }

        if (!servicios) {
            System.out.println("\n* No hay ningun servicio para este serial.\n");
        }
    }
}
