package ui;


import java.io.File;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import model.Library;



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
    	
    	
    	readData(filePath.getText());
    	
    }
    
    
    public void readData(String Path) throws NumberFormatException, IOException
    {
    	
    	library.readInput(Path);
    	saveFile();
    	library.start();
    	
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
