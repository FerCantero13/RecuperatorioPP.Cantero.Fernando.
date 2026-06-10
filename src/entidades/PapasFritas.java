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
public class PapasFritas extends Producto implements IVendible{
    private TipoPapas tipoPapas;

    public PapasFritas(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoPapas tipoPapas) {
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoPapas = tipoPapas;
    }

    @Override
    public double getPrecioTotal() {
        double aumento = 0;
        switch (this.tipoPapas) {
            case CLASICAS -> {
                aumento = this.precio * 0.10;
                return this.precio + aumento;
            }
            case CON_CHEDDAR -> {
                aumento = this.precio * 0.15;
                return this.precio + aumento;
            }
            case CON_BACON -> {
                aumento = this.precio * 0.20;
                return this.precio + aumento;
            }
        }
        return this.precio;
    }

    @Override
    public String toString() {
        return "PapasFritas: " + super.mostar() + ", tipoPapas: " + tipoPapas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.tipoPapas);
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
        final PapasFritas other = (PapasFritas) obj;
        return this.tipoPapas == other.tipoPapas;
    }
    
}
