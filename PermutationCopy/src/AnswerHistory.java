import java.io.Serializable;
import java.util.ArrayList;

public class AnswerHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	ArrayList<HistoryButton> historyList = new ArrayList<>();

	public void addHistory(HistoryButton hButton) {
		historyList.add(hButton);
		System.out.println("adsfasdf");
		for (int i = 0; i < historyList.size(); i++) {
			System.out.println(historyList.get(i).r);
		}

	}

	public void clearHistory() {
		historyList.clear();
	}

	public void print() {
		System.out.println("headsfsadf");
	}
}
