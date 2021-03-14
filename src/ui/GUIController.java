package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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
    
    
    public void process()
    {
    	
    	status.setText("Loading");
    	long startTime = System.currentTimeMillis();
    	
    	long diference = System.currentTimeMillis()-startTime;
    
    	while (diference <= 3000)
    	{
    		diference = System.currentTimeMillis()-startTime;
    		
    	}
    	
    	status.setText("complete");
    }
}
