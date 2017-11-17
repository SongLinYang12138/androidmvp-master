package com.ysl.mymvp.util;

import com.orhanobut.logger.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ysl on 2017/7/19.
 */
public class ServerClass {

    private static ServerSocket serverSocket;

    public static void receiveData() {

        try {
            if (serverSocket != null)
                return;
            serverSocket = new ServerSocket(9100);

            while (true) {
                Socket socket = serverSocket.accept();
                Logger.i("connect  " + socket.getInetAddress().getHostAddress() + "   " + socket.getInetAddress().getHostName());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "gb2312"));

                if (in.ready()) {
                    String msg = in.readLine();
                    Logger.i("msg  " + msg);
                }
                in.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
