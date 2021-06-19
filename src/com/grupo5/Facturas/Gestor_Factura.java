package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Productos.Producto;

import java.util.ArrayList;
import java.io.Serializable;

public class Gestor_Factura implements Serializable{

    ArrayList<Factura> facturas = new ArrayList();

    public Detalle crearDetalle(int id, Producto producto) {
// usar antes los metodos getId_nombre para obtener el id del producto por el nombre del mismo, luego usar el getProducto y conseguir el objeto Producto
        Detalle detalle = new Detalle(id, producto);
        return detalle;
    }
   public ArrayList<Factura> getFacturas(){
        return facturas;
   }

    public boolean insertarFactura(int id, Cliente cliente, String fecha, Detalle detalle) {
        // para obtener el cliente usar antes el metodo getCliente del gesto Cliente con el id que se ingresa
        // esta devuelve un objeto cliente de esta forma en la factura tenemos, nit, nombre, etc.

        // usar el metodo crearDetalle para obtener el objeto Detalle, esto para que la factura a la hora de manejarla cuente con los datos necesarios
        Factura factura = new Factura(id, cliente, fecha, detalle);
        //
        if (facturas.add(factura)) {
            return true;
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void printFacturas() {
        for (int i = 0; i < facturas.size(); i++) {
            System.out.println("");
            System.out.println("Id Factura: " + facturas.get(i).getId());
            System.out.println("Cliente: " + facturas.get(i).getCliente().getNombre());
            System.out.println("Fecha: " + facturas.get(i).getFecha());
            System.out.println("Productos: " + facturas.get(i).getDetalle().getProducto().getNombre());
            System.out.println("");
// si se dan cuenta si colocan un . luego del getDetalle les dejara tomar cualquier dato que deseen de el objeto detalle y a su vez si colocan esto facturas.get(i).getDetalle().getProducto().
// luego del punto les dejara tomar cualquier field del objeto producto

        }
    }

    public boolean verificarFactura(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public void printFacturaSolo(int id) {
        int aux = id - 1;
        System.out.print("Id Factura: " + facturas.get(aux).getId() + ",");
        System.out.print("Cliente: " + facturas.get(aux).getCliente().getNombre() + ",");
        System.out.print("Fecha: " + facturas.get(aux).getFecha() + ",");
        System.out.print("Productos: " + facturas.get(aux).getDetalle().getProducto() + ",");
        System.out.println("");
    }

    public int eliminarFactura(int id) {
        boolean state = false;
        int i = 0;
        int modo = 0;
        if (facturas.isEmpty() || facturas == null){
            modo = 1;
            return modo;
        }
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                facturas.remove(i);
                System.out.println("Factura con id " + (i + 1) + " eliminado");
                modo = 2;
                return modo;
            } else {
                i++;
            }
        }
        return modo;
    }
}
