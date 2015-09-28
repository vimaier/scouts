package com.sap.innojam.sample.ws;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sap.innojam.sample.entity.SensorData;

@ServerEndpoint(value = "/sensor", encoders = SensorData.Coder.class, decoders = SensorData.Coder.class)
public class SensorSocket extends BaseEndpoint<SensorData> {
	
	@OnMessage
	public void onMessage(SensorData sensor, Session session) throws IOException, EncodeException {
		sensor.setOwner(session.getUserPrincipal().getName());
		broadcast(sensor);
	}

}
