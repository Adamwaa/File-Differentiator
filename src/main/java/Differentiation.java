import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Differentiation extends Hex {

    private Hex hexValue = new Hex();

    public Differentiation() {

    }


    public void checker() throws IOException {

        int a = 0;
        String extensionTest = " ";
        System.out.println("Enter the path to the folder with files: ");
        Scanner scanner = new Scanner(System.in);

        String paths = scanner.nextLine();

        String extension;
        StringBuilder hex;
        File folder = new File(paths);
        File[] files = folder.listFiles();

        if (files.length == 0) {
            System.out.println("This folder is empty. Please choose a folder that is not empty!!");
        } else {
            for (File file : files) {
                a++;
                String newPath = paths + "\\" + file.getName();
                extension = newPath.substring(newPath.lastIndexOf(".") + 1);

                try {
                    hex = hexValue.hexConversion(file);
                    if (!extension.equals("txt")) {
                        System.out.println("Nr. " + a + " FILE NAME IS " + file.getName() + "\n    Extension: " + extension + " Magic number: " + hex.substring(0, 11));
                    } else {
                        System.out.println("Nr. " + a + " FILE NAME IS " + file.getName() + "\n    Extension: " + extension);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                    System.out.println("Folder path was incorrect");
                    checker();
                }
            }

                System.out.print("Enter the nr. of file for checking extension: ");
                int fileNumber = scanner.nextInt();
                System.out.println("""
                        With format choose to compare?:\s
                        1 - PDF
                        2 - JGP
                        3 - GIF
                        4 - TXT""");

                int format = scanner.nextInt();

                switch (format) {
                    case 1 -> extensionTest = "89 50 4E 47";
                    case 2 -> extensionTest = "FF D8 FF E0";
                    case 3 -> extensionTest = "47 49 46 38";
                    case 4 -> extensionTest = "txt";
                }

                File b = files[fileNumber - 1];

                String newPath = b.getName();
                extension = newPath.substring(newPath.lastIndexOf(".") + 1);

                hex = hexValue.hexConversion(b);
                String pdfHex = String.valueOf(hex);

                if (!extension.equals("txt")) {
                    if (pdfHex.substring(0, 11).equals(extensionTest)) {
                        System.out.println(b.getName() + " File has the same it's the same extanstion that " + hex.substring(0, 11));
                    } else {
                        System.out.println("File extension is not the same with the compare one\n" +
                                "File magic number: " + hex.substring(0, 11) +
                                "\nCompare magic number: " + extensionTest);
                    }
                } else {

                    if (extension.equals(extensionTest)) {
                        System.out.println("File is txt");
                    } else {
                        System.out.println("file is not the same to compare one");
                    }
                }
            }
        }
    }
