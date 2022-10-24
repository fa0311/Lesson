import java.io.File;

class FileByType {
    public static void main(String[] args) {
        String targetPath = ".";
        File targetFolder = new File(targetPath);
        File[] list = targetFolder.listFiles();
        if (list == null) {
            System.out.print("指定したフォルダが存在しませんでした");
            System.exit(1);
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                System.out.print("ファイル：");
            } else if (list[i].isDirectory()) {
                System.out.print("フォルダ：");
            }
            System.out.print(list[i].getName());
            System.out.print("(" + list[i].length() + ")");
            System.out.println();
        }
    }
}
