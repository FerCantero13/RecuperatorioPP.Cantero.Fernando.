/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Hamburgueseria implements Iterable<Producto>{
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;

    public Hamburgueseria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Hamburgueseria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    
    public boolean sonIguales(Producto p) {
        return this.equals(p);
    }
    
    public void agregar(Producto p) {
        if (this.productos.size() < this.capacidad) {
            if (!this.sonIguales(p)) {
                this.productos.add(p);
                System.out.println("Produco Agregado");
            }
            else {
                System.out.println("El producto ya existe");
            }
        }
        else {
            System.out.println("No hay capacidad");
        }
    }
    
    public double getPrecioProductos(TipoProducto tipo){
        
        switch (tipo) {
            case HAMBURGUESAS -> {
                return this.getPrecioDeHamburguesas();
            }
            case PAPAS -> {
                return this.getPrecioDePapas();
            }
            case AMBAS -> {
                return this.getPrecioTotal();
            }
        }
        return 0;
        }
    
    public double getPrecioDeHamburguesas(){
        double acumulador = 0;
        for (Producto p : this.productos) {
            if (p instanceof Hamburguesa) {
                Hamburguesa estaHamburguesa = (Hamburguesa) p;
                acumulador = estaHamburguesa.getPrecioTotal();
            }
        }
        return acumulador;
        }
    
    public double getPrecioDePapas(){
        double acumulador = 0;
        for (Producto p : this.productos) {
            if (p instanceof PapasFritas) {
                PapasFritas estaPapasFritas = (PapasFritas) p;
                acumulador = estaPapasFritas.getPrecioTotal();
            }
        }
        return acumulador;
        }
            
    public double getPrecioTotal(){
        double acumulador = 0;
        
        for (Producto p : this.productos) {
            if (p instanceof Hamburguesa) {
                Hamburguesa estaHamburguesa = (Hamburguesa) p;
                acumulador = estaHamburguesa.getPrecioTotal();
            } else if (p instanceof PapasFritas) {
                PapasFritas estaPapasFritas = (PapasFritas) p;
                acumulador = estaPapasFritas.getPrecioTotal();
            }
        }
        return acumulador;
        }

    @Override
    public Iterator iterator() {
        return this.productos.iterator();
        }
    
    public Producto getProductoMasCaro() {
        Iterator<Producto> it = this.iterator();
        
        if (!it.hasNext()) {
            return null;
        }
        
        Producto productoMasCaro = it.next();
        
        while(it.hasNext()) {
            Producto productoActual = it.next();
            
            if (((IVendible)productoActual).getPrecioTotal() >((IVendible)productoMasCaro).getPrecioTotal()) {
                productoMasCaro = productoActual;
            }
        }
        
        return productoMasCaro;
    }

    @Override
    public String toString() {
        return "Hamburgueseria: " + "nombre=" + nombre + ", capacidad=" + capacidad +
                ", productos=" + productos + ", total hamburguesas: " + this.getPrecioProductos(TipoProducto.HAMBURGUESAS) +
                ", total papas fritas" + this.getPrecioProductos(TipoProducto.PAPAS) + ", total: " + this.getPrecioProductos(TipoProducto.AMBAS);
    }
}
