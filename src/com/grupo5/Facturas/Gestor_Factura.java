package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Productos.Ingrediente;
import com.grupo5.Productos.Producto;

import java.util.ArrayList;

public class Gestor_Factura {
    ArrayList<Factura> facturas = new ArrayList();

    public Detalle crearDetalle(int id, Producto producto){
// usar antes los metodos getId_nombre para obtener el id del producto por el nombre del mismo, luego usar el getProducto y conseguir el objeto Producto
        Detalle detalle = new Detalle(id,producto);
        return detalle;
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
            System.out.print(facturas.get(i).getId() + ",");
            System.out.print(facturas.get(i).getCliente() + ",");
            System.out.print(facturas.get(i).getFecha() + ",");
            System.out.println(facturas.get(i).getDetalle()+ ",");
// si se dan cuenta si colocan un . luego del getDetalle les dejara tomar cualquier dato que deseen de el objeto detalle y a su vez si colocan esto facturas.get(i).getDetalle().getProducto().
// luego del punto les dejara tomar cualquier field del objeto producto

        }
    }

    public boolean verificarFactura(int id) {
        boolean state = false;
        int i = 0;
        while(state == false  && i< facturas.size()){
            if (facturas.get(i).getId() == id){
                state = true;
                return true;
            }else{
                i++;
            }
        }
        return false;
    }
}
