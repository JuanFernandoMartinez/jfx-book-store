package model;

import structures.HashTable;
import structures.Queue;

public class Library {
	
	private HashTable<String,Stand> stands;
	private Queue<Client> clients;
	private Queue<Book>[] cashers;
	
	
	public Library() {
		stands = new HashTable<>(31);
		clients = new Queue<>();
	}
	
	
	public void addStand(String id, Stand s)
	{
		stands.insert(id,s);
	}
	
	public void addClient(String id, String[] wishes, int time)
	{
		Client c = new Client(id, wishes, time);
		clients.add(c);
	}
	
	public void setCashers(int n)
	{
		cashers = (Queue<Book>[])new Queue[n];
	}
	
	
	public void sortWishes(String[] a)
	{
		
	}


	public HashTable<String, Stand> getStands() {
		return stands;
	}


	public void setStands(HashTable<String, Stand> stands) {
		this.stands = stands;
	}


	public Queue<Client> getClients() {
		return clients;
	}


	public void setClients(Queue<Client> clients) {
		this.clients = clients;
	}


	public Queue<Book>[] getCashers() {
		return cashers;
	}


	public void setCashers(Queue<Book>[] cashers) {
		this.cashers = cashers;
	}
	
	public void collectBooks()
	{
		Client[] cli = new Client[clients.size()];
		for (int i = 0; i < cli.length; i++)
		{
			cli[i] = clients.top();
			clients.pop();
			cli[i].setTime(cli[i].getTime()+(cli[i].getDeck().size()-1));
		}
		
		mergeSort(cli, 0, 0);
		for (int i = 0; i < cli.length; i++)
		{
			clients.push(cli[0]);
		}
		
		
	}
	
	
	
	public Client[] mergeSort(Client[] a,int start, int end)
	{
		
		return null;
		
	}
	
	
	public void payPoint()
	{
		Queue<Client> out = new Queue<>();
		
		
	}
	
}
	
	
	
	
	


