package com.bancoweb.banco.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	//CRIAR O DTO PARA EXIBIR OS DADOS DO CLIENTE QUE ACESSA A CONTA PARA VER, NUMERO, SALDO...
	//VERIFICAR O CÓDIGO E EXCEÇÕES
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Double decodeParamToDouble(String text) {
		try {
			Double valor = Double.parseDouble(URLDecoder.decode(text, "UTF-8"));
			return valor;
		} catch (UnsupportedEncodingException e) {
			return 0.0;
		}
	}
}
