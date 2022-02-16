# OCH-Check
A simple Java GUI application to monitor if a file which is hosted at a one-click hoster is up or down.
I used javafx-sdk-17.0.2 for the GUI.

## Supported hosters
- Rapidgator
- ddownload
- nitroflare

![checkedemo](https://user-images.githubusercontent.com/81405270/152790177-cac570aa-afba-4dab-a154-b7387e09614a.gif)

## Usecase
With hosting providers like Rapidgator your uploaded files get deleted after a certain period of time without any downloads.
This tool helps you to track which files got deleted because of inactivety so you know which files you have to re-upload.

## Usage
- Manually add single links with the form at the bottom
- Delete an entry by selecting it and clicking the "delete" button
- Editing an entry by double-clicking it
- Save all links to a file
- Load all links from a file
- Click the "check" button to start the checking process

## Requirements to run the jar
- openjfx
```
sudo apt install openjfx
```

## Run the application with maven
```
mvn clean javafx:run
```
