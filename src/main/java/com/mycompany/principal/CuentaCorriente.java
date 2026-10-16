/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

/**
 *
 * @author DorianB
 */
public class CuentaCorriente extends CuentaBancaria {
    // Atributo Público
    public String nombreEmpresa;

    // Atributos Privados
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    // Constructor
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    // Getters Propios
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    // Método propio para retirar utilizando cupo de sobregiro
    public boolean retirarConSobregiro(double monto) {
        if (getSaldo() >= monto) {
            return retirar(monto);
        } else {
            double saldoDisponible = getSaldo();
            double faltante = monto - saldoDisponible;
            double creditoAdicional = faltante * 1.03; // Agrega el 3% de recargo sobre el crédito usado
            double creditoDisponible = limiteSobregiro - sobregiroUtilizado;

            if (creditoAdicional <= creditoDisponible) {
                if (saldoDisponible > 0) {
                    retirar(saldoDisponible); // Agota el saldo restante
                }
                sobregiroUtilizado += creditoAdicional;
                System.out.println("Sobregiro utilizado. Crédito solicitado: L. " + faltante + 
                                   " + Recargo (3%): L. " + (faltante * 0.03) + 
                                   ". Total de deuda agregada al sobregiro: L. " + creditoAdicional);
                System.out.println("Sobregiro acumulado actual: L. " + sobregiroUtilizado);
                return true;
            } else {
                System.out.println("Error: La operación excede el cupo de sobregiro disponible.");
                return false;
            }
        }
    }

    // Método propio para abonar/pagar el sobregiro
    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a pagar debe ser mayor a 0.");
            return;
        }

        System.out.println("Abonando L. " + monto + " al sobregiro de la empresa " + nombreEmpresa + "...");
        if (monto <= sobregiroUtilizado) {
            sobregiroUtilizado -= monto;
            System.out.println("Pago aplicado. Sobregiro pendiente: L. " + sobregiroUtilizado);
        } else {
            double restante = monto - sobregiroUtilizado;
            System.out.println("Sobregiro de L. " + sobregiroUtilizado + " liquidado en su totalidad.");
            sobregiroUtilizado = 0.0;
            depositar(restante); // El sobrante se abona al saldo principal
        }
    }
}
