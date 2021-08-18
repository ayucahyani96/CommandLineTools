package picocli;
 
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
 
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
 
import static java.nio.file.Files.createFile;
import static java.nio.file.Path.of;
 
@Command(name = "fileCliTool", description = "Performs file manipulation operations", mixinStandardHelpOptions = true, version = "File Client 1.0")
public class FileCliTool implements Callable<String> {
 
   
    @Option(names = "-o")
    private String pathName;
    
    @Option(names = "-t json")
    private boolean fileTypeJson;

    @Option(names = "-t text")
    private boolean fileTypeText;
 
    @Option(names = "-h")
    private boolean userGuide;
 
    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new FileCliTool()).execute(args);
        System.exit(exitCode);
    }
 
    public String call() throws Exception {
 
    	if(fileTypeJson && fileTypeText == false) {
    		fileTypeText = true;
    		if (pathName != null) {
                Path file = of(pathName);
                if (!file.toFile().exists()) {
                    createFile(file);
                }
            }
    	}else if(fileTypeJson == false && fileTypeText == true) {
    		fileTypeText = true;
    		if (pathName != null) {
                Path file = of(pathName);
                if (!file.toFile().exists()) {
                    createFile(file);
                }
            }
    	}else {
    		fileTypeJson = true;
    		if (pathName != null) {
                Path file = of(pathName);
                if (!file.toFile().exists()) {
                    createFile(file);
                }
            }
    	}
    	
    	if(userGuide == true) {
    		System.out.println("This is the user guide . . .");
    	}
        
        return "success";
    }
}