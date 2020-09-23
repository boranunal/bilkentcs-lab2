import cs1.SimpleURLReader;
import java.util.Scanner;
class Main {
  public static void main(String args[]) {
    int i = 0;
    int opt;
    //String url = new String("https://raw.githubusercontent.com/boranunal/bilkent-cs102-lab1/master/lab1.txt");
    //String url = new String("https://en.wikipedia.org/wiki/LGBT");
    //String url = new String("https://www.dictionary.com/browse/image");
    String url = new String();
    String str = new String();
    if(0 < args.length)
      url = args[0];
    else {
      System.out.println("Since you did not provide an url default url is used.");
      url = "https://en.wikipedia.org/wiki/LGBT";
    }
    HTMLFilteredReader htmlFR = new HTMLFilteredReader(url);
    Scanner input = new Scanner(System.in);
    Scanner strInput = new Scanner(System.in);
    StringArray strArr = new StringArray();
    while(true) {
      System.out.println("1. print raw content\n2. print filtered content\n" +
                         "3. search a set of words in the filtered content\n" +
                         "4. details about links on the page\n5. details " +
                         "about images on the page\n0. quit");
      opt = input.nextInt();
      if(opt == 0) break;
      switch(opt) {
        case 1:
          System.out.println(htmlFR.getUnfilteredPageContents());
          break;
        case 2:
          System.out.println(htmlFR.getPageContents());
          break;
        case 3:
          while(true) {
            System.out.print("enter word (enter q to end input): ");
            str = strInput.next();
            if(str.equals("q"))
              break;
            strArr.add(str);
          }
          Search.wordSearch(htmlFR.getPageContents(), strArr.strArr);
          break;
        case 4:
          HTMLImgNLinks.htmlLink(htmlFR.getUnfilteredPageContents());
          break;
        case 5:
          HTMLImgNLinks.htmlImg(htmlFR.getUnfilteredPageContents());
          break;
        default:
          System.out.println("Invalid input");
      }
    }
  }
}
