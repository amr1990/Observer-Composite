/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Albert
 */
public class MachineCompositeTest {
    private GraphicInterface graphicInterface;
    
    @Before
    public void setUp() throws Exception {
        graphicInterface = new GraphicInterface();
    }
    
    @Test
    public void notifyObserverWhenCompositeBreaks(){
        MachineComposite mc = createOperativeCompositeMachine();
        mc.addObserver(graphicInterface);
        mc.setBroken();
        assertTrue(graphicInterface.notified);
    }
    
    @Test
    public void notNotifyWhenCompositeMachineIsAlreadyBroken(){
        MachineComposite brokenCompositeMachine = createNonOperativeCompositeMachine();
        brokenCompositeMachine.addObserver(graphicInterface);
        brokenCompositeMachine.setBroken();
        assertFalse(graphicInterface.notified);
    }
    
    @Test
    public void notifyWhenCompositeIsRepaired(){
        MachineComposite brokenComposite = createNonOperativeCompositeMachine();
        brokenComposite.addObserver(graphicInterface);
        brokenComposite.repair();
        assertTrue(graphicInterface.notified);
    }
    
    @Test
    public void notNotifyWhenCompositeIsRepaired(){
        MachineComposite operativeComposite = createOperativeCompositeMachine();
        operativeComposite.addObserver(graphicInterface);
        operativeComposite.repair();
        assertFalse(graphicInterface.notified);
    }
    
    @Test
    public void testWhenBrokenMachineIsAdded(){
        MachineComposite operativeComposite = createOperativeCompositeMachine();
        operativeComposite.addObserver(graphicInterface);
        List<Machine> machines = createOperativeMachine();
        Machine brokenMachine = new Machine();
        brokenMachine.setBroken();
        machines.add(brokenMachine);
        addComponents(operativeComposite, machines);
        assertTrue(operativeComposite.isBroken());
    }
    
    @Test
    public void testWhenOperativeComponentsArentBroken(){
        MachineComposite mc = createOperativeCompositeMachine();
        List<Machine> machines = createOperativeMachine();
        addComponents(mc, machines);
        assertFalse(mc.isBroken());
    }
    
    private List<Machine> createOperativeMachine() {
        List<Machine> machines = new ArrayList<>();
        machines.add(new Machine());
        machines.add(new Machine());
        return machines;
    }
    
    @Test
    public void notifyWhenBrokenMachineIsAdded(){
        MachineComposite mc = createOperativeCompositeMachine();
        mc.addObserver(graphicInterface);
        mc.addComponent(nonOperativeMachineCreator());
        assertTrue(graphicInterface.notified);
    }
    
    @Test
    public void notifyWhenAddedMachineBreaks(){
        MachineComposite mc = createOperativeCompositeMachine();
        mc.addObserver(graphicInterface);
        Machine m = new Machine();
        assertFalse(graphicInterface.notified);
        mc.addComponent(m);
        m.setBroken();
        assertTrue(graphicInterface.notified);
    }
    
    private MachineComposite createOperativeCompositeMachine(){
        return new MachineComposite();
    }
    
    private MachineComposite createNonOperativeCompositeMachine(){
        MachineComposite brokenCompositeMachine = createOperativeCompositeMachine();
        brokenCompositeMachine.setBroken();
        return brokenCompositeMachine;
    }
    
    private Machine nonOperativeMachineCreator(){
        Machine m = new Machine();
        m.setBroken();
        return m;
    }
    
    private void addComponents(MachineComposite mc, List<Machine> machines){
        for(Machine m : machines){
            mc.addComponent(m);
        }
    }
    
}
