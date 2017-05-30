package resource;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Test the Java URLEncoder class, passing it a few different strings
 * to see what the resulting output looks like.
 * 
 * @author alvin alexander, devdaily.com.
 * 
 */
public class Codificacao
{
 
	/*public static void main(String[] args) throws UnsupportedEncodingException
  {
    // one easy string, one that's a little bit harder
    String[] testStrings = {"All fall gala hall", 
                            "this\\is/a%test\t_~!@#$%^&*()dude"};
    for (String s : testStrings)
    {
      String encodedString = URLEncoder.encode(s, "UTF-8");
      //System.out.format("'%s'\n", encodedString);
      System.out.format("%s", encodedString);
    }
  }
  */
	
  public String utf8(String[] arg)throws UnsupportedEncodingException{
	    String encodedString = null;
	  for (String s : arg)
	    {
	      encodedString = URLEncoder.encode(s, "UTF-8");
	    }  
	  return encodedString;
  }
  
}