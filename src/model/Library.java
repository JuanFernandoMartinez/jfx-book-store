//quick sort method is based on https://parzibyte.me/blog/2019/12/26/quicksort-java-ordenar-arreglos/
//merge sort based is based on https://platzi.com/tutoriales/1469-algoritmos/4260-merge-sort-en-java/
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import structures.HashTable;
import structures.Queue;

public class Library {
	
	private HashTable<String,Stand> stands;
	private Queue<Client> clients;
	private Casher[] cashers;
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
		cashers = new Casher[n];
		for (int i = 0; i  < n; i++)
		{
			cashers[i] = new Casher();
		}
	}
	
	
	public void setPath(File file )
	{
		outputPath = file;
	}
	
	
	public void bookMergeSort(Book[] a){
	    bookSort(a,0,a.length-1);
	}
	
	public void bookSort(Book arr[], int left, int right){
	    if(left < right){
	      
	      int middle = (left + right) / 2;
	      
	      
	      bookSort(arr, left, middle);
	      bookSort(arr, middle+1, right);

	      
	      bookMerge(arr, left, middle, right);
	    }
	}
	
	public void bookMerge(Book arr[], int left, int middle, int right) {
		  
		  int n1 = middle - left + 1;
		  int n2 = right - middle;

		  
		  Book leftArray[] = new Book[n1];
		  Book rightArray[] = new Book[n2];

		  
		  for (int i=0; i < n1; i++) {
		    leftArray[i] = arr[left+i];
		  }
		  for (int j=0; j < n2; j++) {
		    rightArray[j] = arr[middle + j + 1];
		  }
		  
		  int i = 0, j = 0;

		  
		  int k = left;

		 
		  while (i < n1 && j < n2) {
		    if (leftArray[i].compareTo(rightArray[j]) <1 ) {
		      arr[k] = leftArray[i];
		      i++;
		    } else {
		        arr[k] = rightArray[j];
		        j++;
		    }
		    k++;
		  }
		  
		  while (i < n1) {
		    arr[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  
		  while (j < n2) {
		    arr[k] = rightArray[j];
		    j++;
		    k++;
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


	public Casher[] getCashers() {
		return cashers;
	}


	public void setCashers(Casher[] cashers) {
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
			bookMergeSort(bs);
			return bs;
		case 2: 
			bookQuicksort(bs, 0, bs.length-1);
			return bs;
		

		default:
			return null;
			
		}
	}
	
	
	public static void bookQuicksort( Book[] a, int left, int right) {
	    if (left < right) {
	        int pivot = particion(a, left, right);
	        bookQuicksort(a, left, pivot);
	        bookQuicksort(a, pivot + 1, right);
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
	
	public String payment()
	{
		String out = "";
		Queue<Client> aux = new Queue<>();
		while (clients.size()>0)
		{
			int index = 1;
			for (Casher x:cashers)
			{
				if (x.isEmpty())
				{
					x.setClient(clients.top());
					aux.add(clients.top());
					clients.pop();
				}else
				{
					x.step();
				}
				out += "casher #"+index+" client id: "+x.getClient().getId()+ x.getClient().booksToString(x.getClient().getDeck().size()-x.getBS())+" // "; 
				out += "===================================================================================\n";
				out += "                                    Next Step                                      \n";
				out += "===================================================================================\n";
			}
		}
		
		while (aux.size()>0)
		{
			clients.push(aux.top());
			aux.pop();
		}
		
		return out;
	}
	
	public String finalOut()
	{
		String out = "";
		out += "======================================\n";
		out += "           Final output               \n";
		out += "======================================\n";
		
		while (clients.size()>0)
		{
			out+= clients.top().getId()+ " "+clients.top().calculateTotalPrice()+"\n";
			String bs = clients.top().booksToString(0);
			bs = bs.replace(" , ", " ");
			out+= bs+"\n";
			clients.pop();
		}
		
		return out;
	}
	
	
	
	public void start()
	{
		String out = "";
		out += section1()+"\n";
		out += section2()+"\n";
		out += payment()+"\n";
		out += finalOut()+"\n";
		try {
			writeOutput(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		
	}
	public void writeOutput(String out) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
		bw.write(out);
		bw.close();
	}
	
	
	public void readInput(String path) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		asingCashers(Integer.parseInt(br.readLine()));
    	int standsQuantity = Integer.parseInt(br.readLine());
    	for (int i = 0; i < standsQuantity; i++)
    	{
    		String s = br.readLine();
    		String std[] = s.split(" ");
    		addStand(std[0], new Stand(std[0], Integer.parseInt(std[1])));
    		
    		for (int j = 0; j < Integer.parseInt(std[1]); j++)
    		{
    			String r = br.readLine();
    			String[] prt = r.split(" ");
    			
    			
    			getStands().search(std[0]).add(new Book(prt[0], Integer.parseInt(prt[2]),Double.parseDouble(prt[1]),std[0]));
    			if (!getDataBase().contains(prt[0])) getDataBase().insert(prt[0], std[0]);
    		}
    	}
    	
    	int clients = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < clients; i++)
    	{
    		String[] prt = br.readLine().split(" ");
    		addClient(prt[0], prt, i);
    	}
    	
    	br.close();
	}
	

	
}
	
	
	
	
	


