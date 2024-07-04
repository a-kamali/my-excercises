package ir.maktab;

import java.io.File;

        public class Main {
            public static void main(String[] args) {
                File file = new File("C:\\Program Files (x86)");

                System.out.println(getFolderSize(file)/1024/1024);
            }
            private static float getFolderSize(File folder) {
                float length = 0;
                File[] files = folder.listFiles();

                int count = files.length;

                for (int i = 0; i < count; i++) {
                    if (files[i].isFile()) {
                        length += files[i].length();
                    }
                    else {
                        length += getFolderSize(files[i]);
                    }
                }
                return length;
            }
        }