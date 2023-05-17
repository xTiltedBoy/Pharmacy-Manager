package principal;

import estructuraDatos.*;
import utilidades.IO_ES;
import utilidades.ValidarDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase principal del programa.
 *
 * @author Miguel Ruiz Baca
 * @version 1.0
 */

public class CPrincipal {

    /**
     * ArrayList que almacena los clientes.
     */
    private static final ArrayList<Cliente> CLIENTES = new ArrayList<>();

    /**
     * ArrayList que almacena los productos.
     */
    private static final ArrayList<Producto> PRODUCTOS = new ArrayList<>();

    /**
     * Método ejecutable de la clase principal.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        menuPrincipal();

    }

    /**
     * Gestion del menú principal del programa.
     */
    private static void menuPrincipal() {

        // Se muestran las opciones del menú principal.
        IO_ES.escribir("===== Menú Principal =====");
        IO_ES.escribir(" 1. Gestionar Clientes.");
        IO_ES.escribir(" 2. Gestionar Productos.");
        IO_ES.escribir(" 3. Guardar datos en fichero de texto.");
        IO_ES.escribir(" 4. Recuperar datos en fichero de texto.");
        IO_ES.escribir(" 5. Salir.");
        IO_ES.escribir("=========================");
        int op = IO_ES.leerEntero("Selecciona una opción: ", 1, 5);
        IO_ES.escribir("");

        // Se ejecuta la opción seleccionada.
        switch (op) {

            case 1:
                // Gestionar Clientes.
                gestionarClientes();
                break;
            case 2:
                // Gestionar Productos.
                gestionarProductos();
                break;
            case 3:
                // Guardar datos en fichero de texto.
                guardarDatos();

                break;
            case 4:
                // Recuperar datos en fichero de texto.
                recuperarDatos();

                break;
            case 5:
                // Salir.
                System.exit(0);
                break;
        }

    }

