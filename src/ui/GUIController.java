package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.Book;
import model.Library;
import model.Stand;


public class GUIController {
	
	private Library library;

	@FXML
    private TextField filePath;

    @FXML
    private Label status;
    
    
    public GUIController(Library b) {
		this.library = b;
	}
    
    
    
    
    public void selectFile()
    {
    	
    	FileChooser f = new FileChooser();
    	f.setTitle("select file");
    	f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));
    	try {
    		filePath.setText(f.showOpenDialog(null).toString());
    	}catch (NullPointerException e)
    	{
    		filePath.setText("");
    	}
    	

    }
    
    
    public void process() throws InterruptedException, NumberFormatException, IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filePath.getText()));
    	int testCases = Integer.parseInt(br.readLine());
    	for (int i = 0; i < testCases; i++)
    	{
    		readData(br);
    	}
    	
    }
    
    
    public void readData(BufferedReader br) throws NumberFormatException, IOException
    {
    	library.setCashers(Integer.parseInt(br.readLine()));
    	int stands = Integer.parseInt(br.readLine());
    	String currentStand = "";
    	while (stands > 0)
    	{
    		String[] prt = br.readLine().split(" ");
    		if (prt.length == 2)
    		{
    			stands--;
    			stands+= Integer.parseInt(prt[1]);
    			library.addStand(prt[0], new Stand(prt[0], Integer.parseInt(prt[1])));
    			currentStand = prt[0];
    		}else
    		{
    			library.getStands().search(currentStand).add(new Book(prt[0], Integer.parseInt(prt[2]), Double.parseDouble(prt[1])));
    			stands--;
    		}
    	}
    	
    	int clients = Integer.parseInt(br.readLine());
    	for (int i = 0; i < clients; i++)
    	{
    		String[] prt = br.readLine().split(" ");
    		library.addClient(prt[0], prt, i+1);
    	}
    	
    	saveFile();
    	
    	
    }
    
    
    public void saveFile() throws IOException
    {
    	File file;
    	
    	FileChooser f = new FileChooser();
    	f.setTitle("saveFile");
    	file = f.showSaveDialog(null);
    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    	bw.write("hola mundo\n");
    	bw.write("Esta es una prueba\n");
    	for (int i = 0; i < 10; i++)
    	{
    		bw.write((i+1)+"\n");
    	}
    	
    	bw.close();
    	
    }
    
    
}
