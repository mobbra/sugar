package com.orm;

import android.content.Context;

public class SugarApp {

    private Database database;
    private static SugarApp sugarContext;
    
    public SugarApp(Context context){
        SugarApp.sugarContext = this;
        this.database = new Database(context);
    }

    /*
     * Per issue #106 on Github, this method won't be called in
     * any real Android device. This method is used purely in
     * emulated process environments such as an emulator or
     * Robolectric Android mock.
     */
    public void onTerminate(){
        if (this.database != null) {
            this.database.getDB().close();
        }
    }

    public static SugarApp getSugarContext(){
        return sugarContext;
    }

    protected Database getDatabase() {
        return database;
    }
}
