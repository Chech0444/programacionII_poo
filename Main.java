import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Bicicleta> listaBicicletas = new ArrayList<>();
    static ArrayList<Mecanico> listaMecanicos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mecanico mecanicoUno = new Mecanico("1", "Jose", "Frenos", "#2025123");
        listaMecanicos.add(mecanicoUno);
        Mecanico mecanicoDos = new Mecanico("2", "Stiven", "Suspension", "#2017234");
        listaMecanicos.add(mecanicoDos);
        Mecanico mecanicoTres = new Mecanico("3", "William", "Bicicletas electricas", "#1102553");
        listaMecanicos.add(mecanicoTres);

        while (true) {
            System.out.println("Que desea hacer: ");
            System.out.println("\n1. Registrar cliente.");
            System.out.println("2. Listar clientes.");
            System.out.println("3. Registrar bicicleta.");
            System.out.println("4. Listar bicicletas.");
            System.out.println("5. Crear orden de servicio.");
            
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cedula: ");
                    String cedula = sc.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();

                    Cliente cliente = new Cliente(nombre, cedula, telefono, direccion);
                    listaClientes.add(cliente);
                    System.out.println("Cliente registrado con exito");
                    break;

                case 2:
                    if (listaClientes.isEmpty()) {
                        System.out.println("No hay ningun cliente registrado.");
                    } else {
                        for (Cliente c : listaClientes) {
                            System.out.println(c.mostrarInfo());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Marca: ");
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
                        System.out.println("Bicicleta registrada con exito");
                    } else {
                        System.out.println("Error: no existe cliente con esa cédula.");
                    }
                    break;

                case 4:
                    if (listaBicicletas.isEmpty()) {
                        System.out.println("No hay ninguna bicicleta registrada.");
                    } else {
                        for (Bicicleta b : listaBicicletas) {
                            System.out.println(b.mostrarInfo());
                        }
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
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
}
