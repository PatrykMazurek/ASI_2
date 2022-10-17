package up;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class packageZIP {

    public void packageArchive(File[] files, String zipName){
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
            zipOut.setLevel(9);
            zipOut.setMethod(ZipOutputStream.STORED);
            if( files.length > 1){
                for (File f : files){
                    ZipEntry zipE = new ZipEntry(f.getName());
                    zipOut.putNextEntry(zipE);
                    FileInputStream fIn = new FileInputStream(f);
//                    zipOut.write(fIn.readAllBytes());
                    // alternatywna wersja dla readAllBytes()
                    // dla java 1.8
                    byte[] buff = new byte[2048];
                    int len;
                    while(( len = fIn.read(buff)) >= 0 ){
                        zipOut.write(buff, 0, len);
                    }
                    zipOut.closeEntry();
                }
                zipOut.flush();
                zipOut.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unpackageArchive(Path dlocation, String zipName){
        try {
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName));
            ZipEntry zipE;
            while ((zipE = zipIn.getNextEntry()) != null){
                FileOutputStream fOut =
                        new FileOutputStream(
                                new File(dlocation.toString(), zipE.getName()));
//                fOut.write(zipIn.readAllBytes());
                // wersja alternatywna dla java 1.8
                byte[] buff = new byte[2048];
                int len;
                while ((len = zipIn.read(buff)) >= 0 ){
                    fOut.write(buff,0, len);
                }
                fOut.flush();
                fOut.close();
                zipIn.closeEntry();
            }
            zipIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
