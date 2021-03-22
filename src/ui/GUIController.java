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
    	readData(br);
    	
    }
    
    
    public void readData(BufferedReader br) throws NumberFormatException, IOException
    {
    	library.asingCashers(Integer.parseInt(br.readLine()));
    	int stands = Integer.parseInt(br.readLine());
    	for (int i = 0; i < stands; i++)
    	{
    		String std[] = br.readLine().split(" ");
    		library.addStand(std[0], new Stand(std[0], Integer.parseInt(std[1])));
    		for (int j = 0; j < Integer.parseInt(std[1]); i++)
    		{
    			String[] prt = br.readLine().split(" ");
    			library.getStands().search(std[0]).add(new Book(prt[0], Integer.parseInt(prt[2]),Double.parseDouble(prt[1]),std[0]));
    			if (!library.getDataBase().contains(prt[0])) library.getDataBase().insert(prt[0], std[0]);
    		}
    	}
    	
    	int clients = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < clients; i++)
    	{
    		String[] prt = br.readLine().split(" ");
    		library.addClient(prt[0], prt, i);
    	}
    	
    	
    }
    
    
    public void saveFile() throws IOException
    {
    	File file;
    	
    	FileChooser f = new FileChooser();
    	f.setTitle("saveFile");
    	file = f.showSaveDialog(null);
    	library.setPath(file);
    	
    }
    
    
}
