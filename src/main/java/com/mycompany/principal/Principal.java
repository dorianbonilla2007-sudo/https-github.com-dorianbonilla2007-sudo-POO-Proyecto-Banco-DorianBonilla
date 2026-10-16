/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.principal;

/**
 *
 * @author DorianB
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       SIMULADOR CORE BANCARIO - PRUEBAS          ");
        System.out.println("==================================================\n");

        // ----------------------------------------------------
        // 1. PRUEBA DE ENCAPSULAMIENTO
        // ----------------------------------------------------
        System.out.println("--- 1. Prueba de Encapsulamiento ---");
        CuentaBancaria miCuenta = new CuentaBancaria("CTA-001", "Dorian Bonilla", 1000.0);
        
        // La siguiente línea genera un error de compilación porque 'saldo' tiene modificador de acceso 'private'.
        // miCuenta.saldo = 50000; 
        System.out.println("[COMENTADO] 'miCuenta.saldo = 50000;' genera error en compilacion porque el atributo 'saldo' es privado y está protegido por encapsulamiento.\n");

        // ----------------------------------------------------
        // 2. ACCESO DIRECTO A ATRIBUTOS PÚBLICOS
        // ----------------------------------------------------
        System.out.println("--- 2. Acceso Directo a Atributos Publicos ---");
        System.out.println("Titular (Acceso directo): " + miCuenta.titular);
        System.out.println("Numero de Cuenta (Acceso directo): " + miCuenta.numeroCuenta + "\n");

        // ----------------------------------------------------
        // 3. PRUEBA DE CUENTA DE AHORRO (Retiros consecutivos)
        // ----------------------------------------------------
        System.out.println("--- 3. Prueba de CuentaAhorro (Comision por exceso) ---");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("AH-101", "Dorian Bonilla", 3000.0, 5.0);
        
        System.out.println("Retiro 1:");
        cuentaAhorro.retirarConComision(200.0);
        
        System.out.println("\nRetiro 2:");
        cuentaAhorro.retirarConComision(200.0);
        
        System.out.println("\nRetiro 3:");
        cuentaAhorro.retirarConComision(200.0);
        
        System.out.println("\nRetiro 4 (Aplica comisión L. 20.0):");
        cuentaAhorro.retirarConComision(200.0); // Se deben cobrar 200 + 20 de comisión = 220
        System.out.println();

        // ----------------------------------------------------
        // 4. RENDIMIENTO DE AHORRO (Interés Mensual)
        // ----------------------------------------------------
        System.out.println("--- 4. Rendimiento de Ahorro ---");
        System.out.println("Saldo antes de intereses: L. " + cuentaAhorro.getSaldo());
        cuentaAhorro.aplicarInteresMensual();
        System.out.println("Saldo verificado despues del interés: L. " + cuentaAhorro.getSaldo() + "\n");

        // ----------------------------------------------------
        // 5. PRUEBA DE CUENTA CORRIENTE (Sobregiro + 3% recargo)
        // ----------------------------------------------------
        System.out.println("--- 5. Prueba de CuentaCorriente (Uso de Sobregiro) ---");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("CC-505", "Dorian Bonilla", 1000.0, "Mi Empresa S.A.", 5000.0);
        
        System.out.println("Saldo inicial: L. " + cuentaCorriente.getSaldo());
        System.out.println("Límite sobregiro: L. " + cuentaCorriente.getLimiteSobregiro());
        System.out.println("Intentando retirar L. 3,500.0...");
        
        // Consume L. 1,000 de saldo. Faltan L. 2,500 + 3% recargo (L. 75) = L. 2,575 de sobregiro
        cuentaCorriente.retirarConSobregiro(3500.0);
        System.out.println("Saldo actual tras retiro: L. " + cuentaCorriente.getSaldo());
        System.out.println("Deuda de sobregiro utilizada: L. " + cuentaCorriente.getSobregiroUtilizado() + "\n");

        // ----------------------------------------------------
        // 6. AMORTIZACIÓN DE DEUDA (Pagar Sobregiro)
        // ----------------------------------------------------
        System.out.println("--- 6. Amortización de Deuda ---");
        System.out.println("Abonando L. 3,000.0 para saldar la deuda de sobregiro y abonar al saldo...");
        cuentaCorriente.pagarSobregiro(3000.0);
        
        System.out.println("\n--- ESTADO FINAL DE CUENTA CORRIENTE ---");
        System.out.println("Sobregiro pendiente: L. " + cuentaCorriente.getSobregiroUtilizado());
        System.out.println("Saldo disponible final: L. " + cuentaCorriente.getSaldo());
        cuentaCorriente.mostrarDatos();
    }
    }

