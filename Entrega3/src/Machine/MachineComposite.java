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
    public void setBroken() {
        boolean wasBroken = broken;
        broken = true;
        if(!wasBroken){
            notifyChanges();
        }
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
        if(broken) {return true;}
        for(MachineComponent mc : componentList){
            if(mc.isBroken()){ return true;}
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        MachineComposite mc = (MachineComposite) o;
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
