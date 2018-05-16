/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

/**
 *
 * @author Albert
 */
public class Machine extends MachineComponent {
    @Override
    public void setBroken() {
        boolean wasBroken = broken;
        broken = true;
        if(!wasBroken){
            notifyChanges();
        }
        //changeBrokenAndNotify(true);
    }

    @Override
    public void repair() {
        boolean wasBroken = broken;
        broken = true;
        if(wasBroken){
            notifyChanges();
        }
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}
