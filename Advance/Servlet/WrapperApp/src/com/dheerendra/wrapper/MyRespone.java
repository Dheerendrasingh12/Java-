package com.dheerendra.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyRespone extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	private CharArrayWriter writer;

	public MyRespone(HttpServletResponse response) {
		super(response);

		this.response = response;
		writer = new CharArrayWriter();

	}

	public PrintWriter getWriter() throws IOException {
		PrintWriter pw = new PrintWriter(writer);
		return pw;
	}

	@Override
	public String toString() {
		return writer.toString();
	}

}
