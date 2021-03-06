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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;


public class Controller{
	@FXML private TableView<Entry> table;
	@FXML private TableColumn<Entry, String> link;
	@FXML private TableColumn<Entry, String> hoster;
	@FXML private TableColumn<Entry, String> comment;
	@FXML private TableColumn<Entry, String> status;
	@FXML private TextField linkfield;
	@FXML private TextField commentfield;
	@FXML private ProgressBar progressbar;
	
	ObservableList<Entry> lst = FXCollections.observableArrayList();
	
	
	public void turn_editable() {
		link.setCellFactory(TextFieldTableCell.forTableColumn());
		comment.setCellFactory(TextFieldTableCell.forTableColumn());;
	}

	
	public void check(ActionEvent e) throws IOException {
	    Thread t1 = new Thread(new Checktask(progressbar, table));
        t1.start();
	}
	
	
	public void load(ActionEvent e) throws FileNotFoundException, IOException {
		turn_editable();
		link.setCellValueFactory(new PropertyValueFactory<Entry, String>("link"));
		hoster.setCellValueFactory(new PropertyValueFactory<Entry, String>("hoster"));
		comment.setCellValueFactory(new PropertyValueFactory<Entry, String>("comment"));
		status.setCellValueFactory(new PropertyValueFactory<Entry, String>("status"));
		
		FileChooser chooser = new FileChooser();
		File f = chooser.showOpenDialog(null);
		
		Entry.load(f, table);
		setRowColor();
	}
	
	
	public void save(ActionEvent e) throws FileNotFoundException, UnsupportedEncodingException {
		FileChooser chooser = new FileChooser();
		File f = chooser.showSaveDialog(null);
		Entry.save(f, table);
	}
	
	
	public void add(ActionEvent e) throws IOException {
		turn_editable();
		link.setCellValueFactory(new PropertyValueFactory<Entry, String>("link"));
		hoster.setCellValueFactory(new PropertyValueFactory<Entry, String>("hoster"));
		comment.setCellValueFactory(new PropertyValueFactory<Entry, String>("comment"));
		status.setCellValueFactory(new PropertyValueFactory<Entry, String>("status"));
		
		String link = linkfield.getText();
		String comment = commentfield.getText().replace(",", ";");
		String status = "UNKNOWN";
		String hoster = "UNKNOWN";
		
		if(link.split("/")[2].equals("rg.to") || link.split("/")[2].equals("rapidgator.net")) {
			hoster = "Rapidgator";
			if(Check.rgcheck(link) == true) {
				status = "UP";
			}else {
				status = "DOWN";
			}
		}else if(link.split("/")[2].equals("ddownload.com")) {
			hoster = "ddownload";
			if(Check.ddlcheck(link) == true) {
				status = "UP";
			}else {
				status = "DOWN";
			}
		}else if(link.split("/")[2].equals("nitroflare.com")) {
			hoster = "nitroflare";
			if(Check.nitroflarecheck(link) == true) {
				status = "UP";
			}else {
				status = "DOWN";
			}
		}
		lst.add(new Entry(link, hoster, comment, status));
		table.setItems(lst);

		linkfield.clear();
		commentfield.clear();
		setRowColor();
	}
	
	
	public void setRowColor() {
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
	
	
	public void delete(ActionEvent e) {
		Entry selectedItem = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(selectedItem);
	}

	
	public void saveCommentOnEdit(CellEditEvent e) {
		Entry ent = table.getSelectionModel().getSelectedItem();
		ent.setComment(e.getNewValue().toString());
	}
	
	
	public void saveLinkOnEdit(CellEditEvent e) {
		Entry ent = table.getSelectionModel().getSelectedItem();
		ent.setLink(e.getNewValue().toString());
	}
}
