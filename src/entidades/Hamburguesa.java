/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Hamburguesa extends Producto implements IVendible{
    private TipoHamburguesa tipoHamburguesa;
    private TamanioHamburguesa tamanioHamburguesa;

    public Hamburguesa(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoHamburguesa tipoHamburguesa, TamanioHamburguesa tamanioHamburguesa) {
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoHamburguesa = tipoHamburguesa;
        this.tamanioHamburguesa = tamanioHamburguesa;
    }

    @Override
    public double getPrecioTotal() {
        double aumento = 0;
        switch (this.tamanioHamburguesa) {
            case CHICA -> {
                aumento = this.precio * 0.05;
                return this.precio + aumento;
            }
            case MEDIANA -> {
                aumento = this.precio * 0.10;
                return this.precio + aumento;
            }
            case GRANDE -> {
                aumento = this.precio * 0.20;
                return this.precio + aumento;
            }
        }
        return this.precio;
    }

    @Override
    public String toString() {
        return "Hamburguesa: " + super.mostar() + ", tipoHamburguesa: " + tipoHamburguesa + ", tamanioHamburguesa: " + tamanioHamburguesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.tipoHamburguesa);
        hash = 17 * hash + Objects.hashCode(this.tamanioHamburguesa);
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
        final Hamburguesa other = (Hamburguesa) obj;
        if (this.tipoHamburguesa != other.tipoHamburguesa) {
            return false;
        }
        return this.tamanioHamburguesa == other.tamanioHamburguesa;
    }
    
    
    
}
