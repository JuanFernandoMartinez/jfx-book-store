//quick sort method is based on https://geekytheory.com/como-leer-un-fichero-en-javacode
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import structures.HashTable;
import structures.Queue;

public class Library {
	
	private HashTable<String,Stand> stands;
	private Queue<Client> clients;
	private Queue<Book>[] cashers;
	private HashTable<String, String> dataBase;
	private File outputPath;
	
	
	public Library() {
		stands = new HashTable<>(31);
		clients = new Queue<>();
		dataBase = new HashTable<>(11);
		outputPath = null;
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
	
	public void asingCashers(int n)
	{
		cashers = (Queue<Book>[])new Queue[n];
		for (int i = 0; i  < n; i++)
		{
			cashers[i] = new Queue<>();
		}
	}
	
	
	public void setPath(File file )
	{
		outputPath = file;
	}
	
	
	public Book[] bookMergeSort(Book[] a, int start, int end)
	{
		int size = end-start+1;
		
		if (size == 1)
		{
			Book[] aux = {a[start]};
			return aux;
		}else
		{
			Book[] left = bookMergeSort(a, start, (int)((start+end)/2));
			Book[] right = bookMergeSort(a,(int)((start+end)/2)+1,end);
			int s1 = 0;
			int s2 = 0;
			Book[] c = new Book[size];
			int index = 0;
			
			while (s1<left.length && s2 < right.length)
			{
				if (left[s1].compareTo(right[s2]) > 0)
				{
					c[index] = right[s2];
					s2++;
					index++;
				}else
				{
					c[index] = left[s1];
					s1++;
					index++;
				}
			}
			
			if (s1 == left.length)
			{
				for (int i = s2; i < right.length; i++)
				{
					c[index] = right[i];
					index++;
				}
			}else
			{
				for (int i = s1; i < left.length; i++)
				{
					c[index] = left[i];
					index++;
				}
			}
			
			
			return c;
			
		}
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
	
	
	
	
	public String listBooks(Client c)
	{
		String[] aux = c.getWished();
		Book[] bs = new Book[c.getWished().length];
		int index = 0;
		for (int i = 1; i < bs.length; i++)
		{
			if (dataBase.contains(aux[i]))
			{
				String std = dataBase.search(aux[i]);
				Book b = stands.search(std).search(aux[i]);
				
				bs[index] = new Book(b.getISBNCode(), 1, b.getPrice(), std);
				b.removeOne();
				if (b.getQuantity() == 0)
				{
					dataBase.remove(b.getISBNCode());
				}
				index++;
			}
		}
		
		boolean found = false;
		int nIndex = 0;
		for (int i = 0; i < bs.length&& !found; i++  )
		{
			if (bs[i] != null)
			{
				nIndex++;
			}else
			{
				found = true;
			}
		}
		
		Book[] finalList = new Book[nIndex];
		
		for (int i = 0; i < nIndex; i++)
		{
			finalList[i] = bs[i+1];
		}
		
		finalList = sortWishes(finalList, 1);
		
		for (int i = 0; i < finalList.length; i++)
		{
			c.getList().push(finalList[i]);
		}
		
		String out = "[ "+ finalList[0].getISBNCode();
		for (int i = 1; i <  finalList.length; i++)
		{
			out += " , "+finalList[i].getISBNCode(); 
		}
		
		out+= " ]";
		
		return out;
	}
	
	
	public Book[] sortWishes(Book[] bs, int choice)
	{
		switch (choice) {
		case 1:
			return bookMergeSort(bs,0,bs.length);
			

		default:
			return null;
			
		}
	}
	
	
	public static void quicksort( Book[] a, int left, int right) {
	    if (left < right) {
	        int pivot = particion(a, left, right);
	        quicksort(a, left, pivot);
	        quicksort(a, pivot + 1, right);
	    }
	}

	private static int particion(Book[] a, int left, int right) {
	        Book pivot = a[left];
	        // infinite loop
	        while (true) {
	            while (a[left].compareTo(pivot)<0) {
	                left++;
	            }
	            while (a[right].compareTo(pivot)>0) {
	                right--;
	            }
	            if (left >= right) {
	                return right;
	            } else {//Note: else is not neede but make the code more understandable
	                Book aux = a[left];
	                a[left] = a[right];
	                a[right] = aux;
	                left++;
	                right--;
	            }
	            // while works until left >= right
	        }
	    }
	
	public Client[] ClientMergeSort(Client[] a, int start, int end)
	{
		int size = end-start+1;
		
		if (size == 1)
		{
			Client[] aux = {a[start]};
			return aux;
		}else
		{
			Client[] left = ClientMergeSort(a, start, (int)((start+end)/2));
			Client[] right = ClientMergeSort(a,(int)((start+end)/2)+1,end);
			int s1 = 0;
			int s2 = 0;
			Client[] c = new Client[size];
			int index = 0;
			
			while (s1<left.length && s2 < right.length)
			{
				if (left[s1].compareTo(right[s2]) > 0)
				{
					c[index] = right[s2];
					s2++;
					index++;
				}else
				{
					c[index] = left[s1];
					s1++;
					index++;
				}
			}
			
			if (s1 == left.length)
			{
				for (int i = s2; i < right.length; i++)
				{
					c[index] = right[i];
					index++;
				}
			}else
			{
				for (int i = s1; i < left.length; i++)
				{
					c[index] = left[i];
					index++;
				}
			}
			
			
			return c;
			
		}
	}
	
	
	
	public Queue<Client> sortClients(Queue<Client> a)
	{
		Client[] aux = new Client[a.size()];
		for (int i = 0; i < aux.length; i++)
		{
			if (a.top().getDeck().size()>0)
			{
				aux[i] = a.top();
				aux[i].setTime(aux[i].getTime()+aux[i].getDeck().size());
			}
			
			a.pop();
			
		}
		
		aux = ClientMergeSort(aux, 0, aux.length-1);
		
		for (int i = 0; i< aux.length;i++)
		{
			a.push(aux[i]);
		}
		
		return a;
	}


	public HashTable<String, String> getDataBase() {
		return dataBase;
	}


	public void setDataBase(HashTable<String, String> dataBase) {
		this.dataBase = dataBase;
	}
	
	
	
	
	// modular process
	
	public String section1()
	{
		String out = "";
		out += "===================================\n";
		out += "           Section 1               \n";
		out += "===================================\n";
		out += "===================================\n";
		out += "           CLIENTS                 \n";
		out += "===================================\n\n";
		
		Queue<Client> aux = new Queue<>();
		while (clients.size()> 0)
		{
			Client current = clients.top();
			out+= "id: "+current.getId()+"* SBN codes: "+ Arrays.toString(current.getWished())+" current Time: "+current.getTime()+"\n";
			
			aux.push(clients.top());
			clients.pop();
		}
		
		
		out += "===================================\n";
		out += "           Section 2               \n";
		out += "===================================\n";
		out += "===================================\n";
		out += "           CLIENTS                 \n";
		out += "===================================\n\n";
		
		while (aux.size()> 0)
		{
			Client current = aux.top();
			out += "id: "+ current.getId()+" sorted books list: "+listBooks(current)+"\n";
			clients.push(aux.top());
			aux.pop();
		}
		
		
		return out;
	}
	
	
	public String section2()
	{
		String out = "";
		out += "===================================\n";
		out += "           Section 3               \n";
		out += "===================================\n";
		out += "===================================\n";
		out += "           Payment Order                 \n";
		out += "===================================\n\n";
		
		
		clients = sortClients(clients);
		
		
		Queue<Client> aux = new Queue<>();
		
		while (clients.size()>0)
		{
			Client current = clients.top();
			out += "1"+current.getId()+" "+current.getTime()+"Minutes\n";
			aux.push(clients.top());
			clients.pop();
		}
		
		
		while (aux.size()>0)
		{
			clients.push(aux.top());
			aux.pop();
		}
		
		return out;
	}
	
	
	
	
	public void writeOutput()
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
		
	}
	
	
}
	
	
	
	
	


