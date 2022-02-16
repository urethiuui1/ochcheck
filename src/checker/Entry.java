package checker;

public class Entry {
	String link = "R";
	String hoster = "L";
	String comment = "R";
	String status = "L";
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