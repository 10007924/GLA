package GLA.tp2rmi.serveur;

import java.rmi.RemoteException;

public class ReceiveMessageImpl implements ReceiveMessageInterface {
	public String receiveMessage(String x) throws RemoteException {
		System.out.println(x.toUpperCase());
		return x.toUpperCase();
	}
} 