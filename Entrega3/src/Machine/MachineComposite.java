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
    private boolean broken = false;
    private List<MachineComponent> componentList = new ArrayList<>();
    private int brokenSubComponents = 0;

    public void addComponent(MachineComponent mc) {
        componentList.add(mc);
        mc.addObserver(this);
        if(mc.isBroken()){
            notifyChanges();
        }
    }

    @Override
    public boolean isBroken() {
        return broken || brokenSubComponents > 0;
    }

    @Override
    public void update(Observable o, Object arg) {
        MachineComponent mc = (MachineComponent) o;
        if(mc.isBroken()){
            addBrokenSubComponent();
        }else{
            addRepairedSubComponent();
        }
    }
    
    public void addBrokenSubComponent(){
        brokenSubComponents += 1;
        if(isBroken()){
            notifyChanges();
        }        
    }
    
    public void addRepairedSubComponent(){
        brokenSubComponents -= 1;
        if(!isBroken()){
            notifyChanges();
        }
    }
}
