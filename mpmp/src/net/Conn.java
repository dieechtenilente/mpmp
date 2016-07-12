package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.SocketException;
import java.net.Socket;
import java.util.Arrays;

/**
 * Class Conn implements the connection to a Client or the server.
 */
public class Conn {
	private BufferedReader in;
	private PrintWriter out;
	private Socket sock;
	private Cmd lastcmd;

	public Conn(Socket sock) throws IOException {
		this.sock = sock;

		// It is detestable that UTF-8 is not the default -oki
		in = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));
		out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"), true);
	}

	/**
	 * Handles the connection to a client, reading and writing commands and
	 * replies.
	 */
	public void handle() throws SocketException, IOException {
		String line, cmd;
		Cmd c;
		int delim;

		for (;;) {
			line = in.readLine();
			if(line == null)
				return;  // Connection has been closed...

			// Log all protocol packets. Neat debugging hook.
			System.err.println("->proto: " + line);

			delim = line.indexOf(' ');

			if (delim < 0)
				delim = line.length();

			cmd = line.substring(0, delim);
			if(cmd.equals("+JAWOHL"))
				continue;
			
			if (cmd.equals("-NEIN")) {
				errHandle(line, lastcmd);
				continue;
			}

			c = Cmd.search(cmd);
			if (c == null) {
				sendErr(ErrCode.Command, cmd);
				continue;
			}

			c.exec(line, this);
		}
	}

	public synchronized String readLine() {
		try {
			return in.readLine();
		} catch(IOException ioe) {
			return null;
		}
	}

	public synchronized void send(String line) {
		out.println(line);
		System.out.println("proto->: " + line);

		// Save the last command for error handling
		int delim = line.indexOf(' ');
		if (delim < 0)
			delim = line.length();
			
		String cmd = line.substring(0, delim);
		lastcmd = Cmd.search(cmd);
	}

	/**
	 * Send a line continuing a multi-line command.
	 */
	public synchronized void sendCont(String line) {
		out.println(line);
		System.out.println("proto->: " + line);
	}

	public synchronized void sendOK() {
		out.println("+JAWOHL");
	}

	public synchronized void sendErr(ErrCode err){
		out.println("-NEIN " + err.getCode() + " " + err.getMessage());
	}
	
	public synchronized void sendErr(ErrCode err, String s){
		out.println("-NEIN " + err.getCode() + " " + err.getMessage() + " " + s);
	}
	
	public void disconnect() {
		try {
			sock.close();
		} catch(IOException ioe) {
			;
		}
	}
	
	private void errHandle(String line, Cmd cmd) {
		String[] args = line.split(" ");
		ErrCode err;
		String message = null;
		
		if (args.length < 2)
			return;

		if (args.length > 2)
			message = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
		
		try {
			err = ErrCode.search(Integer.parseInt(args[1]));
			cmd.error(err, message, this);
		} catch(NumberFormatException nfe) {
			//XXX error in error :(
		}
	}
}
