
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HistoryController {

	private final String filePath = "history.ser";

	public void saveHistory(AnswerHistory aHistory) throws IOException {

		FileOutputStream fileOut = new FileOutputStream(filePath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(aHistory);
		out.close();
		fileOut.close();
	}

	public AnswerHistory loadHistory() throws ClassNotFoundException, IOException {
		AnswerHistory aHistory = null;
		FileInputStream fileIn = new FileInputStream(filePath);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		aHistory = (AnswerHistory) in.readObject();
		fileIn.close();
		in.close();

		return aHistory;

	}
}
