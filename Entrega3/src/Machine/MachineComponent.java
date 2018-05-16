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
    public abstract void setBroken();
    public abstract void repair();
    public abstract boolean isBroken();

    protected void notifyChanges() {
        setChanged();
        notifyObservers();
    }
}
