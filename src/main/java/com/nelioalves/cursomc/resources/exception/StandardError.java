package com.nelioalves.cursomc.resources.exception;

import java.io.Serializable;

/*
 * Para gerar erros padronizados cod. http, msg erro, hora certa que ocorreu o erro
 */
public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private	Integer status;  // o status do erro
	private String msg;      // a mensagem
	private Long timeStamp;  // o instante que aconteceu
	
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		System.out.println(status);
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	

}
