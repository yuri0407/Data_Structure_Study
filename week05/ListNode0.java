package week05;

class ListNode0{
	private String data;
	public ListNode0 link;
	public ListNode0(){
		this.data = null;
		this.link = null;
	}
	public ListNode0(String data){
		this.data = data;
		this.link = null;
	}
	public ListNode0(String data, ListNode0 link){
		this.data = data;
		this.link = link;
	}
	public String getData(){
		return  this.data;
	}
}
