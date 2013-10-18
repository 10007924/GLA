package GLA.tp2rmi.client;



	import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import GLA.tp2rmi.serveur.ReceiveMessageInterface;
	
	public class RmiClient {
		
	    static public void main(String args[]) {
	    	
			System.setSecurityManager(new RMISecurityManager());
			
			ReceiveMessageInterface rmiServer;
			Registry registry;
			String serverAddress="127.0.0.1";
			String serverPort="3232";
			String text="another one bites the silicium";
			System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
			
			try{
				// get the \u201cregistry\u201d
				System.out.println("1er try - registry");
				registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());
				System.out.println("1er try - registry end");
				System.out.println(registry);
				String plop[] = registry.list();
				System.out.println("" + plop.length + " " + plop[0].toString());
				// look up the remote object
				rmiServer=(ReceiveMessageInterface)(registry.lookup("rmiServer"));
				// call the remote method
				rmiServer.receiveMessage("plplpl");
				System.err.println(rmiServer.receiveMessage("toto"));}
			
			catch(RemoteException e){
				System.out.println("plouf !");
				e.printStackTrace();
			}
			
			catch(NotBoundException e){
				System.out.println("plouf2 !");
				e.printStackTrace();
			}
	    }
	}
	
	

