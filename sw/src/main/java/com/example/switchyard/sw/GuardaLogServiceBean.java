package com.example.switchyard.sw;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.switchyard.component.bean.Service;

import cl.gob.sii.vo.LogVO;

@Service(GuardaLogService.class)
public class GuardaLogServiceBean implements GuardaLogService {

	@Override
	public LogVO guardaLog(LogVO logVo) {
		
		// TODO Logica de SII.
		
		String msgLog = null;
	  	String rspserver = null;
	  	
	  	String HOST = "10.20.17.121";
	  	int PORT	= 9999;
	  	 
		
	  	Socket clientSocket;
		try {
			clientSocket = new Socket(HOST, PORT);
		
	  	    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  	    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			msgLog = logVo.getLog();
			System.out.println("TO SERVER: " + msgLog);
			
			outToServer.writeBytes(msgLog + '\n');
			rspserver = inFromServer.readLine();
	  		
			System.out.println("FROM SERVER: " + rspserver);
	  		
	  		logVo.setRespuesta(rspserver);
	  		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logVo;
	}
		
		

}