    /**
     * Gestion del menú y las opciones de gestión de clientes.
     */
    private static void gestionarClientes(){

        // Se muestran las opciones del menú de gestión de clientes.
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

        // Se ejecuta la opción seleccionada.
        switch (op) {

            case 1:
                // Dar de alta un cliente nuevo.

                // Comprobar si el id ya existe.
                String id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                for (Cliente cliente : CLIENTES) {

                    // Si el id ya existe, se muestra un mensaje de error y se vuelve a ejecutar el método.
                    if (cliente.getId().equals(id)) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: Ya existe un cliente con ese ID.");
                        IO_ES.escribir("");

                        sleep(2);

                        gestionarClientes();

                    }

                }

                String dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                // Comprueba si el DNI es válido.
                while (!ValidarDatos.validarNif(dni)) {

                    IO_ES.escribir("");
                    IO_ES.escribir("ERROR: El DNI introducido no es válido.");
                    IO_ES.escribir("");

                    dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                }

                // Crear el cliente y lo añade al ArrayList.
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

                // Si no hay clientes dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    // Se pide el DNI del cliente.
                    dni = IO_ES.leerCadena("Introduce el DNI del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        // Si el DNI introducido coincide con el DNI de un cliente, se muestra la información del cliente.
                        if (cliente.getDni().equals(dni)) {

                            mostrarDatos(cliente);

                            sleep(2);

                        } else {

                            // Si no coincide, se muestra un mensaje de error.
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

                // Si no hay clientes dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    // Se pide el ID del cliente.
                    id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        // Si el ID introducido coincide con el ID de un cliente, se da de baja al cliente.
                        if (cliente.getId().equals(id)) {

                            cliente.setBaja(true);

                            IO_ES.escribir("");
                            IO_ES.escribir("Cliente dado de baja.");
                            IO_ES.escribir("");

                            sleep(2);

                        } else {

                            // Si no coincide, se muestra un mensaje de error.
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

                // Si no hay clientes dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    boolean modificado = false;

                    // Se pide el ID del cliente.
                    id = IO_ES.leerCadena("Introduce el ID del cliente: ");

                    for (Cliente cliente : CLIENTES) {

                        // Si el ID introducido coincide con el ID de un cliente, se modifican los datos del cliente.
                        if (cliente.getId().equals(id)) {

                            cliente.setDni(IO_ES.leerCadena("Introduce el DNI del cliente: "));
                            cliente.setNombre(IO_ES.leerCadena("Introduce el nombre del cliente: "));
                            cliente.setDireccion(IO_ES.leerCadena("Introduce el direccion del cliente: "));
                            cliente.setTelefono(IO_ES.leerCadena("Introduce el telefono del cliente: "));

                            IO_ES.escribir("");
                            IO_ES.escribir("Cliente modificado correctamente.");
                            IO_ES.escribir("");

                            modificado = true;

                            sleep(2);

                        }

                    }

                    // Si no coincide, se muestra un mensaje de error.
                    if (!modificado) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: No se ha encontrado ningun cliente que se corresponda con el ID introducido.");
                        IO_ES.escribir("");

                        sleep(2);

                    }

                }

                gestionarClientes();

                break;
            case 5:
                // Listar clientes.

                // Si no hay clientes dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (CLIENTES.size() == 0) {

                    IO_ES.escribir("ERROR: No hay clientes dados de alta.");
                    IO_ES.escribir("");

                } else {

                    // Se muestran los datos de todos los clientes.
                    for (Cliente cliente : CLIENTES) {

                        mostrarDatos(cliente);

                    }

                }

                sleep(2);

                gestionarClientes();

                break;
            case 6:
                // Volver al menú principal.
                menuPrincipal();
                break;
        }

    }

    /**
     * Gestion del menú y las opciones de gestión de productos.
     */
    private static void gestionarProductos(){

        // Se muestran las opciones del menú de gestión de productos.
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

        // Se ejecuta la opción seleccionada.
        switch (op) {

            case 1:
                // Dar de alta un producto.

                // Se pide el tipo de producto a dar de alta.
                IO_ES.escribir("==== Tipo de producto =====");
                IO_ES.escribir(" 1. Medicamento.");
                IO_ES.escribir(" 2. Parafarmacia.");
                IO_ES.escribir("===========================");
                op = IO_ES.leerEntero("Selecciona una opción: ", 1, 2);
                IO_ES.escribir("");

                // Se pide el código del producto.
                String codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                for (Producto producto : PRODUCTOS) {

                    // Si el código introducido coincide con el código de un producto, se muestra un mensaje de error y se vuelve a ejecutar el método.
                    if (producto.getCodigo().equals(codigo)) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: Ya existe un producto con ese código.");
                        IO_ES.escribir("");

                        sleep(2);

                        gestionarProductos();

                    }

                }

                // Se ejecuta la opción seleccionada en la linea 377.
                switch (op) {
                    case 1:
                        // Medicamento.

                        // Se añade el producto de tipo medicamento a la lista de productos.
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

                        // Se añade el producto de tipo parafarmacia a la lista de productos.
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

                // Si no hay productos dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    // Se pide el código del producto a buscar.
                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                    for (Producto producto : PRODUCTOS) {

                        // Si el código introducido coincide con el código de un producto, se muestran los datos de ese producto.
                        if (producto.getCodigo().equals(codigo)) {

                            mostrarDatos(producto);

                            sleep(2);

                        } else {

                            // Si el código introducido no coincide con el código de ningún producto, se muestra un mensaje de error.
                            IO_ES.escribir("");
                            IO_ES.escribir("ERROR: No se ha encontrado ningun producto que se corresponda con el código introducido.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                }

                gestionarProductos();

                break;
            case 3:
                // Dar de baja un producto.

                // Si no hay productos dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    // Se pide el código del producto a dar de baja.
                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");
                    Iterator<Producto> itProductos = PRODUCTOS.iterator();
                    int size = PRODUCTOS.size();

                    while (itProductos.hasNext()) {

                        // Si el código introducido coincide con el código de un producto, se elimina ese producto de la lista de productos.
                        if (itProductos.next().getCodigo().equals(codigo)) {

                            itProductos.remove();

                            IO_ES.escribir("");
                            IO_ES.escribir("Producto dado de baja.");
                            IO_ES.escribir("");

                            sleep(2);

                        }

                    }

                    // Si no se ha eliminado ningún producto, se muestra un mensaje de error.
                    if (size == PRODUCTOS.size()) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: No se ha encontrado ningun producto que se corresponda con el código introducido.");
                        IO_ES.escribir("");

                        sleep(2);

                    }

                }

                gestionarProductos();

                break;
            case 4:
                // Modificar datos del producto.

                // Si no hay productos dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    boolean modificado = false;

                    // Se pide el código del producto a modificar.
                    codigo = IO_ES.leerCadena("Introduce el código del producto: ");

                    for (Producto producto : PRODUCTOS) {

                        // Si el código introducido coincide con el código de un producto, se modifican los datos de ese producto.
                        if (producto.getCodigo().equals(codigo)) {

                            producto.setNombre(IO_ES.leerCadena("Introduce el nombre del producto: "));
                            producto.setDescripcion(IO_ES.leerCadena("Introduce la descripcion del producto: "));
                            producto.setPrecio(IO_ES.leerDecimal("Introduce el precio del producto: "));
                            producto.setUnidades(IO_ES.leerEntero("Introduce el stock del producto: "));

                            if (producto instanceof Medicamento) {

                                ((Medicamento) producto).setTipoMedicamento(selecionarTipoMedicamento());
                                ((Medicamento) producto).setComoTomar(IO_ES.leerCadena("Introduce como se debe tomar el medicamento: "));
                                ((Medicamento) producto).setEfectosAdverso(IO_ES.leerCadena("Introduce los efectos secundarios del medicamento: "));

                            } else if (producto instanceof ParaFarmacia) {

                                ((ParaFarmacia) producto).setCategoria(selecionarCategoria());
                                ((ParaFarmacia) producto).setDosisUnidades(IO_ES.leerEntero("Introduce el las dosis de cada unidad: "));
                                ((ParaFarmacia) producto).setDescuento(IO_ES.leerDecimal("Introduce el porcentaje de descuento: "));

                            }

                            IO_ES.escribir("");
                            IO_ES.escribir("Producto modificado correctamente.");
                            IO_ES.escribir("");

                            modificado = true;

                            sleep(2);

                        }

                    }

                    // Si el código introducido no coincide con el código de ningún producto, se muestra un mensaje de error.
                    if (!modificado) {

                        IO_ES.escribir("");
                        IO_ES.escribir("ERROR: No se ha encontrado ningun producto que se corresponda con el código introducido.");
                        IO_ES.escribir("");

                        sleep(2);

                    }

                }

                gestionarProductos();

                break;
            case 5:
                // Listar productos.

                // Si no hay productos dados de alta, se muestra un mensaje de error y se vuelve a ejecutar el método.
                if (PRODUCTOS.size() == 0) {

                    IO_ES.escribir("ERROR: No hay productos dados de alta.");
                    IO_ES.escribir("");

                    sleep(2);

                } else {

                    // Se muestran los datos de todos los productos.
                    for (Producto producto : PRODUCTOS) {

                        mostrarDatos(producto);

                    }

                    sleep(2);

                }

                gestionarProductos();

                break;
            case 6:
                // Volver al menú principal.
                menuPrincipal();
                break;
        }

    }

    /**
     * Guarda los datos de los clientes y los productos en un fichero de texto.
     */
    private static void guardarDatos() {

        // Se guardan los datos de los clientes y los productos en un fichero de texto.
        try {
            // Se crea el fichero de texto.
            FileOutputStream archivoSalida = new FileOutputStream("datos.txt");
            // Se crea el objeto para escribir en el fichero de texto.
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);

            // Se escriben los datos de los clientes y los productos en el fichero de texto.
            for (Cliente c : CLIENTES) {
                objetoSalida.writeObject(c);
            }

            for (Producto p : PRODUCTOS) {
                objetoSalida.writeObject(p);
            }

            // Se cierra el fichero de texto.
            objetoSalida.close();

            IO_ES.escribir("Datos guardados correctamente.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        } catch (IOException e) {

            // Si no se ha podido guardar los datos en el fichero de texto, se muestra un mensaje de error.
            IO_ES.escribir("ERROR: No se ha podido guardar los datos en el fichero de texto.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        }

    }

    /**
     * Recupera los datos de los clientes y los productos de un fichero de texto.
     */
    private static void recuperarDatos() {

        // Se recuperan los datos de los clientes y los productos del fichero de texto.
        try {
            // Se crea el fichero de texto.
            FileInputStream archivoEntrada = new FileInputStream("datos.txt");
            // Se crea el objeto para leer el fichero de texto.
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            // Se crea un ArrayList para almacenar los objetos recuperados.
            ArrayList<Object> objetosRecuperados = new ArrayList<>();

            // Se recuperan los objetos del fichero de texto y se almacenan en el ArrayList.
            while (true) {
                try {
                    Object objetoRecuperado = objetoEntrada.readObject();
                    objetosRecuperados.add(objetoRecuperado);
                } catch (EOFException e) {
                    break;
                }
            }

            // Se recorren los objetos recuperados y se almacenan en los ArrayList correspondientes.
            for (Object objeto : objetosRecuperados) {

                if (objeto instanceof Cliente) {
                    CLIENTES.add((Cliente) objeto);
                } else if (objeto instanceof Producto) {
                    PRODUCTOS.add((Producto) objeto);
                }

            }

            // Se cierra el fichero de texto.
            objetoEntrada.close();

            IO_ES.escribir("Datos recuperados correctamente.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        } catch (IOException | ClassNotFoundException e) {

            // Si no se ha podido recuperar los datos del fichero de texto, se muestra un mensaje de error.
            IO_ES.escribir("ERROR: No se ha podido recuperar los datos del fichero de texto.");
            IO_ES.escribir("");

            sleep(2);

            menuPrincipal();

        }

    }

    /**
     * Permite seleccionar el tipo de medicamento.
     *
     * @return Tipo de medicamento.
     */
    private static TipoMedicamento selecionarTipoMedicamento() {

        // Se muestra un menú con los tipos de medicamentos y se devuelve el tipo de medicamento seleccionado.
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

            // Si el tipo de medicamento introducido no es valido, se muestra un mensaje de error y se vuelve a pedir el tipo de medicamento.
            IO_ES.escribir("");
            IO_ES.escribir("ERROR: El tipo de medicamento introducido no es valido. Debe seleccionar un tipo de medicamento de la lista.");
            IO_ES.escribir("");

            sleep(2);

            return selecionarTipoMedicamento();

        }

    }

    /**
     * Permite seleccionar la categoria.
     *
     * @return Categoria.
     */
    private static Categoria selecionarCategoria() {

        // Se muestra un menú con las categorias de productos y se devuelve la categoria seleccionada.
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

            // Si la categoria del producto introducida no es valida, se muestra un mensaje de error y se vuelve a pedir la categoria del producto.
            IO_ES.escribir("");
            IO_ES.escribir("ERROR: La categoría del producto introducida no es valida. Debe seleccionar una categoría de la lista.");
            IO_ES.escribir("");

            sleep(2);

            return selecionarCategoria();

        }

    }

    /**
     * Muestra los datos de los clientes.
     *
     * @param cliente Objeto cliente.
     */
    private static void mostrarDatos(Cliente cliente) {
        IO_ES.escribir("");
        IO_ES.escribir("Datos del cliente: " + cliente.getId());
        IO_ES.escribir("");
        IO_ES.escribir("DNI: " + cliente.getDni());
        IO_ES.escribir("Nombre: " + cliente.getNombre());
        IO_ES.escribir("Dirección: " + cliente.getDireccion());
        IO_ES.escribir("Teléfono: " + cliente.getTelefono());
        IO_ES.escribir("Baja: " + cliente.isBaja());
        IO_ES.escribir("");
    }

    /**
     * Muestra los datos de los productos.
     *
     * @param producto Objeto producto.
     */
    private static void mostrarDatos(Producto producto) {
        IO_ES.escribir("");
        IO_ES.escribir("Datos del producto: " + producto.getCodigo());
        IO_ES.escribir("Tipo: " + producto.getClass().getSimpleName());
        IO_ES.escribir("Nombre: " + producto.getNombre());
        IO_ES.escribir("Descripción: " + producto.getDescripcion());
        IO_ES.escribir("Precio: " + producto.getPrecio() + "€");
        IO_ES.escribir("Stock: " + producto.getUnidades());

        if (producto instanceof Medicamento) {

            // Si el producto es de tipo medicamento, se muestran los datos de ese producto.
            IO_ES.escribir("Tipo de medicamento: " + ((Medicamento) producto).getTipoMedicamento());
            IO_ES.escribir("Como tomarlo: " + ((Medicamento) producto).getComoTomar());
            IO_ES.escribir("Efectos secundarios: " + ((Medicamento) producto).getEfectosAdverso());

        } else if (producto instanceof ParaFarmacia) {

            // Si el producto es de tipo parafarmacia, se muestran los datos de ese producto.
            IO_ES.escribir("Categoria: " + ((ParaFarmacia) producto).getCategoria());
            IO_ES.escribir("Dosis: " + ((ParaFarmacia) producto).getDosisUnidades());
            IO_ES.escribir("Descuento: " + ((ParaFarmacia) producto).getDescuento() + "%");

        }
        IO_ES.escribir("");
    }

    /**
     * Permite pausar la ejecución del programa.
     *
     * @param segundos Segundos que se desea pausar la ejecución del programa.
     */
    private static void sleep(int segundos) {

        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
