package pe.edu.uni.rmi.rmiclient;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.uni.rmi.rmiinterface.RmiInterface;

/**
 *
 * @author jorpa
 */
public class RmiClient {
    
    private static final String tag = "operation";
    public static void main(String[] args){
        RmiInterface serverInterface;
        String ipSv = "26.138.139.117" ;
        int portServer = 3232;
        try {
            Registry registry = LocateRegistry.getRegistry(ipSv,portServer) ;
            serverInterface = (RmiInterface) registry.lookup(tag);
            int resultado = serverInterface.calcularSuma(3,4);
            System.out.println(resultado);
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
