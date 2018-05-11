/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Machine;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Albert
 */
public class GraphicInterface implements Observer{
    protected boolean notified = false;

    @Override
    public void update(Observable o, Object arg) {
        notified = true;
    }
    
}
