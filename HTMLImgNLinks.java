class HTMLImgNLinks {
  public static void htmlImg(String htmlcontent) {
    int ind;
    int index = 0;
    String src = new String();
    String alt = new String();
    int length = htmlcontent.length();
    while(index+8 < length) {
      index = Search.wordSearch(htmlcontent, "<img", index);
      if(index > 0) {
        ind = Search.wordSearch(htmlcontent, "src", index);
        src = htmlcontent.substring(ind+5, htmlcontent.indexOf('\"', ind+6));
        index = Search.wordSearch(htmlcontent, "alt", index);
        alt = htmlcontent.substring(index+5, htmlcontent.indexOf('\"', index+6));
        System.out.println("src = " + src + "\nalt = " + alt);
      }
    else break;
    }
  }
  public static void htmlLink(String htmlcontent) {
    int ind;
    int index = 0;
    String address = new String();
    String linkText = new String();
    int length = htmlcontent.length();
    while(index+8 < length) {
      index = Search.wordSearch(htmlcontent, "<a ", index);
      if(index > 0) {
        ind = Search.wordSearch(htmlcontent, "href", index);
        address = htmlcontent.substring(ind+6, htmlcontent.indexOf('\"', ind+7));
        linkText = htmlcontent.substring(index-1, Search.wordSearch(htmlcontent, "</a", (index++)+1)+4);
        linkText = HTMLFilteredReader.filterHTMLCode(linkText);
        System.out.println("address = " + address + "\nlink text = " + linkText);
      }
      else break;
    }
  }
}
