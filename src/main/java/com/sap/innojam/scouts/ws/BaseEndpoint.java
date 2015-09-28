package com.sap.innojam.scouts.ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public abstract class BaseEndpoint<T> {
	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session peer) {
		peers.add(peer);
	}

	@OnClose
	public void onClose(Session peer) {
		peers.remove(peer);
	}

	public void broadcast(T object) {
		for (Session peer : peers) {
			try {
				peer.getBasicRemote().sendObject(object);
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
		}
	}
}