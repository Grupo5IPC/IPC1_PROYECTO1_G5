package com.grupo5;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.grupo5.Usuarios.*;
import com.grupo5.Productos.*;
import com.grupo5.Clientes.*;
import com.grupo5.Facturas.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static Restaurante Nuevo;
    public static String tipoDeCarga;
    public static Gestor_usuario usuario = new Gestor_usuario();
    public static Gestor_cliente cliente = new Gestor_cliente();
    public static Gestor_Producto producto = new Gestor_Producto();
    public static Gestor_Factura factura = new Gestor_Factura();
    public static Ingrediente ingrediente = new Ingrediente();

    public static void main(String[] args) {
        // write your code here
        // Aqui ira el menu, la carga de los jsons iniciales, etc. ver el grupo xd

        // en la instancia de la clase opciones se pide un entero que es el modo
        // el modo es la seleccion entre json o bin
        leerConfig();
        leerClientes();
        leerUsuarios();
        leerProductos();
        leerFacturas();
        if ("json".equals(tipoDeCarga)) {
            Opciones op = new Opciones(cliente, usuario, producto, 1);
        } else if ("bin".equals(tipoDeCarga)) {
            Opciones op = new Opciones(cliente, usuario, producto, 0);
        }else{
            System.out.println("ERROR: La carga no es un archivo json o binario");
        }
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner login = new Scanner(System.in);
        Scanner MenuPrincipal = new Scanner(System.in);
        try {
            System.out.println("*******************************");
            System.out.println("*           LOGIN             *");
            System.out.println("*******************************");
            System.out.println("* Ingrese su usuario          *");
            String user = login.nextLine();
            System.out.println("* Ingrese su contraseña       *");
            String pass = login.nextLine();
            System.out.println("*******************************");
            int Opciones = 0;
            if (usuario.verificar(user, pass)) {
            do {
                try {
                    System.out.println("*******************************");
                    System.out.println("*       MENÚ PRINCIPAL        *");
                    System.out.println("*******************************");
                    System.out.println("* 1) Informacion Restaurante  *");
                    System.out.println("* 2) Usuarios                 *");
                    System.out.println("* 3) Productos                *");
                    System.out.println("* 4) Clientes                 *");
                    System.out.println("* 5) Facturas                 *");
                    System.out.println("* 6) Guardar Cambios          *");
                    System.out.println("* 7) Salir                    *");
                    System.out.println("*******************************");
                    System.out.print("Elige una opcion: ");
                    Opciones = MenuPrincipal.nextInt();
                    switch (Opciones) {
                        case 1:
                            Nuevo.printRestaurante();
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 2:
                            do{
                            //USUARIOS
                            System.out.println("*******************************");
                            System.out.println("*          USUARIOS           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Usuarios      *");
                            System.out.println("* 2) Eliminar Usuario         *");
                            System.out.println("* 3) Ver Usuario              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            System.out.print("Elige una opcion: ");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    System.out.println("");
                                    usuario.print_usu();
                                    System.out.println("");
                                    break;

                                case 2:
                                    Scanner eliminar = new Scanner(System.in);
                                    System.out.println("Ingrese el username del usuario a eliminar: ");
                                    String eliminarUser = eliminar.nextLine();
                                    usuario.eliminarUsuario(eliminarUser);
                                    break;

                                case 3:
                                    Scanner buscar = new Scanner(System.in);
                                    System.out.println("Ingrese el username del usuario a buscar: ");
                                    String buscarUser = buscar.nextLine();
                                    usuario.printUsuarioSolo(buscarUser);
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            }while(Opciones != 4);
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 3:
                            //PRODUCTOS
                            do{
                            System.out.println("*******************************");
                            System.out.println("*          PRODUCTOS          *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Productos     *");
                            System.out.println("* 2) Eliminar Producto        *");
                            System.out.println("* 3) Ver Producto             *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            System.out.print("Elige una opcion: ");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    producto.printProductos();
                                    break;

                                case 2:
                                    Scanner eliminar = new Scanner(System.in);
                                    System.out.println("Ingrese el id del producto a eliminar: ");
                                    int eliminarId = eliminar.nextInt();
                                    producto.eliminarProducto(eliminarId);
                                    break;

                                case 3:
                                    Scanner buscar = new Scanner(System.in);
                                    System.out.println("Ingrese el id del producto a buscar: ");
                                    int buscarId = buscar.nextInt();
                                    producto.printProductoSolo(buscarId);
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            }while(Opciones != 4);
                            
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 4:
                            //CLIENTES
                            do{
                            System.out.println("*******************************");
                            System.out.println("*          CLIENTES           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Clientes      *");
                            System.out.println("* 2) Eliminar Cliente         *");
                            System.out.println("* 3) Ver Cliente              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            System.out.print("Elige una opcion: ");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    System.out.println("");
                                    cliente.printClientes();
                                    System.out.println("");
                                    break;

                                case 2:
                                    Scanner eliminar = new Scanner(System.in);
                                    System.out.println("Ingrese el id del cliente a eliminar: ");
                                    int eliminarId = eliminar.nextInt();
                                    cliente.eliminarCliente(eliminarId);
                                    break;

                                case 3:
                                    Scanner buscar = new Scanner(System.in);
                                    System.out.println("Ingrese el id del cliente a buscar: ");
                                    int buscarId = buscar.nextInt();
                                    cliente.printClienteSolo(buscarId);
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            }while (Opciones != 4);
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 5:
                            //FACTURAS
                            do{
                            System.out.println("*******************************");
                            System.out.println("*          FACTURAS           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Facturas      *");
                            System.out.println("* 2) Eliminar Factura         *");
                            System.out.println("* 3) Ver Factura              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            System.out.print("Elige una opcion: ");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    System.out.println("");
                                    factura.printFacturas();
                                    System.out.println("");
                                    break;

                                case 2:
                                    Scanner eliminar = new Scanner(System.in);
                                    System.out.println("Ingrese el id de la factura a eliminar: ");
                                    int eliminarId = eliminar.nextInt();
                                    factura.eliminarFactura(eliminarId);
                                    break;

                                case 3:
                                    Scanner buscar = new Scanner(System.in);
                                    System.out.println("Ingrese el id de la factura a buscar: ");
                                    int buscarId = buscar.nextInt();
                                    factura.printFacturaSolo(buscarId);
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            }while(Opciones != 4);
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 6:
                            //GUARDAR CAMBIOS
                            do{
                            System.out.println("*******************************");
                            System.out.println("*       GUARDAR CAMBIOS       *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Archivo JSON             *");
                            System.out.println("* 2) Archivo Binario          *");
                            System.out.println("* 3) Menu Principal           *");
                            System.out.println("*******************************");
                            System.out.print("Elige una opcion: ");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //JSON
                                    break;

                                case 2:
                                    //BINARIO
                                    break;

                                case 3:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            }while(Opciones != 3);
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 7:
                            //SALIDA
                            System.out.println("Has salido del programa");
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        default:
                            System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                            break;
                    }
                } catch (Exception e) {
                    MenuPrincipal = new Scanner(System.in);
                    System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                }
            } while (Opciones != 7);
            }
        } catch (Exception e) {
            System.out.println("Has hecho una acción no valida,");
        }
    }

    public static void leerConfig() {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("config.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonObject GsonObj = (JsonObject) Parser.parse(Contenido);

            String nombre = GsonObj.get("name").getAsString();
            String direccion = GsonObj.get("address").getAsString();
            int numero = GsonObj.get("phone").getAsInt();
            tipoDeCarga = GsonObj.get("load").getAsString();
            Nuevo = new Restaurante(nombre, direccion, numero, tipoDeCarga);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }

    public static void leerClientes() {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("clients.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

            for (int i = 0; i < GsonArr.size(); i++) {
                JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                int id = GsonObj.get("id").getAsInt();
                String nombre = GsonObj.get("name").getAsString();
                String direccion = GsonObj.get("address").getAsString();
                int numero = GsonObj.get("phone").getAsInt();
                String nit = GsonObj.get("nit").getAsString();
                cliente.insertarCliente(id, nombre, direccion, numero, nit);
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void leerUsuarios() {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("users.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

            for (int i = 0; i < GsonArr.size(); i++) {
                JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                String nombre = GsonObj.get("username").getAsString();
                String password = GsonObj.get("password").getAsString();
                usuario.Ins_usu(nombre, password);
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void leerProductos() {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("products.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

            for (int i = 0; i < GsonArr.size(); i++) {
                JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                int id = GsonObj.get("id").getAsInt();
                String nombre = GsonObj.get("name").getAsString();
                String descripcion = GsonObj.get("description").getAsString();
                double costo = GsonObj.get("cost").getAsInt();
                double precio = GsonObj.get("price").getAsInt();

                JsonArray Ingred = GsonObj.get("ingredients").getAsJsonArray();
                Ingrediente aux = null;
                for (int j = 0; j < Ingred.size(); j++) {
                    JsonObject GsonObj2 = Ingred.get(i).getAsJsonObject();
                    int idIng = GsonObj2.get("id").getAsInt();
                    String nombreIng = GsonObj2.get("name").getAsString();
                    int cantidadIng = GsonObj2.get("quantity").getAsInt();
                    String unidadesIng = GsonObj2.get("units").getAsString();

                    aux = producto.createIngrediente(idIng, nombreIng, cantidadIng, unidadesIng);
                }

                producto.insertarProducto(id, nombre, descripcion, costo, precio, aux);
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void leerFacturas() {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("invoices.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

            for (int i = 0; i < GsonArr.size(); i++) {
                JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                int id = GsonObj.get("id").getAsInt();
                int idcliente = GsonObj.get("client").getAsInt();
                Cliente auxclient = cliente.getCliente(idcliente);
                String fecha = GsonObj.get("date").getAsString();

                JsonArray Ingred = GsonObj.get("products").getAsJsonArray();
                Detalle auxdetalle = null;

                for (int j = 0; j < Ingred.size(); j++) {
                    try {
                        JsonObject GsonObj2 = Ingred.get(i).getAsJsonObject();
                        String nombreProd = GsonObj2.get("name").getAsString();
                        //Encontrar Id con el Nombre
                        //Encontrar un Prodcuto con el Id
                        int x = 0;
                        boolean encontrado = false;
                        while (x < producto.contProductos() && encontrado == false) {
                            boolean found = producto.verificarProducto(producto.getId_nombre(nombreProd));
                            if (found == true) {
                                encontrado = true;
                                int auxProductId = producto.getId_nombre(nombreProd);
                                Producto auxProduct = producto.getProductos(auxProductId);
                                auxdetalle = factura.crearDetalle(auxProductId, auxProduct);
                            } else {
                                i++;
                            }
                        }
                        //int cantidadIng = GsonObj2.get("price").getAsInt();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }
                factura.insertarFactura(id, auxclient, fecha, auxdetalle);
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }
}
