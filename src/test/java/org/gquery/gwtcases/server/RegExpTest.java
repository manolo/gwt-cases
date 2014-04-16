package org.gquery.gwtcases.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import junit.framework.TestCase;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

public class RegExpTest extends TestCase {
  
  public void testReg1() {
    String r1 = "(?!.*\\.(html|css|png|jpg)$).+";
    String r2 = ".+(?<!\\.(html|css|png|jpg))";
    String i1 = "/index.html";
    String i2 = "/adf89008.aaa";

    System.out.println(i1.matches(r1));
    System.out.println(i2.matches(r1));
    System.out.println(i1.matches(r2));
    System.out.println(i2.matches(r2));

  }
  
  private void f2(String a, Object...o) {
    System.out.println(o[0].getClass().getName() + " " + o[0].getClass().isArray());
  }

  private void f1(Object...o) {
    System.out.println(o[0].getClass().getName() + " " + o[0].getClass().isArray());
    f2("e", o);
  }
  
  public void testArgs() {
    f1("foo");
  }
  
  public void testReg() throws Exception {
    String a = "json: \"application/json, text/javascript\"," +
        "\n\"*\": \"*/*\"";
    
    System.out.println(a
        .replaceAll("(?m)('.*?/)(\\*.*?')", "$1\\\\$2")
        .replaceAll("(?m)(\".*?/)(\\*.*?\")", "$1\\\\$2")
        .replaceAll("(?m)('.*?\\*)(/.*?')", "$1' + '$2")
        .replaceAll("(?m)(\".*?\\*)(/.*?\")", "$1\" + \"$2")        
        );
    
    String b = "/aaaaaa\\/bbbbb/cccc/ddddeeee/ffff/";
    b = "a = /aaaaaa\\/bbbbb*/; b.replace(/cccc\\/ddddeeee*/ig, 'ggg')/";
    
    b = "rprotocol=/^\\/\\//,rquery=/\\?/,rscript=/<script\\b[^<]*(?:(?!<\\/script>)<[^<]*)*<\\/script>/gi,rts=/([?&])\\/..\\/_=[^&]*/,rurl=/^([\\w\\+\\.\\-]+:)(?:\\/\\/([^\\/?#:]*)(?::(\\d+)|)|)/,";
//    b = "/^\\/\\//,cq=/\\?/,cr=/<script\\b[^<]*(?:(?!<\\/script>)<[^<]*)*<\\/script>/gi,cs=/([?&])_=[^&]*/,ct=/^([\\w\\+\\.\\-]+:)(?:\\/\\/([^\\/?#:]*)(?::(\\d+)|)|)/";
    System.out.println("            " + b + "\n" + b
        .replaceAll("'([^\\\\']+|\\\\([btnfr\"'\\\\]|[0-3]?[0-7]{1,2}|u[0-9a-fA-F]{4}))*'|\"([^\\\\\"]+|\\\\([btnfr\"'\\\\]|[0-3]?[0-7]{1,2}|u[0-9a-fA-F]{4}))*\"", "")
       );
    
//    /"[^"\\]*(?:\\.[^"\\]*)*/
    
   }
  
  TreeLogger l = new TreeLogger() {
    public void log(Type type, String msg, Throwable caught, HelpInfo helpInfo) {
      System.out.println(msg);
    }
    public boolean isLoggable(Type type) {
      return true;
    }
    
    public TreeLogger branch(Type type, String msg, Throwable caught, HelpInfo helpInfo) {
      return this;
    }
  };
  
  
  public void read() throws Exception {
    String jsni = getContent(l, "" , "jquery.js");
    
    // TODO: write a parser instead of regular expressions.
    jsni = jsni

        //// Split lines, useful for debugging
        // Split compressed js files so as we can edit the result in an editor to inspect the code easily
        // .replaceAll("([;\\}\\)])(if\\(|while\\(|for\\(|return |var )", "$1\n$2")

        //// C++ comments, useful for inspecting output, but could produce errors with compacted libraries
        // remove 'c++' (//) style comment lines
        // .replaceAll("(?m)^\\s*//.*$", "")
        // remove 'c++' (//) style comments at the end of a code line
        // .replaceAll("(?m)^([^/]*)//[^'\"]*?$", "$1")

        // remove MS <CR>
        .replace("\r", "")

        ////  We must get rid of '/*' to avoid syntax errors in GWT JSNI blocks
        // Replace: "/*" by "/\*" in strings
//        .replaceAll("('.*?/)(\\*.*?')", "$1\\\\$2")
//        .replaceAll("(\".*?/)(\\*.*?\")", "$1\\\\$2")
        // Replace: "*/" by "*" + "/" in strings
//        .replaceAll("('.*?\\*)(/.*?')", "$1' + '$2")
//        .replaceAll("(\".*?\\*)(/.*?\")", "$1\" + \"$2")
        // replace js inline regular expressions finishing with "*/" with "new Regex()"
        .replaceAll("(?m)([=\\(]\\s*)/([^\\\\/]*?(?:\\\\/[^\\\\/]*?).*?)\\*/([igm]*)", "\n\n\n%%%%%%\n\n\n$1new  RegExp('$2','$3')\n\n\n%%%%%%\n\n\n")
        // remove 'c' style (/* */) comments blocks
//        .replaceAll("/\\*(?>(?:(?>[^\\*]+)|\\*(?!/))*)\\*/", "")

        // remove empty lines
//        .replaceAll(".*%%%%%%(.*)%%%%%%.*", "$1")
        ;
    
    // Using pw instead of sw in order to avoid stack errors because sw.print is a recursive function
    // and it fails with very long javascript files.
        
    // JMethod.toString() prints the java signature of the method, so we just have to replace abstract by native.   
    
    System.out.println(jsni .replaceAll("([;\\}\\)])(if\\(|while\\(|for\\(|return |var )", "$1\n$2"));
    
  }
  
  private String getContent(TreeLogger logger, String path, String src) throws UnableToCompleteException {
    HttpURLConnection connection = null;
    InputStream in = null;
    try {
      if (!src.matches("(?i)https?://.*")) {
        String file = path + File.separator + src;
        in = new FileInputStream(new File("/tmp/jquery.js"));
//        in = this.getClass().getClassLoader().getResourceAsStream(file);
        if (in == null) {
          logger.log(TreeLogger.ERROR, "Unable to read javascript file: " + file);
          throw new UnableToCompleteException();
        }
      } else {
        URL url = new URL(src);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        connection.setRequestProperty("Host", url.getHost());
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);

        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
          logger.log(TreeLogger.ERROR, "Server Error: " + status + " " + connection.getResponseMessage());
          throw new UnableToCompleteException();
        }

        String encoding = connection.getContentEncoding();
        in = connection.getInputStream();
        if ("gzip".equalsIgnoreCase(encoding)) {
          in = new GZIPInputStream(in);
        } else if ("deflate".equalsIgnoreCase(encoding)) {
          in = new InflaterInputStream(in);
        }
      }
      
      return readIs(in);
    } catch (IOException e) {
      logger.log(TreeLogger.ERROR, "Error: " + e.getMessage());
      throw new UnableToCompleteException();
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }    
  }
  
  private String readIs(InputStream in) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    byte[] buffer = new byte[4096];
    int read = in.read(buffer);
    while (read != -1) {
      bytes.write(buffer, 0, read);
      read = in.read(buffer);
    }
    in.close();
    return bytes.toString();
  }
  


}
