package com.google.gwt.dev.codeserver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.dev.util.log.PrintWriterTreeLogger;


public class IncrementalCompiler {
  
  public static void main(String[] args) throws Exception {
    args = new String[]{
        "org.gquery.gwtcases.GwtCasesSD",
        "/home/manolo/git/gwt-cases/src/main/java/",
        "/tmp/gwt-cases"
      };
    String moduleName = args[0];
    
    List<File> sourcePath = new ArrayList<File>();
    for (int i = 1; i < args.length; i++) {
      sourcePath.add(new File(args[i]));
    }

    File workDir = new File(args[2]);
    boolean full = !workDir.exists();
    
    workDir.mkdirs();
    System.out.println("workDir: " + workDir);
    
    AppSpace appSpace = AppSpace.create(new File(workDir, moduleName));
    
    PrintWriterTreeLogger logger = new PrintWriterTreeLogger();

    Recompiler recompiler = new Recompiler(appSpace, moduleName, sourcePath, "localhost:7654", logger);
    
    if (full) {
      recompiler.compile(new HashMap<String, String>());
    } else {
      recompiler.reCompile(new HashMap<String, String>());
    }
  }

}
