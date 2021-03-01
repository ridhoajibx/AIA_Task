import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class ReadMoveFiles {
	//	static logger
	static Logger logger = Logger.getLogger(ReadMoveFiles.class.getName());
	
	public static void main(String[] args) throws IOException {
		//1. Source folder
		final File folder = new File("/home/ridhoajibx/Documents/java/SomeFile");
		
		//2. Read all files in folder
		listFilesForFolder(folder);      
		
	}	
	
	public static void listFilesForFolder(final File folder) throws IOException {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	//3. Move
	        	moveFile(fileEntry);
	        }
	    }
	}
	
	public static void moveFile(File fileEntry) throws IOException {
        FileHandler handler = new FileHandler("/home/ridhoajibx/Documents/java/FileMove.log", true);        
        logger.addHandler(handler);
        SimpleFormatter formatter = new SimpleFormatter();  
        handler.setFormatter(formatter);
        
        logger.info("start");
        
		Path source = Paths.get(fileEntry.getPath());
		Path target = Paths.get("/home/ridhoajibx/Documents/java/DestFile/" + fileEntry.getName());
		if(fileEntry.getName().endsWith(".pdf") || fileEntry.getName().endsWith(".xlxs")) {
			try {
				Files.move(source, target);
				logger.info("Status : Files " + source.getFileName() + " moved Successfully!");
				logger.info("Destination : Files move to " + target.toRealPath());
			} catch (Exception e) {
				logger.info(e.getLocalizedMessage() + " failed to move the file");
			}
		} else {
			logger.info("file extension doesn't exist!");
		}
		
		logger.info("end");
	}
}
