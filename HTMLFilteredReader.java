class HTMLFilteredReader extends MySimpleURLReader {
  HTMLFilteredReader(String URL) {
    super(URL);
  }
  @Override
  public String getPageContents() {
    String filteredContent = new String();
    String unfcontent = new String(super.getPageContents());
    filteredContent = filterHTMLCode(unfcontent);
    filteredContent = filterHTMLPunct(filteredContent);
    return filteredContent;
  }
  public String getUnfilteredPageContents() {
    return super.getPageContents();
  }
  public static String filterHTMLCode(String HTMLtext) {
    int fi, li;
    String filteredContent = new String();
    String emptyStr = new String("");
    li = fi = 0;
    int lastIndex = HTMLtext.lastIndexOf('<');
    while(li < lastIndex){
      fi = HTMLtext.indexOf('>', li);
      li = HTMLtext.indexOf('<', fi+1);
      if(HTMLtext.indexOf('<',fi+1) < HTMLtext.indexOf('>', li)) {
        filteredContent = filteredContent.concat(HTMLtext.substring(fi+1, li));
        continue;
      }
    }
    return filteredContent;
  }
  public static String filterHTMLPunct(String text) {
    int fi, li;
    String filteredContent = new String();
    String emptyStr = new String("");
    li = fi = 0;
    int length = text.length();
    while(true) {
      li = text.indexOf('&', fi);
      if(li<0) {
        li = length;
        filteredContent = filteredContent.concat(text.substring(fi, li));
        break;
      }
      filteredContent = filteredContent.concat(text.substring(fi, li));
      fi = text.indexOf(';', li);
    }
    return filteredContent;
  }
}
