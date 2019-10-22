package com.xmzpc.protocol.http;

import com.alibaba.fastjson.JSONObject;

import com.xmzpc.framework.Invocation;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.*;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {

        try {


            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
