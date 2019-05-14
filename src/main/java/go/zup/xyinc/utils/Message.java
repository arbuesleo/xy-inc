package go.zup.xyinc.utils;

import java.util.HashMap;
import java.util.Map;

public class Message <T>{
	private  Map<String, String> atributos = new HashMap<String, String>();

	private T data;
	
	public void addField(String name, String value) {
		this.atributos.put(name.toUpperCase(), value.toUpperCase());
	}

	public String getValue(String name) {
		String value = this.atributos.get(name);
		return value;
	}

	public Map<String, String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, String> erro) {
		this.atributos = erro;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
