package tool;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main extends Contents {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);

	 // 削除するファイル指定
	Path p = Paths.get("");
	Path p2 = p.toAbsolutePath();
	String path = p2.toString()+"\\tmp\\log.txt";
    //String path = ("C:\\tmp\\sample.txt");

    File file = new File(path);

    String contents = readFile(file);
    System.out.println("【ファイルの内容】\n"+contents);

    StringBuilder sb = new StringBuilder();
    sb.append("【動作】\n検索文字列から特定の文字列までの間を削除します。\n");
    sb.append("検索文字列以降の文字を全て削除する場合は特定の文字列は何も入力しないままEnterを押して下さい。\n");
    sb.append("（入力例）検索文字列：cache 特定文字列：data \n");
    System.out.println(sb);

    System.out.print("検索文字列；");
    	String searchStr = sc.nextLine();
    System.out.print("特定文字列：");
    	String specificStr = sc.nextLine();
    	sc.close();

    if(specificStr == "") {
    	contents = deleteString(contents, searchStr);
    }else {
    	contents = deleteString(contents, searchStr,specificStr);
    }

    writeFile(file, contents);
    System.out.printf("\n[削除後]\n%s\n", contents);

  }

}
