/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Producto{
    protected Proveedor proveedor;
    protected String codigoProducto;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    public Producto(String codigoProducto, String nombre, double precio, Proveedor proveedor){
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Producto(String codigoProducto, String nombre, double precio, String nombreProveedor, String cuidadProveedor, int antiguedadProveedor) {
        proveedor = new Proveedor(nombreProveedor, cuidadProveedor, antiguedadProveedor);
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    static {
        generadorAleatorio= new Random();
    }

    public int getCalorias() {
        if (calorias == 0) {
            calorias = generadorAleatorio.nextInt(200,800) + 1;
        }
        return calorias;
    }

    public int getTiempoPreparacion() {
        if (tiempoPreparacion == 0) {
            tiempoPreparacion = generadorAleatorio.nextInt(2, 20) +1;
        }
        return tiempoPreparacion;
    }
    
    public String mostar(){
        return "Producto: " + "proveedor: " + proveedor + ", codigoProducto: " +
                codigoProducto + ", nombre: " + nombre + ", precio: " + precio + ", calorias: " + calorias +
                ", tiempoPreparacion: " + tiempoPreparacion;
    }
    
    public boolean sonIguales(Producto p1, Producto p2){
        return p1.equals(p2);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.proveedor);
        hash = 47 * hash + Objects.hashCode(this.codigoProducto);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 47 * hash + this.calorias;
        hash = 47 * hash + this.tiempoPreparacion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.calorias != other.calorias) {
            return false;
        }
        if (this.tiempoPreparacion != other.tiempoPreparacion) {
            return false;
        }
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.proveedor, other.proveedor);
    }
    
    

    @Override
    public String toString() {
        return this.mostar();
    }
    
    
    
}
