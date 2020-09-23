import cs1.SimpleURLReader;
class MySimpleURLReader extends SimpleURLReader {
  String url = new String();
  MySimpleURLReader(String URL) {
    super(URL);
    url = URL;
  }
  protected String getURL() {
    return url;
  }
  protected String getName() {
    return url.substring(url.lastIndexOf('/')+1);
  }
  @Override
  public String getPageContents() {
    String str = new String(super.getPageContents());
    String subStr = new String();
    subStr = str.substring(4);
    return subStr;
  }
}
