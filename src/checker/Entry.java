package checker;

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
