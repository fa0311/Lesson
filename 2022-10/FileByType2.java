import java.io.File;

class FileByType2 {
    public static void main(String[] args) {
        String targetPath = ".";
        File targetFolder = new File(targetPath);
        File[] list = targetFolder.listFiles();
        if (list == null) {
            System.out.print("指定したフォルダが存在しませんでした");
            System.exit(1);
        }
        if (targetPath.endsWith("/")) {
            targetPath = targetPath.substring(0, targetPath.length() - 1);
        }
        ls(list, targetPath);
    }

    static void ls(File[] list, String currentDir) {
        for (int i = 0; i < list.length; i++) {
            String path = currentDir + "/" + list[i].getName();
            if (list[i].isDirectory()) {
                ls(list[i].listFiles(), path);
            }
            System.out.print(path);
            System.out.print("(" + list[i].length() + ")");
            System.out.println();
        }
    }
}
