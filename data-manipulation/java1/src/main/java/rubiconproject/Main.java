package rubiconproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.service.SiteDataProcessor;

import java.io.File;

/**
 * Main app.
 *
 * @author vkolodrevskiy
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String OUTPUT_DEFAULT_FILE_NAME = "output.json";

    public static void main(String[] args) {
        if (args.length == 0 || isNullOrBlank(args[0])) {
            log.error("No path to directory.");
            return;
        }
        String outputFileName = (args.length > 1) ? args[1] : OUTPUT_DEFAULT_FILE_NAME;

        SiteDataProcessor processor = new SiteDataProcessor();
        processor.processFolder(new File(args[0]), new File(outputFileName));
    }

    private static boolean isNullOrBlank(String s) {
        return (s==null || s.trim().equals(""));
    }
}
