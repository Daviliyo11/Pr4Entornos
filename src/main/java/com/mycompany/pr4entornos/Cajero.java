/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pr4entornos;

import java.util.ArrayList;
import com.mycompany.pr4entornos.Producto;

/**
 *
 * @author loren
 */
/**
 * Representa un cajero encargado de gestionar productos,
 * generar tickets de compra y realizar el cierre de caja.
 * <p>
 * La clase permite añadir y eliminar productos del ticket actual,
 * calcular importes con IVA y mantener estadísticas de ventas del día.
 * </p>
 */
public class Cajero {

    /** Nombre del cajero. */
    String n;

    /** Cantidad total de tickets emitidos. */
    int c;

    /** Total facturado durante el día. */
    double t;

    /** Lista de productos incluidos en el ticket actual. */
    ArrayList<Producto> ps;

    /**
     * Constructor de la clase Cajero.
     *
     * @param n nombre del cajero
     */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }

    /**
     * Añade un producto al ticket actual.
     *
     * @param p producto que se desea añadir
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }

    /**
     * Elimina un producto del ticket actual.
     *
     * @param p producto que se desea eliminar
     */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }

    /**
     * Calcula el importe total del ticket aplicando un IVA del 21%,
     * imprime el ticket por consola y actualiza las estadísticas
     * del cajero.
     * <p>
     * Una vez realizado el cobro, el ticket actual se vacía.
     * </p>
     */
    public void cobrar() {
        double subt = 0;

        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }

        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);

        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }

        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;

        ps.clear();
    }

    /**
     * Realiza el cierre de caja mostrando un resumen
     * de la actividad diaria.
     * <p>
     * Se muestran:
     * </p>
     * <ul>
     *   <li>Tickets emitidos</li>
     *   <li>Total facturado</li>
     *   <li>IVA recaudado</li>
     * </ul>
     */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }

    /**
     * Indica si el ticket actual está vacío.
     *
     * @return {@code true} si no hay productos en el ticket,
     *         {@code false} en caso contrario
     */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }

    /**
     * Obtiene la cantidad de tickets emitidos.
     *
     * @return número total de tickets emitidos
     */
    public int getTicketsEmitidos() {
        return c;
    }

    /**
     * Obtiene el total facturado durante el día.
     *
     * @return importe total facturado
     */
    public double getTotalDia() {
        return t;
    }
}
