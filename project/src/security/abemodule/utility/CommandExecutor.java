package security.abemodule.utility;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CommandExecutor{
	String command;
	String []commands;
	boolean multiplecommands;
	CommandTest commandtest;
	
	public CommandExecutor(){
		commandtest = new CommandTest();
	}
	public CommandExecutor(String command){
		this.command = command;
		multiplecommands=false;
		commandtest = new CommandTest();
	}
	public CommandExecutor(String []commands){
		this.commands = commands;
		multiplecommands = true;
		commandtest = new CommandTest();
	}
	
	public void setCommand(String command){
		this.command = command;
		this.multiplecommands = false;
	}
	
	public void setCommand(String commands[]){
		this.commands = commands;
		this.multiplecommands = true;
	}
	
	public void executeCommand(){
		if(multiplecommands){
			commandtest.execute(commands);
		}
		else{
			commandtest.execute(command);
		}
		
	}
	
	public static void main(String[] args){
		CommandExecutor ce = new CommandExecutor();
		ce.setCommand("cd " + System.getenv("HIPAA_HOME"));
		ce.executeCommand();
	}
	

}