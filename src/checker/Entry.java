package checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Entry {
	private String link = "";
	private String hoster = "";
	private String comment = "";
	private String status = "";
    public Entry() {
    }

    public Entry(String link, String hoster, String comment, String status) {
        this.link = link;
        this.hoster = hoster;
        this.comment = comment;
        this.status = status;
    }

    public static void save(File f, TableView<Entry> table) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		for(int i = 0; i < table.getItems().size(); i++) {
			writer.print(table.getItems().get(i).getLink() + ",");
			writer.print(table.getItems().get(i).getHoster() + ",");
			writer.print(table.getItems().get(i).getComment() + ",");
			writer.print(table.getItems().get(i).getStatus() + "\n");
		}
		writer.close();
    }

    public static void load(File f, TableView<Entry> table) throws FileNotFoundException, IOException{
        ObservableList<Entry> lst = FXCollections.observableArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] splt = line.split(",");
		    	lst.add(new Entry(splt[0], splt[1], splt[2], splt[3]));
		    }
		}

		table.setItems(lst);
    }
    public String getLink() {
    	return this.link;
    }
    public String getHoster() {
    	return this.hoster;
    }
    public String getComment() {
    	return this.comment;
    }
    public String getStatus() {
    	return this.status;
    }
    public void setLink(String link) {
    	this.link = link;
    }
    public void setHoster(String hoster) {
    	this.hoster = hoster;
    }
    public void setComment(String comment) {
    	this.comment = comment;
    }
    public void setStatus(String status) {
    	this.status = status;
    }

}
