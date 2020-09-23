class StringArray {
  int size = 0;
  String[] strArr = new String[size];
  public void add(String str) {
    String[] tempArr = new String[++size];
    System.arraycopy(strArr, 0, tempArr, 0, size-1);
    strArr = tempArr;
    strArr[size-1] = str;
  }
}
