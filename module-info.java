module checker {
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	exports checker to javafx.graphics;
	opens checker;
}