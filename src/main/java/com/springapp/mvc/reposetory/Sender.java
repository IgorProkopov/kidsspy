package com.springapp.mvc.reposetory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;



public class Sender {

    private String ipAddress;

    public Sender(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private String makeRequest(String... params) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < params.length - 1; x++) {
            sb.append(params[x]);
            sb.append(" ");
        }
        sb.append(params[params.length - 1]);
        return sb.toString();
    }

    /**
     * ����� ��� �������� ����������� ������.
     * @param name ��� ������������
     * @param pass ������.
     * @return 1 - ���� ������ �����, 0 - ������ �����, -1 - ���� ������������ � ������ ������ �� ����������.
     */
    public int checkUser(String name, String pass) {
        return Integer.parseInt(sendRequest(makeRequest(name, pass), 8888));
    }

    /**
     * ����������� ������ ������������.
     * @param name ���.
     * @param pass ������.
     * @return
     */
    public String addNewUser(String name, String pass) {
        return sendRequest(makeRequest(name, pass), 7777);
    }

    /**
     * ��������� ���������.
     * @param name ���
     * @param date ����
     * @return
     */
    public String[] getCoordinates(String name, String date) {
        String corsFromServer = sendRequest(makeRequest(name, date), 6666);
        corsFromServer = corsFromServer.replace("[", "");
        corsFromServer = corsFromServer.replace("]", "");
        corsFromServer = corsFromServer.replace("\"", "");
        corsFromServer = corsFromServer.replace(",", " ");
        return corsFromServer.split(" ");
    }

    private String sendRequest(String data, int port) {
        String result;
        try {
            InetAddress ip = InetAddress.getByName(ipAddress);
            Socket socket = new Socket(ip, port);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            out.writeUTF(data);
            out.flush();
            result = in.readUTF();
            socket.close();
        } catch (Exception x) {
            System.err
                    .println("Server is not found, maiby ip is incorrect or server is turned off!");
            x.printStackTrace();
            return null;
        }
        return result;
    }

}
