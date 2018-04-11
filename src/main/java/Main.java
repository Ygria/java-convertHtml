import com.overzealous.remark.Remark;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        Remark remark = new Remark();
        Utils utils = new Utils();
        String outPath = "D:\\hexo\\source\\_posts\\";
        File[] files = utils.readFile();
        for(File f:files){
            String markdown = remark.convert(f);
            String filename = f.getName();
            filename = filename.substring(0,filename.length()-5)+".md";
            File file=new File(outPath+filename);
            OutputStream out=new FileOutputStream(file);
            byte b[]=(utils.generateHeader(f)+markdown).getBytes();
            out.write(b);
            out.close();
        }
    }
}

class Utils {
    File[] readFile() {
        List<File> fileList = new ArrayList<File>();
        File file = new File("C:\\Users\\ygria\\Desktop\\html");
        File[] files = file.listFiles();
        return files;

    }

    String generateHeader(File f) {

        String title = f.getName();
        title = title.substring(0, title.length() - 5);
        String header = "---\n" +
                "title: " + title + "\n" +
                "tags:\n" +
                "- 编程\n" +
                "- 2018\n" +
                "---\n";
        return header;
    }

   String for

}
