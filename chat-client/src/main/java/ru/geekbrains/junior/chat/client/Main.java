package ru.geekbrains.junior.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя: ");
        String name = scanner.nextLine();

        // возвращает текущий адрес машины
        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, 4300);
        Client client = new Client(socket, name);

        InetAddress inetAddress = socket.getInetAddress();// первой такой командой мы узнаем ip адрес для подключения, а для общения он уже меняется тк каждое отдельное общение идет по отдельным адресам

        System.out.println("InetAddress: " + inetAddress);
        String remoteIp = inetAddress.getHostAddress();
        System.out.println("Remote IP: " + remoteIp);
        System.out.println("LocalPort:" + socket.getLocalPort());

        client.listenForMessage();
        client.sendMessage();


    }
}
