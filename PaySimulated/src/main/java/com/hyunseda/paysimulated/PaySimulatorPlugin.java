/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hyunseda.paysimulated;

import com.hyunseda.payhyunseda.IPaymentPlugin;
import com.hyunseda.payhyunseda.Payment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class PaySimulatorPlugin implements IPaymentPlugin{
    private double saldo = 10000;
    private int codigo = 1;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    @Override
    public boolean payProcessing(Payment payment) {
        //GetFileInfo(payment);
        if (saldo>0) {
            payment.setPayValue(true);
        }
        else{
            payment.setPayValue(false);
        }
        return payment.isPayValue();
    }
    public void GetFileInfo(Payment payment){
        File archivo = new File("Pago.txt");
        List<String> listData = new ArrayList<>();
        if(archivo.exists()){
            try {
                Scanner myReader = new Scanner(archivo);
                while (myReader.hasNextLine()) {                    
                    String data = myReader.nextLine();
                    listData.add(data);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Un error ocurrio");
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("El archivo no existe");
        }
        if (!listData.isEmpty()) {
        }
    }
    
}
