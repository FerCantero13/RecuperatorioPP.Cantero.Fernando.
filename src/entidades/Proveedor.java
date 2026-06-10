/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Usuario
 */
public class Proveedor {
    private String nombreProveedor;
    private String cuidadProveedor;
    private int antiguedadProveedor;

    public Proveedor(String nombre, String cuidad, int antiguedad) {
        this.nombreProveedor = nombre;
        this.cuidadProveedor = cuidad;
        this.antiguedadProveedor = antiguedad;
    }
    
    public boolean sonIguales(Proveedor p1, Proveedor p2){
        return p1.equals(p2);
    }
    
    public String getInfoProveedor(){
        return "Proveedor: " + this.nombreProveedor + ", de: " + this.cuidadProveedor + ", con antiguedad de: " + this.antiguedadProveedor;
    }

    @Override
    public String toString() {
        return this.getInfoProveedor();
    }
    
}
