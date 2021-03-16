package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class GUIController {

	@FXML
    private TextField filePath;

    @FXML
    private Label status;
    
    
    public GUIController(boolean b) {
		
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
    
    
    public void process() throws InterruptedException
    {
    	
    	status.setText("loading");
    	Thread.sleep(3000);
    	status.setText("Complete");
    	try {
			saveFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
