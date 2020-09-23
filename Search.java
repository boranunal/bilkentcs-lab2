public class Search {

  public static void wordSearch(String text, String[] words) {
    for(String word : words) {
      wordSearch(text, word);
    }
  }
  public static void wordSearch(String text, String word) {
    int toffset, ooffset, len, index;
    int textLength = text.length();
    len = word.length();
    toffset = ooffset = 0;
    while(toffset+len < textLength) {
      if(text.regionMatches(true, toffset++, word, ooffset, len)) {
        index = toffset-1;
        if(10 < index && index+len+10 < textLength) {
          for(int i = 0; i<10; ++i)
            System.out.print(" ");
          System.out.println(word);
          System.out.println((text.substring(index-10,index+len+10)).replace('\n', ' '));
        }
        else if(10 < index) {
          for(int i = 0; i<10; ++i)
            System.out.print(" ");
          System.out.println(word);
          System.out.println((text.substring(index-10,textLength-1)).replace('\n', ' '));
        }
        else if(index+len+10 < textLength) {
          for(int i = 0; i<10-index; ++i)
            System.out.print(" ");
          System.out.println(word);
          System.out.println((text.substring(0,index+len+10)).replace('\n', ' '));
        }
        else{
          for(int i = 0; i<10-index; ++i)
            System.out.print(" ");
          System.out.println(word);
          System.out.println((text.substring(0,textLength)).replace('\n', ' '));
        }
      }
    }
  }
  public static int wordSearch(String text, String word, int toffset) {
    int ooffset, len;
    int textLength = text.length();
    len = word.length();
    ooffset = 0;
    while(toffset+len < textLength) {
      if(text.regionMatches(true, toffset++, word, ooffset, len)) {
        return toffset-1;
      }
    }
    return -1;
  }
}
