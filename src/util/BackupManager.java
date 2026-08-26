package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupManager {

    private static final String BACKUP_FOLDER = "backup";

    static {
        File folder = new File(BACKUP_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static void backupFile(String sourceFile, String backupFile) throws IOException {
        Files.copy(new File(sourceFile).toPath(), new File(BACKUP_FOLDER + File.separator + backupFile).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public static void restoreFile(String backupFile, String destinationFile) throws IOException {
        Files.copy(new File(BACKUP_FOLDER + File.separator + backupFile).toPath(), new File(destinationFile).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }
}
