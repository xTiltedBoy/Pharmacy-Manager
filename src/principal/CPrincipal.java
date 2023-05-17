package principal;

import estructuraDatos.*;
import utilidades.IO_ES;
import utilidades.ValidarDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CPrincipal {

    private static final ArrayList<Cliente> CLIENTES = new ArrayList<>();
    private static final ArrayList<Producto> PRODUCTOS = new ArrayList<>();

    public static void main(String[] args) {

        menuPrincipal();

    }

    private static void menuPrincipal() {

        IO_ES.escribir("===== Menú Principal =====");
        IO_ES.escribir(" 1. Gestionar Clientes.");
        IO_ES.escribir(" 2. Gestionar Productos.");
        IO_ES.escribir(" 3. Guardar datos en fichero de texto.");
        IO_ES.escribir(" 4. Recuperar datos en fichero de texto.");
        IO_ES.escribir(" 5. Salir.");
        IO_ES.escribir("=========================");
        int op = IO_ES.leerEntero("Selecciona una opción: ", 1, 5);
        IO_ES.escribir("");

        switch (op) {

            case 1:
                gestionarClientes();
                break;
            case 2:
                gestionarProductos();
                break;
            case 3:
                try {
                    guardarDatos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 4:
                try {
                    recuperarDatos();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                System.exit(0);
                break;
        }

    }

    private static void gestionarClientes(){

        IO_ES.escribir("======= Gestionar Clientes =======");
        IO_ES.escribir(" 1. Dar de alta un cliente nuevo.");
        IO_ES.escribir(" 2. Buscar cliente por DNI.");
        IO_ES.escribir(" 3. Dar de baja un cliente.");
        IO_ES.escribir(" 4. Modificar datos del cliente.");
        IO_ES.escribir(" 5. Listar clientes.");
        IO_ES.escribir(" 6. Salir.");
        IO_ES.escribir("==================================");
        int op = IO_ES.leerEntero("Selecciona una opción: ", 1, 6);
        IO_ES.escribir("");

        switch (op) {

            case 1:
                // Dar de alta un cliente nuevo.

                // Comprobar si el id ya existe.
                String id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                for (Cliente cliente : CLIENTES) {

                    if (cliente.getId().equals(id)) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: Ya existe un cliente con ese ID.");
                        IO_ES.escribir("");

                        sleep(2);

                        gestionarClientes();

                    }

                }

                String dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                while (!ValidarDatos.validarNif(dni)) {

                    IO_ES.escribir("");
                    IO_ES.escribir("ERROR: El DNI introducido no es válido.");
                    IO_ES.escribir("");

                    dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                }

                CLIENTES.add(new Cliente(
                        id,
                        dni,
                        IO_ES.leerCadena("Introduce el nombre del cliente: "),
                        IO_ES.leerCadena("Introduce el direccion del cliente: "),
                        IO_ES.leerCadena("Introduce el telefono del cliente: ")
                ));

                IO_ES.escribir("");
                IO_ES.escribir("Cliente dado de alta correctamente.");
                IO_ES.escribir("");

                sleep(2);

                gestionarClientes();

                break;
            case 2:
                // Buscar cliente por DNI.

                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        if (cliente.getDni().equals(dni)) {

                            IO_ES.escribir("");
                            IO_ES.escribir(cliente.toString());
                            IO_ES.escribir("");

                            sleep(2);

                        } else {

                            IO_ES.escribir("");
                            IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el DNI introducido.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                }

                gestionarClientes();

                break;
            case 3:
                // Dar de baja un cliente.

                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        if (cliente.getId().equals(id)) {

                            cliente.setBaja(true);

                            IO_ES.escribir("");
                            IO_ES.escribir("Cliente dado de baja.");
                            IO_ES.escribir("");

                            sleep(2);

                        } else {

                            IO_ES.escribir("");
                            IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el ID introducido.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                }

                gestionarClientes();

                break;
            case 4:
                // Modificar datos del cliente.

                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        if (cliente.getId().equals(id)) {

                            cliente.setDni(IO_ES.leerCadena("Introduce el DNI del cliente: "));
                            cliente.setNombre(IO_ES.leerCadena("Introduce el nombre del cliente: "));
                            cliente.setDireccion(IO_ES.leerCadena("Introduce el direccion del cliente: "));
                            cliente.setTelefono(IO_ES.leerCadena("Introduce el telefono del cliente: "));

                            IO_ES.escribir("");
                            IO_ES.escribir("Cliente modificado correctamente.");
                            IO_ES.escribir("");

                            sleep(2);

                        } else {

                            IO_ES.escribir("");
                            IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el ID introducido.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                }

                gestionarClientes();

                break;
            case 5:
                // Listar clientes.

                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                } else {

                    for (Cliente cliente : CLIENTES) {

                        IO_ES.escribir(cliente.toString());
                        IO_ES.escribir("");

                    }

                }

                sleep(2);

                gestionarClientes();

                break;
            case 6:
                menuPrincipal();
                break;
        }

    }

    private static void gestionarProductos(){

        IO_ES.escribir("======= Gestionar Productos =======");
        IO_ES.escribir("1. Dar de alta un producto.");
        IO_ES.escribir("2. Buscar producto.");
        IO_ES.escribir("3. Dar de baja un producto.");
        IO_ES.escribir("4. Modificar datos del producto.");
        IO_ES.escribir("5. Listar productos.");
        IO_ES.escribir("6. Salir.");
        IO_ES.escribir("===================================");
        int op = IO_ES.leerEntero("Selecciona una opción: ", 1, 6);
        IO_ES.escribir("");

        switch (op) {

            case 1:
                // Dar de alta un producto.

                IO_ES.escribir("==== Tipo de producto =====");
                IO_ES.escribir(" 1. Medicamento.");
                IO_ES.escribir(" 2. Parafarmacia.");
                IO_ES.escribir("===========================");
                op = IO_ES.leerEntero("Selecciona una opción: ", 1, 2);
                IO_ES.escribir("");

                String codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                for (Producto producto : PRODUCTOS) {

                    if (producto.getCodigo().equals(codigo)) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: Ya existe un producto con ese código.");
                        IO_ES.escribir("");

                        sleep(2);

                        gestionarProductos();

                    }

                }

                switch (op) {
                    case 1:
                        // Medicamento.

                        PRODUCTOS.add(new Medicamento(
                                codigo,
                                IO_ES.leerCadena("Introduce el nombre del producto: "),
                                IO_ES.leerCadena("Introduce la descripcion del producto: "),
                                IO_ES.leerDecimal("Introduce el precio del producto: "),
                                IO_ES.leerEntero("Introduce el stock del producto: "),
                                selecionarTipoMedicamento(),
                                IO_ES.leerCadena("Introduce como se debe tomar el medicamento: "),
                                IO_ES.leerCadena("Introduce los efectos secundarios del medicamento: ")
                        ));

                        break;
                    case 2:
                        // Parafarmacia.

                        PRODUCTOS.add(new ParaFarmacia(
                                codigo,
                                IO_ES.leerCadena("Introduce el nombre del producto: "),
                                IO_ES.leerCadena("Introduce la descripcion del producto: "),
                                IO_ES.leerDecimal("Introduce el precio del producto: "),
                                IO_ES.leerEntero("Introduce el stock del producto: "),
                                selecionarCategoria(),
                                IO_ES.leerEntero("Introduce las dosis de cada unidad: "),
                                IO_ES.leerDecimal("Introduce el porcentaje de descuento: ")
                        ));

                        break;
                }

                IO_ES.escribir("");
                IO_ES.escribir("Producto dado de alta correctamente.");
                IO_ES.escribir("");

                sleep(2);

                gestionarProductos();

                break;
            case 2:
                // Buscar producto.

                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                    for (Producto producto : PRODUCTOS) {

                        if (producto.getCodigo().equals(codigo)) {

                            IO_ES.escribir("");
                            IO_ES.escribir(producto.toString());
                            IO_ES.escribir("");

                            sleep(2);

                        } else {

                            IO_ES.escribir("");
                            IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el código introducido.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                }

                gestionarProductos();

                break;
            case 3:
                // Dar de baja un producto.

                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");
                    Iterator<Producto> itProductos = PRODUCTOS.iterator();
                    int size = PRODUCTOS.size();

                    while (itProductos.hasNext()) {

                        if (itProductos.next().getCodigo().equals(codigo)) {

                            itProductos.remove();

                            IO_ES.escribir("");
                            IO_ES.escribir("Producto dado de baja.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                    if (size == PRODUCTOS.size()) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el código introducido.");
                        IO_ES.escribir("");

                        sleep(2);

                    }

                }

                gestionarProductos();

                break;
            case 4:
                // Modificar datos del producto.

                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    IO_ES.escribir("==== Tipo de producto =====");
                    IO_ES.escribir(" 1. Medicamento.");
                    IO_ES.escribir(" 2. Parafarmacia.");
                    IO_ES.escribir("===========================");
                    op = IO_ES.leerEntero("Selecciona una opción: ", 1, 2);
                    IO_ES.escribir("");

                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                    switch (op) {

                        case 1:
                            // Medicamento.

                            for (Producto producto : PRODUCTOS) {

                                if (producto.getCodigo().equals(codigo)) {

                                    producto.setNombre(IO_ES.leerCadena("Introduce el nombre del producto: "));
                                    producto.setDescripcion(IO_ES.leerCadena("Introduce la descripcion del producto: "));
                                    producto.setPrecio(IO_ES.leerDecimal("Introduce el precio del producto: "));
                                    producto.setUnidades(IO_ES.leerEntero("Introduce el stock del producto: "));
                                    ((Medicamento) producto).setTipoMedicamento(selecionarTipoMedicamento());
                                    ((Medicamento) producto).setComoTomar(IO_ES.leerCadena("Introduce como se debe tomar el medicamento: "));
                                    ((Medicamento) producto).setEfectosAdverso(IO_ES.leerCadena("Introduce los efectos secundarios del medicamento: "));

                                } else {

                                    IO_ES.escribir("");
                                    IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el código introducido.");
                                    IO_ES.escribir("");

                                    sleep(2);

                                }

                            }

                            break;

                        case 2:
                            // Parafarmacia.

                            for (Producto producto : PRODUCTOS) {

                                if (producto.getCodigo().equals(codigo)) {

                                    producto.setNombre(IO_ES.leerCadena("Introduce el nombre del producto: "));
                                    producto.setDescripcion(IO_ES.leerCadena("Introduce la descripcion del producto: "));
                                    producto.setPrecio(IO_ES.leerDecimal("Introduce el precio del producto: "));
                                    producto.setUnidades(IO_ES.leerEntero("Introduce el stock del producto: "));
                                    ((ParaFarmacia) producto).setCategoria(selecionarCategoria());
                                    ((ParaFarmacia) producto).setDosisUnidades(IO_ES.leerEntero("Introduce el las dosis de cada unidad: "));
                                    ((ParaFarmacia) producto).setDescuento(IO_ES.leerDecimal("Introduce el porcentaje de descuento: "));

                                } else {

                                    IO_ES.escribir("");
                                    IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el código introducido.");
                                    IO_ES.escribir("");

                                    sleep(2);

                                }

                            }

                            break;

                    }

                }

                gestionarProductos();

                break;
            case 5:
                // Listar productos.

                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    for (Producto producto : PRODUCTOS) {

                        IO_ES.escribir(producto.toString());
                        IO_ES.escribir("");

                    }

                    sleep(2);

                }

                gestionarProductos();

                break;
            case 6:
                menuPrincipal();
                break;
        }

    }

    private static void guardarDatos() throws IOException {

        try {
            FileOutputStream archivoSalida = new FileOutputStream("datos.txt");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);

            for (Cliente c : CLIENTES) {
                objetoSalida.writeObject(c);
            }

            for (Producto p : PRODUCTOS) {
                objetoSalida.writeObject(p);
            }

            objetoSalida.close();

            IO_ES.escribir("Datos guardados correctamente.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void recuperarDatos() throws IOException, ClassNotFoundException {

        try {
            FileInputStream archivoEntrada = new FileInputStream("datos.txt");
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            ArrayList<Object> objetosRecuperados = new ArrayList<>();

            while (true) {
                try {
                    Object objetoRecuperado = objetoEntrada.readObject();
                    objetosRecuperados.add(objetoRecuperado);
                } catch (EOFException e) {
                    break;
                }
            }

            for (Object objeto : objetosRecuperados) {

                if (objeto instanceof Cliente) {
                    CLIENTES.add((Cliente) objeto);
                } else if (objeto instanceof Producto) {
                    PRODUCTOS.add((Producto) objeto);
                }

            }

            objetoEntrada.close();

            IO_ES.escribir("Datos recuperados correctamente.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        }




    }

    private static TipoMedicamento selecionarTipoMedicamento() {

        try {

            IO_ES.escribir("");
            IO_ES.escribir("Tipos de medicamentos: ");
            IO_ES.escribir("");
            IO_ES.escribir("1. ANALGESICOS");
            IO_ES.escribir("2. LAXANTES");
            IO_ES.escribir("3. ANTIINFECCIOSOS");
            IO_ES.escribir("4. ANTIDEPRESIVOS");
            IO_ES.escribir("5. ANTITUSIVOS");
            IO_ES.escribir("6. MUCOLITICOS");
            IO_ES.escribir("7. ANTIACIDOS");
            IO_ES.escribir("8. ANTIULCEROSOS");
            IO_ES.escribir("9. ANTIALERGICOS");
            IO_ES.escribir("10. ANTIFIARREICOS");
            IO_ES.escribir("");

            String op = IO_ES.leerCadena("Introduce el tipo de medicamento: ");

            switch (op) {

                case "1":
                    return TipoMedicamento.ANALGESICOS;
                case "2":
                    return TipoMedicamento.LAXANTES;
                case "3":
                    return TipoMedicamento.ANTIINFECCIOSOS;
                case "4":
                    return TipoMedicamento.ANTIDEPRESIVOS;
                case "5":
                    return TipoMedicamento.ANTITUSIVOS;
                case "6":
                    return TipoMedicamento.MUCOLITICOS;
                case "7":
                    return TipoMedicamento.ANTIACIDOS;
                case "8":
                    return TipoMedicamento.ANTIULCEROSOS;
                case "9":
                    return TipoMedicamento.ANTIALERGICOS;
                case "10":
                    return TipoMedicamento.ANTIFIARREICOS;
                default:
                    return TipoMedicamento.valueOf(op.toUpperCase());

            }

        } catch (IllegalArgumentException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: El tipo de medicamento introducido no es valido. Debe seleccionar un tipo de medicamento de la lista.");
            IO_ES.escribir("");

            sleep(2);

            return selecionarTipoMedicamento();

        }

    }

    private static Categoria selecionarCategoria() {

        try {

            IO_ES.escribir("");
            IO_ES.escribir("Categorias de productos: ");
            IO_ES.escribir("");
            IO_ES.escribir("1. DENTAL");
            IO_ES.escribir("2. FACIAL");
            IO_ES.escribir("3. GELES");
            IO_ES.escribir("4. CORPORAL");
            IO_ES.escribir("5. CABELLO");
            IO_ES.escribir("6. ANTIMOSQUITOS");
            IO_ES.escribir("7. INTIMA");
            IO_ES.escribir("8. NASAL");
            IO_ES.escribir("9. OCULAR");
            IO_ES.escribir("10. BOTIQUIN");
            IO_ES.escribir("11. OIDOS");
            IO_ES.escribir("12. TOALLITAS");
            IO_ES.escribir("13. LIMPIEZA");
            IO_ES.escribir("14. HOGAR");
            IO_ES.escribir("15. MASCARILLAS");
            IO_ES.escribir("");

            String op = IO_ES.leerCadena("Introduce la categoría del producto: ");

            switch (op) {

                case "1":
                    return Categoria.DENTAL;
                case "2":
                    return Categoria.FACIAL;
                case "3":
                    return Categoria.GELES;
                case "4":
                    return Categoria.CORPORAL;
                case "5":
                    return Categoria.CABELLO;
                case "6":
                    return Categoria.ANTIMOSQUITOS;
                case "7":
                    return Categoria.INTIMA;
                case "8":
                    return Categoria.NASAL;
                case "9":
                    return Categoria.OCULAR;
                case "10":
                    return Categoria.BOTIQUIN;
                case "11":
                    return Categoria.OIDOS;
                case "12":
                    return Categoria.TOALLITAS;
                case "13":
                    return Categoria.LIMPIEZA;
                case "14":
                    return Categoria.HOGAR;
                case "15":
                    return Categoria.MASCARILLAS;
                default:
                    return Categoria.valueOf(op.toUpperCase());

            }

        } catch (IllegalArgumentException e) {

            IO_ES.escribir("");
            IO_ES.escribir("ERROR: La categoría del producto introducida no es valida. Debe seleccionar una categoría de la lista.");
            IO_ES.escribir("");

            sleep(2);

            return selecionarCategoria();

        }

    }

    private static void sleep(int segundos) {

        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
