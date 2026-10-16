 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

/**
 *
 * @author DorianB
 */
public class CuentaBancaria {
    public String numeroCuenta;
    public String titular; 
    private double saldo;
    private int totalTransacciones;
    

// Constructor
    public CuentaBancaria (String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }
    // Métodos de Acceso (Getters)
    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }
    // Método Depositar
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            this.totalTransacciones++;
            System.out.println("Depósito exitoso de L. " + monto + ". Nuevo saldo: L. " + this.saldo);
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a 0.");
        }
    }
    // Método Retirar
    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            this.totalTransacciones++;
            System.out.println("Retiro exitoso de L. " + monto + ". Nuevo saldo: L. " + this.saldo);
            return true;
        }
    
       
       else {
            System.out.println("Error: Saldo insuficiente o monto inválido para el retiro.");
            return false;
        }
    }
    // Método Mostrar Datos
    public void mostrarDatos() {
        System.out.println("--- DATOS DE LA CUENTA ---");
        System.out.println("Titular: " + titular);
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Saldo Actual: L. " + saldo);
        System.out.println("Total Transacciones: " + totalTransacciones);
        System.out.println("--------------------------");
    }
}


