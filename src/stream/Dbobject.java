/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stream;

/**
 *
 * @author skliz
 */
public class Dbobject {
    
    private String wallet_number;
    
    private String remark;
    
    public Dbobject(String wallet_number, String remark){
        this.wallet_number = wallet_number;
        this.remark = remark;
    }
    
  
    
    public String getWallet_number(){
        
        return this.wallet_number;
    }

    public String getRemark(){
        
        return this.remark;
    }

    @Override
    public String toString() {
        return "Dbobject{" + "wallet_number=" + wallet_number + ", remark=" + remark + '}';
    }
        
}