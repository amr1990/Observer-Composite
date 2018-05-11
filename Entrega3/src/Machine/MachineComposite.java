/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Albert
 */
public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> componentList = new ArrayList<>();

    public void addComponent(MachineComponent mc) {
        componentList.add(mc);
    }

    @Override
    public void setBroken() {
        changeBrokenAndNotify(true);
    }

    @Override
    public void repair() {
        changeBrokenAndNotify(false);
    }

    @Override
    public boolean isBroken() {
        if(broken) {return true;}
        for(MachineComponent mc : componentList){
            if(mc.isBroken()){ return true;}
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        changeBrokenAndNotify(true);
    }
}
