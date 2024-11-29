import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Solution {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888);
             Socket socket = server.accept();
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();

             Scanner scanner = new Scanner(is)) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "gbk"), true);
            pw.println("你好啊，欢迎关注「沉默王二」 公众号，回复关键字「2048」 领取程序员进阶必读资料包");

            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                if ("2048".equals(line)) {
                    done = true;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

