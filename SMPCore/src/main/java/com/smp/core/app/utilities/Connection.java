package com.smp.core.app.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {

	private URL endpoint;
	private HttpURLConnection conn;

	public Connection() {
	
	}
	
	public HttpURLConnection stablishConnection(String url, String typeReq, String typeRes) {
		try {
			this.endpoint = new URL(url);
			this.conn = (HttpURLConnection) this.endpoint.openConnection();
			this.conn.setRequestMethod(typeReq);
			this.conn.setRequestProperty("Accept", typeRes);
			return this.conn;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public InputStream connectionData() {
		try {
			return this.conn.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URL getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(URL endpoint) {
		this.endpoint = endpoint;
	}

	public HttpURLConnection getConn() {
		return conn;
	}

	public void setConn(HttpURLConnection conn) {
		this.conn = conn;
	}

}
