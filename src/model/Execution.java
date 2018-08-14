package model;

public class Execution {
	
	//こいつがセッションスコープにいるときはSQLは実行されたという認識
	private String execution;
	
	public Execution () {
		
		this.execution = "sql実行されたよん";
		
	}
	
	public String setExecution (String exist) {
		
		this.execution = exist;
		return execution;
		
	}
	
	public String getExecution () {
		
		return execution;
		
	}

}
