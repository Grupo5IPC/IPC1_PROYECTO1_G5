package com.grupo5;

import com.grupo5.Usuarios.*;
import com.grupo5.Productos.*;
import com.grupo5.Clientes.*;
import java.util.*;

public class Main {

    public static Gestor_usuario gestor_usuario;
    public static Gestor_Producto gestor_producto;
    public static Gestor_cliente gestor_cliente;
    public static Gestor_usuario gestor_usuarios;
//    public static Reportes reportes;
//    public static Log log;

    public static void main(String[] args) {
        // write your code here
        // Aqui ira el menu, la carga de los jsons iniciales, etc. ver el grupo xd
        Gestor_usuario user = new Gestor_usuario();
        Gestor_cliente cliente = new Gestor_cliente();
        Gestor_Producto producto = new Gestor_Producto();
        // en la instancia de la clase opciones se pide un entero que es el modo
        // el modo es la seleccion entre json o bin
        Opciones op = new Opciones(cliente, user, producto, 1);

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
//            if (gestor_usuario.verificar(user, pass)) {
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
                            //INFORMACION RESTAURANTE
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 2:
                            //USUARIOS
                            System.out.println("*******************************");
                            System.out.println("*          USUARIOS           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Usuarios      *");
                            System.out.println("* 2) Eliminar Usuario         *");
                            System.out.println("* 3) Ver Usuario             *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //LISTADO USUARIOS
                                    break;

                                case 2:
                                    //ELIMINAR USUARIOS
                                    break;

                                case 3:
                                    //VER USUARIOS
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 3:
                            //PRODUCTOS
                            System.out.println("*******************************");
                            System.out.println("*          PRODUCTOS          *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Productos     *");
                            System.out.println("* 2) Eliminar Producto        *");
                            System.out.println("* 3) Ver Producto             *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //LISTADO PRODUCTOS
                                    break;

                                case 2:
                                    //ELIMINAR PRODUCTOS
                                    break;

                                case 3:
                                    //VER PRODUCTOS
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 4:
                            //CLIENTES
                            System.out.println("*******************************");
                            System.out.println("*          CLIENTES           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Clientes      *");
                            System.out.println("* 2) Eliminar Cliente         *");
                            System.out.println("* 3) Ver Cliente              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //LISTADO CLIENTES
                                    break;

                                case 2:
                                    //ELIMINAR CLIENTES
                                    break;

                                case 3:
                                    //VER CLIENTES
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 5:
                            //FACTURAS
                            System.out.println("*******************************");
                            System.out.println("*          FACTURAS           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Facturas      *");
                            System.out.println("* 2) Eliminar Factura         *");
                            System.out.println("* 3) Ver Factura              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //LISTADO FACTURA
                                    break;

                                case 2:
                                    //ELIMINAR FACTURA
                                    break;

                                case 3:
                                    //VER FACTURA
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 6:
                            //FACTURAS
                            System.out.println("*******************************");
                            System.out.println("*          USUARIOS           *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Listado de Usuarios      *");
                            System.out.println("* 2) Eliminar Usuario         *");
                            System.out.println("* 3) Ver Usuario              *");
                            System.out.println("* 4) Menu Principal           *");
                            System.out.println("*******************************");
                            Opciones = MenuPrincipal.nextInt();
                            switch (Opciones) {
                                case 1:
                                    //LISTADO USUARIOS
                                    break;

                                case 2:
                                    //ELIMINAR USUARIO
                                    break;

                                case 3:
                                    //VER USUARIO
                                    break;

                                case 4:
                                    //VUELTA AL MENU PRINCIPAL
                                    break;

                                default:
                                    System.out.println("Seleccione una opcion");
                                    break;
                            }
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 7:
                            //GUARDAR CAMBIOS
                            System.out.println("*******************************");
                            System.out.println("*       GUARDAR CAMBIOS       *");
                            System.out.println("*******************************");
                            System.out.println("* 1) Archivo JSON             *");
                            System.out.println("* 2) Archivo Binario          *");
                            System.out.println("* 3) Menu Principal           *");
                            System.out.println("*******************************");
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
                            break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                        case 8:
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
            } while (Opciones != 8);
//            }
        } catch (Exception e) {
            System.out.println("Has hecho una acción no valida,");
            System.out.println("Ejecuta el programa nuevamente");
        }
    }
}
