import java.util.*;
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}
public class CircularLinked{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		System.out.println("Enter the size of linkedlist");
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			list.create(sc.nextInt());
		}
		//list.display();
		int l=list.len();
		System.out.println("-----------------");
		// list.insert(0,259,l);
		// list.insert(5,269,l);
		// list.insert(15,45,l);
		// list.insert(2,289,l);
		System.out.println("Where u want to delete the element");
		list.delete(sc.nextInt());
		list.display();
	}
}
class LinkedList{
	Node head;
	Node temp;
	public void create(int data){
		Node node= new Node(data);
		
		if (head==null){
			head=node;
			temp=head;
		}
		else{
			temp.next=node;
			temp=node;
		}
	temp.next=head;	
	}
	public void display(){
		Node n=head;
		if (head==null){
			System.out.println("List is empty");
		}
		else{
			do{
				System.out.println(n.data);
				n=n.next;
			}
			while(n!=head);
		}
	}
	public int len(){
		Node n=head;
		int l=0;
		do{
			l++;
			n=n.next;
		}while(n!=head);
		return l;
	}
	public void insert(int pos,int data,int length){
		Node node= new Node(data);
		Node n=head;
		if (pos<0 || pos>length){
			System.out.println("please Enter correct data");
			return;
		}
		if (pos==0){
			if (head==null){
				head=node;
				node.next=head;
			}else{
				while(n.next!=head){
					n=n.next;
				}
				n.next=node;
				node.next=head;
				head=node;
			}
		}else{
			for(int i=0;i<pos-1;i++){
				n=n.next;
			}
			node.next=n.next;
			n.next=node;
		}
	}
	public void delete(int pos){
		Node n=head;
		Node n1=null;
		if (pos<1){
			System.out.println("Please Enter the correct key");
			return;
		}
		if (pos==1){
			while(n.next!=head){
				n=n.next;
			}
			if (head==n){
				head=null;
			}else{
				n.next=head.next;
				head=n.next;
			}
		}else{
			for(int i=0;i<pos-2;i++){
				n=n.next;
			}
			n1=n.next;
			n.next=n1.next;
			n1=null;
			
		}
	}
}