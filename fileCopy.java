import java.io.*;

public class fileCopy {
	static File readfile = new File("./HOffice2022_Viewer.exe");
	static File writefile = new File("./write.exe");
	private static BufferedInputStream reader = null;
	private static BufferedOutputStream writer = null;

	public static void main(String[] args) throws IOException {
		Copy(4);
	}

	public static void Copy(int bufsize) throws IOException {
		long startTime = System.currentTimeMillis();
		reader = new BufferedInputStream(new FileInputStream(readfile), bufsize*1024);
		writer = new BufferedOutputStream(new FileOutputStream(writefile),bufsize*2048);
		while (true) {
			int bytedata = reader.read();
			if (bytedata == -1) {
				break;
			}
			writer.write(bytedata);
		}
		writer.close();
		reader.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Buffersize : " + bufsize + "kb\tTime : " + (endTime - startTime));
	}
}