/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

/**
 *
 * @author DorianB
 */
public class CuentaAhorro extends CuentaBancaria {
    // Atributo Público
    public double tasaInteresAnual;

    // Atributos Privados
    private int retirosRealizadosMes;
    private double comisionPorExceso;

    // Constructor
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
        this.comisionPorExceso = 20.0;
        
}
    // Método propio para retirar con comisión por exceso
    public boolean retirarConComision(double monto) {
        if (retirosRealizadosMes >= 3) {
            double montoTotal = monto + comisionPorExceso;
            System.out.println("Aviso: Se aplicará una comisión por exceso de retiros de L. " + comisionPorExceso);
            
            if (getSaldo() >= montoTotal) {
                if (retirar(montoTotal)) {
                    retirosRealizadosMes++;
                    System.out.println("Retiro con comisión procesado con éxito.");
                    return true;
            }
            } else {
                System.out.println("Error: Saldo insuficiente para cubrir el retiro de L. " + monto + " más la comisión de L. " + comisionPorExceso);
                return false;
            }
        } else {
            if (retirar(monto)) {
                retirosRealizadosMes++;
                return true;
            }
        }
        return false;
    } 
    public void aplicarInteresMensual() {
        double interesMensual = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        System.out.println("Aplicando interés mensual de " + tasaInteresAnual + "%...");
        depositar(interesMensual);
    }
}
