package javadaogenerator;

import java.io.RandomAccessFile;

public class FileUtil {

	public static void createFile(String path, String cnt) throws Exception {
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		raf.write(cnt.getBytes());
		raf.close();
	}
}
