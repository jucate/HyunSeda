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
    //Este valor junto con las credenciales de pago deben ser leidos desde un archivo
    private double saldo = 50000;
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
        if (this.saldo>=payment.getPayValue()) {  
            System.out.println(this.saldo);
            System.out.println(payment.getPayValue());
            return true;
        } else {
            System.out.println(this.saldo);
            System.out.println(payment.getPayValue());
            return false;
        }
    }
    public void GetFileInfo(){
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
