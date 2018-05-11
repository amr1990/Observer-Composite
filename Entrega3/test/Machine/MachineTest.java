/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Albert
 */
public class MachineTest {
    private GraphicInterface graphicInterface;
    
    @Before
    public void setup() throws Exception {
        graphicInterface = new GraphicInterface();
    }
    
    @Test
    public void notifiedObserverWhenMachineIsBroken(){
        Machine m = operativeMachineCreator();
        m.addObserver(graphicInterface);
        m.setBroken();
        assertTrue(graphicInterface.notified);        
    }
    
    @Test
    public void notifiedObserverWhenMachineIsAlreadyBroken(){
        Machine brokenMachine = nonOperativeMachineCreator();
        brokenMachine.addObserver(graphicInterface);
        brokenMachine.setBroken();
        assertFalse(graphicInterface.notified);
    }
    
    @Test
    public void notifyObserversWhenMachineIsRepaired(){
        Machine brokenMachine = nonOperativeMachineCreator();
        brokenMachine.addObserver(graphicInterface);
        brokenMachine.repair();
        assertTrue(graphicInterface.notified);
    }
    
    @Test
    public void notifyObserverWhenMachineIsAlreadyRepaired(){
        Machine m = operativeMachineCreator();
        m.addObserver(graphicInterface);
        m.repair();
        assertFalse(graphicInterface.notified);
    }
    
    private Machine operativeMachineCreator(){
        return new Machine();
    }
    
    private Machine nonOperativeMachineCreator(){
        Machine m = operativeMachineCreator();
        m.setBroken();
        return m;
    }
}
