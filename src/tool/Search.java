package tool;

// 文字列検索関連
public class Search {

  // contents : 本文
  // searchString : 検索文字列
  // specificString : 特定文字列

  // 検索文字列以降を本文から削除
  public static String deleteString(String contents, String searchString) {

    // 本文の何文字目に検索文字列が出現するかを取得
    int searchResult = stringSearch(contents, searchString);

    try { // 削除に成功した場合
      contents = contents.substring(0, searchResult); // 削除した結果
      System.out.println(" > キャッシュの削除に成功しました。");
      return contents; // 削除後の本文を戻す

    } catch (Exception e) { // 削除に失敗した場合
      System.out.println(" > キャッシュの削除に失敗しました。");
      return contents; // 削除前の本文を戻す

    }
  }

  // 検索文字列から特定文字列までを削除
  public static String deleteString(String contents, String searchString, String specificString) {

    int searchResult = stringSearch(contents, searchString); // 検索文字列が出現する文字数
    int specificResult = stringSearch_Behind(contents, specificString); // 特定文字列が出現する文字数（後ろから検索）

    try { // 削除に成功した場合
      String content = contents.substring(0, searchResult); // 最初の文字から検索文字列前までを抽出
      contents.substring(specificResult);
      String content3 = contents.substring(specificResult+specificString.length());// 特定の文字列以降の文字列を抽出
      contents = content+"\n\n" + content3; // 削除した結果
      System.out.println(" > キャッシュの削除に成功しました。");
      return contents; // 削除後の本文を戻す

    } catch (Exception e) { // 削除に失敗した場合
      System.out.println(" > キャッシュの削除に失敗しました。");
      return contents; // 削除前の本文を戻す

    }
  }

  // 文字列検索
  public static int stringSearch(String contents, String searchString) {

    // 検索文字列が出現した位置（開始位置:0）
    int result = contents.indexOf(searchString);

    if (result == -1) { // 検索文字列が見つからなかった場合
      System.out.printf(" > 検索文字列｛%s｝は見つかりませんでした。\n", searchString);
      return result;
    }

    return result+searchString.length(); // 本文の何文字目に出現したかを戻す
  }

  // 文字列検索（後ろから検索）
  public static int stringSearch_Behind(String contents, String searchString) {

    // 検索文字列が出現した位置（開始位置:0）
    int result = contents.lastIndexOf(searchString);

    if (result == -1) { // 検索文字列が見つからなかった場合
      System.out.printf(" > 検索文字列｛%s｝は見つかりませんでした。\n", searchString);
      return result;
    }

    return result-searchString.length(); // 本文の何文字目に出現したかを戻す
  }

}
