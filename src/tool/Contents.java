package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// ファイル内容関連
public class Contents extends Search {

  // ファイル内容読み込み
  public static String readFile(File file) {

    // cntLine() : 引数のファイルの内容が何行あるか取得
    // 取得した行数分の要素を持つ配列を生成
    String[] content = new String[cntLine(file)];

    try {
      // BufferdReader インスタンス生成
      BufferedReader br = new BufferedReader(new FileReader(file));

      int i = 0;
      String str = br.readLine(); // 1行分の文字列を取得
      while ((str != null)) { // 最終行まで繰り返し
        content[i++] = str; // 取得している1行分の文字列を配列に代入
        str = br.readLine(); // 次の行を取得
      }
      br.close();

    } catch (Exception e) { // 例外処理
      e.printStackTrace();
      System.exit(0);
    }

    StringBuilder sb = new StringBuilder();
    // 1行ごとに取得したので改行を入れる
    for (String str : content) {
      sb.append(str).append("\n");
    }

    return sb.toString();// 引数のファイル内容を戻す
  }

  // ファイル書き込み
  public static void writeFile(File file, String contents) {

    try {
      // FileWriter インスタンス生成
      FileWriter fw = new FileWriter(file); // 第二引数 true で追記、省略で上書き
      PrintWriter pw = new PrintWriter(new BufferedWriter(fw)); // PrintWriter インスタンス生成
      pw.println(contents); // 書き込み
      pw.close();

    } catch (Exception e) { // 例外処理
      e.printStackTrace();
      System.exit(0); // 実行停止

    }
  }

  // ファイル内容の行数カウント
  public static int cntLine(File file) {
    int i = 0; // 行数

    try {
      // BufferdReader インスタンス生成
      BufferedReader br = new BufferedReader(new FileReader(file));

      String str = br.readLine(); // 1行分の文字列を取得
      while ((str != null)) { // 最終行まで繰り返す
        i++; // カウント
        str = br.readLine(); // 次の行を取得
      }
      br.close();

    } catch (Exception e) { // 例外処理
      e.printStackTrace();
      System.exit(0); // 実行停止
    }

    return i; // 引数のファイル内容が何行か戻す
  }

}
