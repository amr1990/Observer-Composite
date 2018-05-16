/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

import java.util.Observable;

/**
 *
 * @author Albert
 */
public abstract class MachineComponent extends Observable {
    protected boolean broken = false;
    public abstract boolean isBroken();
    
    public void setBroken() {
        boolean wasBroken = broken;
        broken = true;
        if(!wasBroken){
            notifyChanges();
        }
    }

    public void repair() {
        boolean wasBroken = broken;
        broken = true;
        if(wasBroken){
            notifyChanges();
        }
    }

    protected void notifyChanges() {
        setChanged();
        notifyObservers();
    }
}
