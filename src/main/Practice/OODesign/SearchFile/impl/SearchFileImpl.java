package main.Practice.OODesign.SearchFile.impl;

import main.Practice.OODesign.SearchFile.Operation;
import main.Practice.OODesign.SearchFile.SearchFile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;

public class SearchFileImpl implements SearchFile {

    private File file;

    public SearchFileImpl(File file) {
        this.file = file;
    }


    @Override
    public File searchFile(Operation op) {
        File f = new File("C:\\example");
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                System.out.println((new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")).format(dir.lastModified()));
                return name.startsWith("temp") && name.endsWith("txt");
            }
        });
        f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });
        return f;
    }
}
