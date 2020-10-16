package ch.so.agi.oereb.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SettingsServiceAsync {
    void settingsServer(AsyncCallback<SettingsResponse> callback)
            throws IllegalArgumentException;
}
