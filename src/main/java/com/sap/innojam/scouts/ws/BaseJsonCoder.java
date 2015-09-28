package com.sap.innojam.scouts.ws;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseJsonCoder<T> implements Encoder.TextStream<T>, Decoder.TextStream<T> {
	private Class<T> type;
	private ObjectMapper objectMapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	@Override
	public void init(EndpointConfig endpointConfig) {
		ParameterizedType genericClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type actualType = genericClass.getActualTypeArguments()[0];
		if (actualType instanceof Class) {
			type = (Class<T>) actualType;
		} else if (actualType instanceof ParameterizedType) {
			type = (Class<T>) ((ParameterizedType) actualType).getRawType();
		}
	}

	@Override
	public void encode(T object, Writer writer) throws EncodeException, IOException {
		objectMapper.writeValue(writer, object);
	}

	@Override
	public T decode(Reader reader) throws DecodeException, IOException {
		return objectMapper.readValue(reader, type);
	}

	@Override
	public void destroy() {
	}
}