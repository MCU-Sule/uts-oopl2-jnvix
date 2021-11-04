package com.jojo.util;

import javafx.scene.control.Alert;

/**
 * @author Jonathan-1672012
 */
public class ViewUtil {

    public static Alert createAlert(Alert.AlertType type, String content){
        Alert alert = new Alert(type);
        alert. setContentText(content);
        return alert;
    }
}
