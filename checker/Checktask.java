package checker;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

public class Checktask extends Thread{
	Checktask(ProgressBar progressbar, TableView<Entry> table){
		this.progressbar = progressbar;
		this.table = table;
	}
	ProgressBar progressbar;
	TableView<Entry> table;

	public void run() {
		ObservableList<Entry> lst;
		Double progress = 0.0;
		lst = table.getItems();
		
		progressbar.setOpacity(1);
		
		for(int i = 0; i < lst.size(); i++) {
			progress = ((double)i / (double)lst.size());
			progressbar.setProgress(progress);
			String link = lst.get(i).getLink();
			if(link.split("/")[2].equals("rg.to") || link.split("/")[2].equals("rapidgator.net")) {
				try {
					if(Check.rgcheck(link) == true) {
						lst.get(i).setStatus("UP");
					}else {
						lst.get(i).setStatus("DOWN");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(link.split("/")[2].equals("ddownload.com")) {
				try {
					if(Check.ddlcheck(link) == true) {
						lst.get(i).setStatus("UP");
					}else {
						lst.get(i).setStatus("DOWN");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(link.split("/")[2].equals("nitroflare.com")) {
				try {
					if(Check.nitroflarecheck(link) == true) {
						lst.get(i).setStatus("UP");
					}else {
						lst.get(i).setStatus("DOWN");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		progressbar.setOpacity(0);
		table.setItems(lst);		
		table.setRowFactory(tv -> new TableRow<Entry>() {
		    @Override
		    protected void updateItem(Entry item, boolean empty) {
		        super.updateItem(item, empty);
		        if (item == null || item.getStatus().equals("UNKNOWN"))
		            setStyle("");
		        else if (item.getStatus().equals("UP"))
		            setStyle("-fx-background-color: #00ff00;");
		        else if (item.getStatus().equals("DOWN"))
		            setStyle("-fx-background-color: #ff0000;");
		        else
		            setStyle("");
		    }
		});
		table.refresh();

	  }
}
