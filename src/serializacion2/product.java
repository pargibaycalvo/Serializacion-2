/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class product  implements Serializable{
    String cod;
    String des;
    double prezo;

    public product() {
        String cod=null;
        String des=null;
        double prezo=0;
    }

    public product(String cod, String des, double prezo) {
        this.cod = cod;
        this.des = des;
        this.prezo = prezo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "product{" + "cod=" + cod + ", des=" + des + ", prezo=" + prezo + '}';
    }
    
}
