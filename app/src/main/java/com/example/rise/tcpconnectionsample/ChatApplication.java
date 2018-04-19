package com.example.rise.tcpconnectionsample;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


/**
 * Created by Rise on 19/04/2018.
 */

public class ChatApplication extends Application {

    private Socket mSocket;
    {
        try{
            mSocket = IO.socket(Constants.CHAT_SERVER_URL);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket(){return mSocket;}
}
